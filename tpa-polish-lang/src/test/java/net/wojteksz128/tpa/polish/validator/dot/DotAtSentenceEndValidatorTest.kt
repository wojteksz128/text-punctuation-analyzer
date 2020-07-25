package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.test.assertEquals

internal class DotAtSentenceEndValidatorTest {

    private val alphabet = TestLanguageAlphabet()
    private val classifier = MorfeuszClassifier
    private val textDivider = DefaultTextDividerImpl(alphabet, classifier)

    @ParameterizedTest(name = "{index}. text=\"{0}\"")
    @CsvFileSource(resources = ["/DASEV_correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        val example = prepareTextAnalyseResult(text)
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(0, possibleChanges.size)
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/DASEV_one_dot.csv"], numLinesToSkip = 1)
    fun `Verification returns possible dot in list of possible changes`(text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray) {
        val example = prepareTextAnalyseResult(text)
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(position.size, possibleChanges.size)
        position.zip(possibleChanges).forEach {
            assertEquals(it.first, it.second.position)
            assertEquals(".", it.second.suggestedSign)
        }
    }

    private fun prepareTextAnalyseResult(text: String): TextAnalyseResult {
        val textAnalyseResult = TextAnalyseResult(text)
        textAnalyseResult.textParts += textDivider.divide(textAnalyseResult.text)
        textAnalyseResult.words += textAnalyseResult.textParts.filterIsInstance<Word>()
        textAnalyseResult.punctuationMarks += textAnalyseResult.textParts.filterIsInstance<PunctuationMark>()
        return textAnalyseResult
    }
}