package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.Sentence
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator

// TODO: 03.01.2021 Sprawdzaj wielkość liter
object DotAtSentenceEndValidator : TextValidator {

    override fun validate(analyseData: TextAnalyseData): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSentenceWithoutDotAtEnd(analyseData)
        possibleChanges += findIncorrectPlacedDot(analyseData)
// TODO: 03.01.2021 Sprawdzaj, czy jest ciąg ". ", czy nie " ."
//        possibleChanges += findDotAndSeparatorInWrongOrder(analyseData)

        return possibleChanges
    }

    private fun findSentenceWithoutDotAtEnd(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()
        val additionalParts = analyseData.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()

        additionalParts.map { it as Sentence }.forEach { sentence ->
            val lastWord = sentence.lastWord
            if (!markAfter(".", lastWord)) {
                possibleChanges += PossibleChange(ChangeType.INSERT, lastWord.endAt + 1, new = ".")
            }
        }

        return possibleChanges
    }

    private fun findIncorrectPlacedDot(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val sentencesObjects = analyseData.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()

        return sentencesObjects.map { it as Sentence }
            .flatMap { it.subjectWords + it.statementWord + it.complementWords }
            .dropLast(1)
            .flatMap { it.partsBetweenLaterWord }
            .filter { it.text == "." }
            .map { PossibleChange(ChangeType.DELETE, it.startAt, old = it.text) }
    }

    /*private fun findDotAndSeparatorInWrongOrder(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val statementGroups = analyseData.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()

        return statementGroups.map { it as Sentence }
            .flatMap { findIncorrectEndedWords(it) }
            .map { PossibleChange(ChangeType.DELETE, it.endAt + 1, old = ".") }
    }

    private fun findIncorrectEndedWords(awareOfSurroundings: AwareOfSurroundings<*>) =
        (awareOfSurroundings.base as StatementGroup).items.sortedBy { it.startAt }.dropLast(1)
            .filter { markAfter(".", it) }*/
}
