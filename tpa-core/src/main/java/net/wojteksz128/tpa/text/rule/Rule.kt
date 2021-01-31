package net.wojteksz128.tpa.text.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.PossibleChange

interface Rule {

    fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak>
    fun prepareSolution(ruleBreak: RuleBreak): PossibleChange
}
