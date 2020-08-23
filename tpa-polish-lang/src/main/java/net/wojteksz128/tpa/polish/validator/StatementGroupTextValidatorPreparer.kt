package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech

// TODO: 23.08.2020 Prepare some tests
object StatementGroupTextValidatorPreparer : TextValidatorPreparer {
    override fun prepare(result: TextAnalyseResult) {

        val verb = result.words.filter { it isTypeOf PartOfSpeech.VERB }
        val statementGroups = verb.map {
            result.prepareStatementGroup(it)
        }

        result.additionalParts["Grupa orzeczenia"] = statementGroups
    }
}