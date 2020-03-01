package net.wojteksz128.tpa

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TextPunctuationAnalyzerTest {
    private val analyzer = TextPunctuationAnalyzer()

    @Test
    fun `Analyze empty text returns empty analyse result`() {
        val result = analyzer.analyze("")
        assertEquals("", result.text)
        assertTrue { result.textParts.isEmpty() }
        assertTrue { result.words.isEmpty() }
        assertTrue { result.punctuationMarks.isEmpty() }
    }
}