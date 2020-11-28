package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.LanguageAlphabetLoader
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.split.DefaultClassifier
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TextPunctuationAnalyzerTest {

    private val alphabet = LanguageAlphabetLoader.load(TextPunctuationAnalyzerTest::class.java.getResourceAsStream("/test_lang.json"))
    private val textDivider = DefaultTextDividerImpl(alphabet)
    private lateinit var textPunctuationAnalyzer: TextPunctuationAnalyzer

    @BeforeEach
    fun beforeAnyTest() {
        textPunctuationAnalyzer = TextPunctuationAnalyzer(textDivider, DefaultClassifier())
    }

    @Test
    fun `Analyze of empty string returns clear result`() {
        val text = ""
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(0, result.textParts.size)
        assertEquals(0, result.words.size)
        assertEquals(0, result.punctuationMarks.size)
        assertEquals(0, result.possibleChanges.size)
    }

    @Test
    fun `Analyze text with one word returns one word`() {
        val text = "Ala"
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(1, result.textParts.size)
        assertEquals(1, result.words.size)
        assertEquals(0, result.punctuationMarks.size)
    }

    @Test
    fun `Analyze text with no possible changes returns empty possible changes list`() {
        val text = "Idę."
        val validator = object : TextValidator {
            override fun validate(text: TextAnalyseResult): List<PossibleChange> = listOf()
        }
        textPunctuationAnalyzer.validators += validator
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(2, result.textParts.size)
        assertEquals(1, result.words.size)
        assertEquals(1, result.punctuationMarks.size)
        assertEquals(0, result.possibleChanges.size)
    }

    @Test
    fun `Analyze text with one possible change returns list of possible changes with one element`() {
        val text = "Idę"
        val possibleChange = PossibleChange(ChangeType.INSERT, 3, new = ".")
        val validator = object : TextValidator {
            override fun validate(text: TextAnalyseResult): List<PossibleChange> = listOf(possibleChange)
        }
        textPunctuationAnalyzer.validators += validator
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(1, result.textParts.size)
        assertEquals(1, result.words.size)
        assertEquals(0, result.punctuationMarks.size)
        assertEquals(1, result.possibleChanges.size)
        assertEquals(possibleChange, result.possibleChanges.first())
    }

}