package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier
import kotlin.test.assertEquals


object TextValidationUtils {

    private val alphabet = TestLanguageAlphabet()
    private val classifier = MorfeuszClassifier
    private val textDivider = DefaultTextDividerImpl(alphabet, classifier)

    fun verifyTextPossibleChanges(text: String, expected: List<PossibleChange>, function: (TextAnalyseResult) -> List<PossibleChange>) {
        val example = prepareTextAnalyseResult(text)
        val possibleChanges = function(example)
        assertEquals(expected.size, possibleChanges.size)
        expected.zip(possibleChanges).forEach {
            assertEquals(it.first.position, it.second.position)
            assertEquals(it.first.suggestedSign, it.second.suggestedSign)
        }
    }

    private fun prepareTextAnalyseResult(text: String): TextAnalyseResult {
        val textAnalyseResult = TextAnalyseResult(text, textDivider.divide(text))

        StatementGroupTextValidatorPreparer.prepare(textAnalyseResult)

        return textAnalyseResult
    }

    fun convertToPossibleChanges(position: IntArray, sign: String): List<PossibleChange> {
        return position.map { PossibleChange(it, sign) }
    }
}
