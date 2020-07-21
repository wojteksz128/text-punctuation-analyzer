package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

data class TextAnalyseResult(val text: String) {

    val textParts = mutableListOf<TextPart>()
    val punctuationMarks = mutableListOf<PunctuationMark>()
    val words = mutableListOf<Word>()
    val possibleChanges = mutableListOf<PossibleChange>()
}
