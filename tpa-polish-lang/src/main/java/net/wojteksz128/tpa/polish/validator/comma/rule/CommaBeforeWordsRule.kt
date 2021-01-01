package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.utils.TextWithOnlyWords
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word

// TODO: 27.12.2020 Przygotuj testy
open class CommaBeforeWordsRule(ruleExpectedText: String) : CommaRule {
    private val pattern: Regex =
        Regex("(\\W(${ruleExpectedText.toUpperCase()})\\W|^(${ruleExpectedText.toUpperCase()})\\W)")

    override fun check(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        val foundPatterns = findExpectedPatternInData(analyseData)
        val foundPatternsWithAndWithoutCommas = foundPatterns.groupBy { hasCommaBeforeWord(it) }

        possibleChanges += convertFoundsWithoutCommaIntoPossibleChange(foundPatternsWithAndWithoutCommas[false])
        possibleChanges += findFoundsWithInvalidCommaAndSpaceOrder(foundPatternsWithAndWithoutCommas[true])

        return possibleChanges.toList()
    }

    protected fun findExpectedPatternInData(analyseData: TextAnalyseData): Sequence<List<AwareOfSurroundings<Word>>> {
        val textWithOnlyWords = TextWithOnlyWords(analyseData)
        val patternMatches = pattern.findAll(textWithOnlyWords.text.toUpperCase())
        return patternMatches.map { getOriginalWordsInRangeFromMatchResult(it, textWithOnlyWords) }
    }

    private fun getOriginalWordsInRangeFromMatchResult(matchResult: MatchResult, textWithOnlyWords: TextWithOnlyWords)
            : List<AwareOfSurroundings<Word>> {
        val words = mutableListOf<AwareOfSurroundings<Word>>()
        matchResult.range.forEach { position ->
            if (textWithOnlyWords.sourceTextWordsInInternalTextMap.containsKey(position.toLong())) {
                textWithOnlyWords.sourceTextWordsInInternalTextMap[position.toLong()]?.let { words.add(it) }
            }
        }
        return words.toList()
    }

    protected fun hasCommaBeforeWord(words: List<AwareOfSurroundings<Word>>): Boolean =
        words.first().partsBetweenEarlierWord.any { it.get() == "," }

    protected fun convertFoundsWithoutCommaIntoPossibleChange(foundsWithoutComma: List<List<AwareOfSurroundings<Word>>>?) =
        foundsWithoutComma?.let { foundWords ->
            foundWords.mapNotNull { it.first().partsBetweenEarlierWord.firstOrNull()?.startAt }
                .map { PossibleChange(ChangeType.INSERT, it, new = ",") }
        } ?: listOf()

    protected fun findFoundsWithInvalidCommaAndSpaceOrder(foundsWithComma: List<List<AwareOfSurroundings<Word>>>?) =
        foundsWithComma?.let { foundWords ->
            foundWords.filter { hasBeforeExactCommaAndSeparator(it) }
                .map { words ->
                    val earlierWord = words.first().partsBetweenEarlierWord
                    Pair(earlierWord.first().startAt, earlierWord.joinToString("") { it.get() })
                }
                .map { PossibleChange(ChangeType.REPLACE, it.first, it.second, ", ") }
        } ?: listOf()

    private fun hasBeforeExactCommaAndSeparator(words: List<AwareOfSurroundings<Word>>): Boolean {
        val beforeWords = words.first().partsBetweenEarlierWord
        return !(beforeWords.size == 2 && beforeWords.joinToString("") { it.get() } == ", ")
    }
}