package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

data class TextAnalyseResult(val text: String, val textParts: List<TextPart> = listOf()) {

    val punctuationMarks = textParts.filterIsInstance<PunctuationMark>()
    val words = textParts.filterIsInstance<Word>()
    val additionalParts = mutableMapOf<String, List<*>>()

    val possibleChanges = mutableListOf<PossibleChange>()
}
