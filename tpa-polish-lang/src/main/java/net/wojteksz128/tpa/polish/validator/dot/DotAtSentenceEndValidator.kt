package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.STATEMENT_GROUP
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.TextValidator

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSentenceWithoutDotAtEnd(text)
        possibleChanges += findDotInsideStatementGroup(text)
        possibleChanges += findIncorrectPlacedDot(text)

        return possibleChanges
    }

    private fun findSentenceWithoutDotAtEnd(text: TextAnalyseResult): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()
        val additionalParts = text.additionalParts[STATEMENT_GROUP.name] ?: listOf<Any>()

        additionalParts.map { it as StatementGroup }.forEach {
            if (!text.markAfter(".", it)) {
                possibleChanges += PossibleChange(ChangeType.INSERT, it.endAt + 1, new = ".")
            }
        }

        return possibleChanges
    }

    private fun findDotInsideStatementGroup(text: TextAnalyseResult): Iterable<PossibleChange> {
        val statementGroups = text.additionalParts[STATEMENT_GROUP.name] ?: listOf<Any>()

        return statementGroups.map { it as StatementGroup }
                .flatMap { findIncorrectEndedWords(it, text) }
                .map { PossibleChange(ChangeType.DELETE, it.endAt + 1, old = ".") }
    }

    private fun findIncorrectEndedWords(it: StatementGroup, text: TextAnalyseResult) =
            it.items.sortedBy { word -> word.startAt }.dropLast(1).filter { text.markAfter(".", it) }

    private fun findIncorrectPlacedDot(text: TextAnalyseResult): Iterable<PossibleChange> {
        val list = text.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()
        val statementGroups = text.additionalParts[STATEMENT_GROUP.name] ?: listOf<Any>()

        return list.map { it as List<TextPart> }
                .filter { sentenceParts ->
                    statementGroups.map { (it as StatementGroup).items }.none { sentenceParts.containsAll(it) }
                }
                .map { PossibleChange(ChangeType.DELETE, it.last().startAt, old = it.last().get()) }
    }
}
