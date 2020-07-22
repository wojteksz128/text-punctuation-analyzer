package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.Word

/*import net.wojteksz128.tpa.utils.morfeusz.MorfeuszDecoded
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech.VERB*/

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += checkOneWordSentence(text)
//        possibleChanges += checkMultipleWordSentence(text)

        return possibleChanges.toList()
    }

    private fun checkOneWordSentence(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        if (haveOneWord(text)) {
            val word = text.words.first() // or last() - list has single result
            if (!haveDotSignAfter(text, word)) {
                possibleChanges += PossibleChange(word.endAt + 1, ".")
            }
        }

        return possibleChanges
    }

    private fun haveOneWord(text: TextAnalyseResult) = text.words.size == 1

    private fun haveDotSignAfter(text: TextAnalyseResult, word: Word) =
            text.punctuationMarks.filter { it.startAt > word.endAt }.minBy { it.startAt - word.endAt } != null

    /*private fun checkMultipleWordSentence(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        if (!haveOneWord(text)) {
            val verb = text.words.filter { it isTypeOf VERB }

        }

        return possibleChanges
    }*/
}

/*private infix fun Word.isTypeOf(partOfSpeech: PartOfSpeech)
        = this.possibleCategories.map { it as MorfeuszDecoded }.any { it.grammarClass?.partOfSpeech == partOfSpeech }*/
