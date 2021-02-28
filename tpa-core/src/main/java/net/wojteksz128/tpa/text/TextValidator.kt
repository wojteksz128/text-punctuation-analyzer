package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.rule.Rule

abstract class TextValidator(private val rules: Iterable<Rule> = listOf()) {

    open fun validate(analyseData: TextAnalyseData): List<PossibleChange> {
        return rules.flatMap { rule -> rule.findBreaks(analyseData) }
            .map { it.prepareSolution() }
    }
}
