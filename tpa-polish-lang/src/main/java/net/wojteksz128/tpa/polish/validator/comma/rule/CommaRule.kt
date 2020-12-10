package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.PossibleChange

interface CommaRule {
    fun check(text: TextAnalyseResult): Iterable<PossibleChange>
}
