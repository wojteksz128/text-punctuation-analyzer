package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.LanguageAlphabetLoader
import net.wojteksz128.tpa.text.*
import net.wojteksz128.tpa.text.split.DefaultClassifier
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TextPunctuationAnalyzerTest {

    private val alphabet = LanguageAlphabetLoader.load(TextPunctuationAnalyzerTest::class.java.getResourceAsStream("/test_lang.json"))
    private val textDivider = DefaultTextDividerImpl(alphabet)
    private lateinit var textPunctuationAnalyzer: TextPunctuationAnalyzer
    private lateinit var validators: MutableList<TextValidator>

    @BeforeEach
    fun beforeAnyTest() {
        validators = mutableListOf()
        textPunctuationAnalyzer = TextPunctuationAnalyzer(textDivider, DefaultClassifier(), listOf(), validators)
    }

    @Test
    fun `Analyze of empty string returns clear result`() {
        val text = ""
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(0, result.textParts.size)
        assertEquals(0, result.textParts.filterIsInstance<Word>().size)
        assertEquals(0, result.textParts.filterIsInstance<PunctuationMark>().size)
        assertEquals(0, result.possibleChanges.size)
    }

    @Test
    fun `Analyze text with one word returns one word`() {
        val text = "Ala"
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(1, result.textParts.size)
        assertEquals(1, result.textParts.filterIsInstance<Word>().size)
        assertEquals(0, result.textParts.filterIsInstance<PunctuationMark>().size)
    }

    @Test
    fun `Analyze text with no possible changes returns empty possible changes list`() {
        val text = "Idę."
        val validator = object : TextValidator {
            override fun validate(analyseData: TextAnalyseData): List<PossibleChange> = listOf()
        }
        validators.add(validator)
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(2, result.textParts.size)
        assertEquals(1, result.textParts.filterIsInstance<Word>().size)
        assertEquals(1, result.textParts.filterIsInstance<PunctuationMark>().size)
        assertEquals(0, result.possibleChanges.size)
    }

    @Test
    fun `Analyze text with one possible change returns list of possible changes with one element`() {
        val text = "Idę"
        val possibleChange = PossibleChange(ChangeType.INSERT, 3, new = ".")
        val validator = object : TextValidator {
            override fun validate(analyseData: TextAnalyseData): List<PossibleChange> = listOf(possibleChange)
        }
        validators.add(validator)
        val result = textPunctuationAnalyzer.analyze(text)
        assertEquals(text, result.text)
        assertEquals(1, result.textParts.size)
        assertEquals(1, result.textParts.filterIsInstance<Word>().size)
        assertEquals(0, result.textParts.filterIsInstance<PunctuationMark>().size)
        assertEquals(1, result.possibleChanges.size)
        assertEquals(possibleChange, result.possibleChanges.first())
    }

}