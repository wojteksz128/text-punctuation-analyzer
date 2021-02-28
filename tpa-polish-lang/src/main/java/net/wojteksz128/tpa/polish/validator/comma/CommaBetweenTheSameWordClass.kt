package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.rule.Rule
import net.wojteksz128.tpa.text.rule.RuleBreak

object CommaBetweenTheSameWordClass : TextValidator(listOf(CommaSeparatesWordTheSameClassRule)) {

    object CommaSeparatesWordTheSameClassRule : Rule {
        override fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak> {
            return analyseData.words.zipWithNext()
                .filter { (first, second) -> first.possibleCategories.firstOrNull()?.textPartSpecification?.grammarClass == second.possibleCategories.firstOrNull()?.textPartSpecification?.grammarClass && first.partsBetweenLaterWord.none { it.text == "," } }
                .map { RuleBreak(this, it.first, analyseData) }
        }

        override fun prepareSolution(ruleBreak: RuleBreak): PossibleChange {
            return PossibleChange(ChangeType.INSERT, ruleBreak.textPart.endAt.inc(), new = ",")
        }

    }
}