package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.language.LanguageAlphabetLoader
import net.wojteksz128.tpa.polish.split.PolishWordsClassifier
import net.wojteksz128.tpa.polish.validator.prepare.SentenceGroupValidatorPreparer
import net.wojteksz128.tpa.polish.validator.prepare.StatementGroupTextValidatorPreparer
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import kotlin.test.assertTrue


object TextValidationUtils {

    private val alphabet =
        LanguageAlphabetLoader.load(TextValidationUtils::class.java.getResourceAsStream("/test_lang.json"))
    private val classifier = PolishWordsClassifier.instance
    private val textDivider = DefaultTextDividerImpl(alphabet)

    fun verifyTextPossibleChanges(
        text: String,
        expected: List<PossibleChange>,
        function: (TextAnalyseData) -> List<PossibleChange>
    ) {
        val example =
            prepareTextAnalyseResult(text, listOf(StatementGroupTextValidatorPreparer, SentenceGroupValidatorPreparer))
        val possibleChanges = function(example)
        val missing = expected.toMutableList()
        missing.removeIf { possibleChanges.contains(it) }
        assertTrue("Missed some expected possible changes: \n\t$missing") { missing.isEmpty() }
    }

    fun prepareTextAnalyseResult(text: String, preparers: Iterable<TextValidatorPreparer> = listOf()): TextAnalyseData {
        val analyseData = TextAnalyseData(text, textDivider.divide(text))

        classifier.classify(analyseData)

        preparers.forEach { it.prepare(analyseData) }

        return analyseData
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
