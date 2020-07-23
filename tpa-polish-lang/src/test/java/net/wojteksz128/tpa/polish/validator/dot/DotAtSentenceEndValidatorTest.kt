package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.test.assertEquals

internal class DotAtSentenceEndValidatorTest {

    private val alphabet = TestLanguageAlphabet()
    private val classifier = MorfeuszClassifier
    private val textDivider = DefaultTextDividerImpl(alphabet, classifier)

    @ParameterizedTest
    @CsvFileSource(resources = ["/DASEV_correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        val example = prepareTextAnalyseResult(text)
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(0, possibleChanges.size)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/DASEV_one_dot.csv"], numLinesToSkip = 1)
    fun `Verification returns possible dot in list of possible changes`(text: String, position: Int) {
        val example = prepareTextAnalyseResult(text)
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(1, possibleChanges.size)
        assertEquals(position, possibleChanges.first().position)
        assertEquals(".", possibleChanges.first().suggestedSign)
    }

    private fun prepareTextAnalyseResult(text: String): TextAnalyseResult {
        val textAnalyseResult = TextAnalyseResult(text)
        textAnalyseResult.textParts += textDivider.divide(textAnalyseResult.text)
        textAnalyseResult.words += textAnalyseResult.textParts.filterIsInstance<Word>()
        textAnalyseResult.punctuationMarks += textAnalyseResult.textParts.filterIsInstance<PunctuationMark>()
        return textAnalyseResult
    }
}