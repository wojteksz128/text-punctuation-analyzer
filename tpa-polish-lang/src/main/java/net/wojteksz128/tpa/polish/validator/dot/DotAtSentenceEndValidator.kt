package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += checkSentence(text)

        return possibleChanges
    }

    private fun checkSentence(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()
        val additionalParts = text.additionalParts["Grupa orzeczenia"] ?: listOf<Any>()

        additionalParts.map { it as StatementGroup }.forEach {
            if (!text.markAfter(".", it)) {
                possibleChanges += PossibleChange(ChangeType.INSERT, it.endAt + 1, new = ".")
            }
        }

        return possibleChanges
    }
}
