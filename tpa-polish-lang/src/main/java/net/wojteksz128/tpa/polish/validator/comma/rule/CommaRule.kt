package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.PossibleChange

interface CommaRule {
    fun check(analyseData: TextAnalyseData): Iterable<PossibleChange>
}
