package net.wojteksz128.tpa.polish.test.model

import net.wojteksz128.tpa.text.PossibleChange

data class TextAnalyzeResultDto(
    val textId: String,
    val solution: List<PossibleChange>,
    val textParts: List<TextPartDto>,
    val executionTimeMillis: Long
)