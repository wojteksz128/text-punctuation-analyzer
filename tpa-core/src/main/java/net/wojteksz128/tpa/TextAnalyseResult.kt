package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.part.TextPart

data class TextAnalyseResult(
    val text: String,
    val textParts: List<TextPart>,
    val possibleChanges: List<PossibleChange>
)
