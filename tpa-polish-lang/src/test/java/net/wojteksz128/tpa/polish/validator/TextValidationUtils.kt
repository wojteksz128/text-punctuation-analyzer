package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.polish.validator.prepare.SentenceGroupValidatorPreparer
import net.wojteksz128.tpa.polish.validator.prepare.StatementGroupTextValidatorPreparer
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier
import kotlin.test.assertTrue


object TextValidationUtils {

    private val alphabet = TestLanguageAlphabet()
    private val classifier = MorfeuszClassifier
    private val textDivider = DefaultTextDividerImpl(alphabet)

    fun verifyTextPossibleChanges(text: String, expected: List<PossibleChange>, function: (TextAnalyseResult) -> List<PossibleChange>) {
        val example = prepareTextAnalyseResult(text, listOf(StatementGroupTextValidatorPreparer, SentenceGroupValidatorPreparer))
        val possibleChanges = function(example)
        val missing = expected.toMutableList()
        missing.removeIf { possibleChanges.contains(it) }
        assertTrue("Missed some expected possible changes: \n\t$missing") { missing.isEmpty() }
    }

    fun prepareTextAnalyseResult(text: String, preparers: Iterable<TextValidatorPreparer> = listOf()): TextAnalyseResult {
        val textAnalyseResult = TextAnalyseResult(text, textDivider.divide(text))

        classifier.classify(textAnalyseResult)

        preparers.forEach { it.prepare(textAnalyseResult) }

        return textAnalyseResult
    }

    fun convertToInsertPossibleChanges(position: IntArray, sign: String): List<PossibleChange> {
        return position.map { PossibleChange(ChangeType.INSERT, it, new = sign) }
    }

    @Suppress("unused")
    fun convertToReplacePossibleChanges(position: IntArray, sign: String): List<PossibleChange> {
        return position.map { PossibleChange(ChangeType.REPLACE, it, new = sign) }
    }

    fun convertToDeletePossibleChanges(position: IntArray, sign: String): List<PossibleChange> {
        return position.map { PossibleChange(ChangeType.DELETE, it, old = sign) }
    }
}
