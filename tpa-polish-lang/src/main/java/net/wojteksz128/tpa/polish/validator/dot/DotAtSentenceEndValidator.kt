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

        possibleChanges += findSentenceWithoutDotAtEnd(text)
        possibleChanges += findDotInsideStatementGroup(text)

        return possibleChanges
    }

    private fun findSentenceWithoutDotAtEnd(text: TextAnalyseResult): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()
        val additionalParts = text.additionalParts["Grupa orzeczenia"] ?: listOf<Any>()

        additionalParts.map { it as StatementGroup }.forEach {
            if (!text.markAfter(".", it)) {
                possibleChanges += PossibleChange(ChangeType.INSERT, it.endAt + 1, new = ".")
            }
        }

        return possibleChanges
    }

    private fun findDotInsideStatementGroup(text: TextAnalyseResult): Iterable<PossibleChange> {
        val statementGroups = text.additionalParts["Grupa orzeczenia"] ?: listOf<Any>()

        return statementGroups.map { it as StatementGroup }
                .flatMap { findIncorrectEndedWords(it, text) }
                .map { PossibleChange(ChangeType.DELETE, it.endAt + 1, old = ".") }
    }

    private fun findIncorrectEndedWords(it: StatementGroup, text: TextAnalyseResult) =
            it.items.sortedBy { word -> word.startAt }.dropLast(1).filter { text.markAfter(".", it) }
}
