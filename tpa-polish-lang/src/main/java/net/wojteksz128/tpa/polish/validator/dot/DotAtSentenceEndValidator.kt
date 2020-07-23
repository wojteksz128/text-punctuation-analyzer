package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.polish.validator.isTypeOf
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.polish.validator.prepareStatementGroup
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech.VERB

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += checkSentence(text)

        return possibleChanges
    }

    private fun checkSentence(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        val verb = text.words.filter { it isTypeOf VERB }
        verb.forEach {
            val statementGroup: StatementGroup = text.prepareStatementGroup(it)
            if (!text.markAfter(".", statementGroup)) {
                possibleChanges += PossibleChange(statementGroup.endAt + 1, ".")
            }
        }

        return possibleChanges
    }
}
