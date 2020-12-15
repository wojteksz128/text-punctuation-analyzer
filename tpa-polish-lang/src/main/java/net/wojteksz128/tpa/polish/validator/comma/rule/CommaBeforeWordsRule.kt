package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange

class CommaBeforeWordsRule(ruleExpectedText: String) : CommaRule {
    // TODO: 10.12.2020 Czy na pewno ".* "?
    private val pattern: Regex = Regex(".* ($ruleExpectedText) .*")

    override fun check(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        // TODO: 10.12.2020 To nie powinien być "text.text", tylko twór wyrażenia bez znaków specjalnych
        // TODO: 10.12.2020 Sprawdzanie, czy po przecinku jest spacja
        return pattern.findAll(analyseData.text)
            .filter { match -> analyseData.punctuationMarks.find { it.startAt == match.groups[1]!!.range.first - 2 } == null }/* spacja poprzedzająca przecinek */
            .map { PossibleChange(ChangeType.INSERT, it.groups[1]!!.range.first - 2, new = ",") }.asIterable()
    }
}