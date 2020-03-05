package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.TestLanguageAlphabet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TextPunctuationAnalyzerTest {
    private val analyzer = TextPunctuationAnalyzer(TestLanguageAlphabet())

    @Test
    fun `Analyze empty text returns empty analyse result`() {
        val result = analyzer.analyze("")
        assertEquals("", result.text)
        assertTrue { result.textParts.isEmpty() }
        assertTrue { result.words.isEmpty() }
        assertTrue { result.punctuationMarks.isEmpty() }
    }

    @Test
    fun `Analyze text with one word returns result with recognized one word`() {
        val text = "Test"

        val result = analyzer.analyze(text)

        assertEquals(text, result.text)

        assertTrue { result.textParts.size == 1 }
        assertTrue { result.textParts.first() is TextAnalyseResult.Word }
        assertTrue { result.textParts.first().get() == text }

        assertTrue { result.words.size == 1 }
        assertTrue { result.words.first() == result.textParts.first() }
    }
}