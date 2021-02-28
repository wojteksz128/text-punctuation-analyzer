package net.wojteksz128.tpa.text.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.part.TextPart

data class RuleBreak(
    val brokenRule: Rule,
    val textPart: TextPart,
    val analyseData: TextAnalyseData,
    val reason: String = ""
) {

    fun prepareSolution() = brokenRule.prepareSolution(this)
}