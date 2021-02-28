package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.polish.validator.utils.TextWithOnlyWords
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word
import kotlin.math.max
import kotlin.math.min

class PhraseFinder(phrase: String, excludePhrases: List<String>) {
    private val pattern = Regex("(?<=^| )(${phrase.toUpperCase()})(?= |$)")
    private val excludes = prepareExcludePhrasesPatterns(excludePhrases)

    fun findPhrase(textWithOnlyWords: TextWithOnlyWords): Sequence<List<AwareOfSurroundings<Word>>> {
        val input = textWithOnlyWords.text.toUpperCase()
        return pattern.findAll(input)
            .filter { found -> excludes.none { it.isPartOnExcluded(found, input) } }
            .map { getOriginalWordsInRangeFromMatchResult(it, textWithOnlyWords) }
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

    private fun prepareExcludePhrasesPatterns(excludePhrases: List<String>) =
        excludePhrases.map { ExcludePhrase(it.toUpperCase(), pattern) }.toSet()


    private class ExcludePhrase(private val excludeText: String, baseText: Regex) {
        private val beforeBaseChars: Int
        private val afterBaseChars: Int

        init {
            val baseTextRangeInExcluded = "(?<=^| )$baseText(?= |\$)".toRegex().find(excludeText)!!.range
            beforeBaseChars = baseTextRangeInExcluded.first
            afterBaseChars = excludeText.lastIndex - baseTextRangeInExcluded.last
        }

        fun isPartOnExcluded(matchResult: MatchResult, input: String): Boolean {
            val resultRange = matchResult.range
            val newRange = max(resultRange.first - beforeBaseChars, 0)..min(resultRange.last, input.lastIndex)
            return input.subSequence(newRange) == excludeText
        }
    }
}
