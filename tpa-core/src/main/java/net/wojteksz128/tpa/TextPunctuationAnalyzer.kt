package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.text.split.TextDivider

open class TextPunctuationAnalyzer(private val textDivider: TextDivider) {

    fun analyze(text: String): TextAnalyseResult {
        val result = TextAnalyseResult(text)
        result.textParts += textDivider.divide(text)
        result.words += result.textParts.filterIsInstance<Word>()
        result.punctuationMarks += result.textParts.filterIsInstance<PunctuationMark>()
        return result
    }
}