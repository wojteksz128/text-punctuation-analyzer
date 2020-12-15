package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.TextAnalyseData

interface TextValidator {
    fun validate(analyseData: TextAnalyseData): List<PossibleChange>
}
