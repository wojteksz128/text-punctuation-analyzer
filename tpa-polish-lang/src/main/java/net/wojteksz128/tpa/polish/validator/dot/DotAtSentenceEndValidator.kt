package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.STATEMENT_GROUP
import net.wojteksz128.tpa.text.*

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(analyseData: TextAnalyseData): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSentenceWithoutDotAtEnd(analyseData)
        possibleChanges += findDotInsideStatementGroup(analyseData)
        possibleChanges += findIncorrectPlacedDot(analyseData)

        return possibleChanges
    }

    private fun findSentenceWithoutDotAtEnd(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()
        val additionalParts = analyseData.additionalParts[STATEMENT_GROUP.name] ?: listOf<Any>()

        additionalParts.map { it as AwareOfSurroundings<*> }.forEach {
            if (!markAfter(".", it)) {
                possibleChanges += PossibleChange(ChangeType.INSERT, it.endAt + 1, new = ".")
            }
        }

        return possibleChanges
    }

    private fun findDotInsideStatementGroup(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val statementGroups = analyseData.additionalParts[STATEMENT_GROUP.name] ?: listOf<Any>()

        return statementGroups.map { it as AwareOfSurroundings<*> }
            .flatMap { findIncorrectEndedWords(it) }
            .map { PossibleChange(ChangeType.DELETE, it.endAt + 1, old = ".") }
    }

    private fun findIncorrectEndedWords(awareOfSurroundings: AwareOfSurroundings<*>) =
        (awareOfSurroundings.base as StatementGroup).items.sortedBy { it.startAt }.dropLast(1)
            .filter { markAfter(".", it) }

    private fun findIncorrectPlacedDot(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val list = analyseData.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()
        val statementGroups = analyseData.additionalParts[STATEMENT_GROUP.name] ?: listOf<Any>()

        return list.map { it as List<*> }
            .filter { sentenceParts ->
                statementGroups.map { ((it as AwareOfSurroundings<*>).base as StatementGroup).items }
                    .none { sentenceParts.containsAll(it) }
            }
            .map {
                val lastSentencePart = it.last() as TextPart
                PossibleChange(ChangeType.DELETE, lastSentencePart.startAt, old = lastSentencePart.get())
            }
    }
}
