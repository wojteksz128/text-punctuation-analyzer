package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.polish.validator.Sentence
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName
import net.wojteksz128.tpa.polish.validator.utils.TextWithOnlyWords
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.text.part.Word

// TODO: 09.01.2021 Przenieś do tpa-core
// TODO: 09.01.2021 Przygotuj testy
open class Rule private constructor(
    private val punctuationMark: String,
    phrase: String,
    private val phraseFilters: MutableList<(List<AwareOfSurroundings<Word>>) -> Boolean>
) {
    private val pattern: Regex =
        Regex("(\\W(${phrase.toUpperCase()})\\W|^(${phrase.toUpperCase()})\\W)")

    fun check(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        val (patternsWithoutMark, patternsWithMark) = findExpectedPatternInData(analyseData)

        possibleChanges += convertFoundsWithoutMarkIntoPossibleChange(patternsWithoutMark, analyseData)
        possibleChanges += findFoundsWithInvalidMarkAndSpaceOrder(patternsWithMark)

        return possibleChanges
    }

    private fun findExpectedPatternInData(analyseData: TextAnalyseData): Pair<List<List<AwareOfSurroundings<Word>>>, List<List<AwareOfSurroundings<Word>>>> {
        val textWithOnlyWords = TextWithOnlyWords(analyseData)
        var map = pattern.findAll(textWithOnlyWords.text.toUpperCase())
            .map { getOriginalWordsInRangeFromMatchResult(it, textWithOnlyWords) }
        phraseFilters.forEach { phraseFilter -> map = map.filter { phraseFilter(it) } }
        val groupBy = map.groupBy { hasMarkBeforeWord(it) }
        return Pair(groupBy[false] ?: listOf(), groupBy[true] ?: listOf())
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

    private fun hasMarkBeforeWord(words: List<AwareOfSurroundings<Word>>): Boolean =
        words.first().partsBetweenEarlierWord.any { it.text == punctuationMark }

    private fun convertFoundsWithoutMarkIntoPossibleChange(
        foundsWithoutMark: List<List<AwareOfSurroundings<Word>>>?,
        analyseData: TextAnalyseData
    ): List<PossibleChange> {
        val sentences =
            analyseData.additionalParts[PolishAdditionalPartsName.SENTENCE_GROUP.name]?.map { it as Sentence }
                ?: listOf()

        return foundsWithoutMark?.let { foundWords ->
            foundWords.map { foundPhrase ->
                Pair(
                    foundPhrase,
                    sentences.find { it.range.contains(foundPhrase.first().startAt) }!!
                )
            }
                .flatMap { (foundPhrase, sentence) ->
                    if (sentence.firstWord == foundPhrase.first()) listOf(
                        foundPhrase.first().partsBetweenEarlierWord.firstOrNull(),
                        sentence.lastWord.partsBetweenLaterWord.firstOrNull()
                    )
                    else listOf(foundPhrase.first().partsBetweenEarlierWord.firstOrNull())
                }
                .mapNotNull { createPossibleInsertOrReplaceChangeFor(it, analyseData.languageAlphabet) }
        } ?: listOf()
    }

    private fun createPossibleInsertOrReplaceChangeFor(sign: TextPart?, languageAlphabet: LanguageAlphabet) =
        sign?.let {
            if (languageAlphabet.separators.contains(it.text)) {
                PossibleChange(ChangeType.INSERT, it.startAt, new = punctuationMark)
            } else {
                PossibleChange(ChangeType.REPLACE, it.startAt, it.text, punctuationMark)
            }
        }

    private fun findFoundsWithInvalidMarkAndSpaceOrder(foundsWithMark: List<List<AwareOfSurroundings<Word>>>?) =
        foundsWithMark?.let { foundWords ->
            foundWords.filter { hasBeforeExactCommaAndSeparator(it) }
                .map { words ->
                    val earlierWord = words.first().partsBetweenEarlierWord
                    Pair(earlierWord.first().startAt, earlierWord.joinToString("") { it.text })
                }
                .map { PossibleChange(ChangeType.REPLACE, it.first, it.second, "$punctuationMark ") }
        } ?: listOf()

    private fun hasBeforeExactCommaAndSeparator(words: List<AwareOfSurroundings<Word>>): Boolean {
        val beforeWords = words.first().partsBetweenEarlierWord
        return !(beforeWords.size == 2 && beforeWords.joinToString("") { it.text } == "$punctuationMark ")
    }


    class Builder {
        private lateinit var phrase: String
        private lateinit var punctuationMark: String
        private val phraseFilters = mutableListOf<(List<AwareOfSurroundings<Word>>) -> Boolean>()

        fun forPunctuationMark(punctuationMark: String) = apply { this.punctuationMark = punctuationMark }

        fun markBeforePhrase(phrase: String) = apply { this.phrase = phrase }

        fun phraseIsNot(phraseFilter: (List<AwareOfSurroundings<Word>>) -> Boolean) = apply {
            phraseFilters.add { !phraseFilter(it) }
        }

        fun build() = Rule(punctuationMark, phrase, phraseFilters)
    }
}
