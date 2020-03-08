package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.TestText
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TextPunctuationAnalyzerTest {
    private val analyzer = TextPunctuationAnalyzer(TestLanguageAlphabet())

    @Test
    fun `Analyze empty text returns empty analyse result`() {
        val text = TestText.builder().build()

        val result = analyzer.analyze(text.getFullText())
        assertEquals(text.getFullText(), result.text)
        assertTrue { result.textParts.size == text.getPartsNo() }
        assertTrue { result.words.size == text.getWordsNo() }
        assertTrue { result.punctuationMarks.size == text.getPunctuationsNo() }
    }

    @Test
    fun `Analyze text with one word returns result with recognized one word`() {
        val text = TestText.builder().word("Test").build()

        val result = analyzer.analyze(text.getFullText())

        assertEquals(text.getFullText(), result.text)

        assertTrue { result.textParts.size == text.getPartsNo() }
        assertTrue { result.textParts.first() is TextAnalyseResult.Word }
        assertTrue { result.textParts.first().get() == text.getParts().first().getText() }

        assertTrue { result.words.size == text.getWordsNo() }
        assertTrue { result.words.first() == result.textParts.first() }

        assertTrue { result.punctuationMarks.size == text.getPunctuationsNo() }
    }
}