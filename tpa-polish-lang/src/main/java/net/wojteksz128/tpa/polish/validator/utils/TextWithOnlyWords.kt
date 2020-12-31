package net.wojteksz128.tpa.polish.validator.utils

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word

data class TextWithOnlyWords(val analyseData: TextAnalyseData) {
    val text: String
    val sourceTextWordsInInternalTextMap: Map<Long, AwareOfSurroundings<Word>>

    init {
        sourceTextWordsInInternalTextMap = prepareWordsMap(analyseData.words)
        text =
            sourceTextWordsInInternalTextMap.values.joinToString(analyseData.languageAlphabet.separators.first()) { it.get() }
    }

    private fun prepareWordsMap(words: List<AwareOfSurroundings<Word>>): Map<Long, AwareOfSurroundings<Word>> {
        val map = mutableMapOf<Long, AwareOfSurroundings<Word>>()
        val remainingWords = words.toMutableList()
        var positionWithOriginalMove: Long = 0
        var previousWord: AwareOfSurroundings<Word>? = null

        while (remainingWords.isNotEmpty()) {
            val word = remainingWords.removeAt(0)
            positionWithOriginalMove += previousWord?.let { word.startAt - it.endAt - 2 } ?: word.startAt
            map[word.startAt - positionWithOriginalMove] = word
            previousWord = word
        }

        return map.toMap()
    }
}