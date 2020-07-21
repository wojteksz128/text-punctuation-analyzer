package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.TextAnalyseResult

interface TextValidator {
    fun validate(text: TextAnalyseResult): List<PossibleChange>
}
