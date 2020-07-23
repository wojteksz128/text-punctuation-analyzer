package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.text.*
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszDecoded
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech.VERB

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += checkOneWordSentence(text)
        possibleChanges += checkMultipleWordSentence(text)

        return possibleChanges.toList()
    }

    private fun checkOneWordSentence(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        if (haveOneWord(text)) {
            val word = text.words.first() // or last() - list has single result
            if (!text.markAfter(".", word)) {
                possibleChanges += PossibleChange(word.endAt + 1, ".")
            }
        }

        return possibleChanges
    }

    private fun haveOneWord(text: TextAnalyseResult) = text.words.size == 1

    private fun checkMultipleWordSentence(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        if (!haveOneWord(text)) {
            val verb = text.words.filter { it isTypeOf VERB }
            verb.forEach {
                val statementGroup: StatementGroup = text.prepareStatementGroup(it)
                if (!text.markAfter(".", statementGroup)) {
                    possibleChanges += PossibleChange(statementGroup.endAt + 1, ".")
                }
            }
        }

        return possibleChanges
    }
}

private fun TextAnalyseResult.prepareStatementGroup(word: Word): StatementGroup {
    val statementGroupWords = mutableListOf(word)
    statementGroupWords += textParts.filter { it.startAt > word.endAt && it !is Separator }.sortedBy { it.startAt }
            .takeWhile { it is Word && !(it isTypeOf VERB) }.map { it as Word }

    return StatementGroup(this.text, statementGroupWords.first().startAt, statementGroupWords.last().endAt, statementGroupWords)
}

private fun TextAnalyseResult.markAfter(mark: String, part: TextPart) = punctuationMarks.filter { it.get() == mark && it.startAt == part.endAt + 1 }.size == 1

private infix fun Word.isTypeOf(partOfSpeech: PartOfSpeech) = this.possibleCategories.map { it as MorfeuszDecoded }.any { it.grammarClass?.partOfSpeech == partOfSpeech }
