package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange

class CommaBeforeWordsRule(val text: String) : CommaRule {
    // TODO: 10.12.2020 Czy na pewno ".* "?
    private val pattern: Regex = Regex(".* ($text) .*")

    override fun check(text: TextAnalyseResult): Iterable<PossibleChange> {
        // TODO: 10.12.2020 To nie powinien być "text.text", tylko twór wyrażenia bez znaków specjalnych
        // TODO: 10.12.2020 Sprawdzanie, czy po przecinku jest spacja
        return pattern.findAll(text.text)
            .filter { match -> text.punctuationMarks.find { it.startAt == match.groups[1]!!.range.first - 2 } == null }/* spacja poprzedzająca przecinek */
            .map { PossibleChange(ChangeType.INSERT, it.groups[1]!!.range.first - 2, new = ",") }.asIterable()
    }


}