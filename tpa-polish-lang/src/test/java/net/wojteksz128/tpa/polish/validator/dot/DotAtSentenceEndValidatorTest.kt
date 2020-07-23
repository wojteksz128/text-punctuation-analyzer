package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class DotAtSentenceEndValidatorTest {

    private val alphabet = TestLanguageAlphabet()
    private val classifier = MorfeuszClassifier
    private val textDivider = DefaultTextDividerImpl(alphabet, classifier)

    @Test
    fun `Verification of empty string returns empty list of possible changes`() {
        val example = prepareTextAnalyseResult("")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertTrue { possibleChanges.isEmpty() }
    }

    @Test
    fun `Verification of text with only one_word sentence returns possible dot at the end of sentence`() {
        val example = prepareTextAnalyseResult("Idę")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(1, possibleChanges.size)
        assertEquals(example.text.length, possibleChanges.first().position)
        assertEquals(".", possibleChanges.first().suggestedSign)
    }

    @Test
    fun `Verification of text with only one_word sentence ended by dot returns empty list of possible changes`() {
        val example = prepareTextAnalyseResult("Idę.")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(0, possibleChanges.size)
    }

    @Test
    fun `Verification of text with only two_word sentence begins with a noun returns possible dot at the end of sentence`() {
        val example = prepareTextAnalyseResult("Ala idzie")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(1, possibleChanges.size)
        assertEquals(example.text.length, possibleChanges.first().position)
        assertEquals(".", possibleChanges.first().suggestedSign)
    }

    @Test
    fun `Verification of text with two_word sentence begins with a noun ended by dot returns empty list of possible changes`() {
        val example = prepareTextAnalyseResult("Ala idzie.")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(0, possibleChanges.size)
    }

    @Test
    fun `Verification of text with only two_word sentence begins with a verb returns possible dot at the end of sentence`() {
        val example = prepareTextAnalyseResult("Idzie Ala")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(1, possibleChanges.size)
        assertEquals(example.text.length, possibleChanges.first().position)
        assertEquals(".", possibleChanges.first().suggestedSign)
    }

    @Test
    fun `Verification of text with two_word sentence begins with a verb ended by dot returns empty list of possible changes`() {
        val example = prepareTextAnalyseResult("Idzie Ala.")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(0, possibleChanges.size)
    }

    @Test
    fun `Verification of 'Ala ma kota' returns possible dot at the end of sentence`() {
        val example = prepareTextAnalyseResult("Ala ma kota")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(1, possibleChanges.size)
        assertEquals(example.text.length, possibleChanges.first().position)
        assertEquals(".", possibleChanges.first().suggestedSign)
    }

    @Test
    fun `Verification of 'Ala ma kota' with dot at the end returns empty list of possible changes`() {
        val example = prepareTextAnalyseResult("Ala ma kota.")
        val possibleChanges = DotAtSentenceEndValidator.validate(example)
        assertEquals(0, possibleChanges.size)
    }

    private fun prepareTextAnalyseResult(text: String): TextAnalyseResult {
        val textAnalyseResult = TextAnalyseResult(text)
        textAnalyseResult.textParts += textDivider.divide(textAnalyseResult.text)
        textAnalyseResult.words += textAnalyseResult.textParts.filterIsInstance<Word>()
        textAnalyseResult.punctuationMarks += textAnalyseResult.textParts.filterIsInstance<PunctuationMark>()
        return textAnalyseResult
    }
}