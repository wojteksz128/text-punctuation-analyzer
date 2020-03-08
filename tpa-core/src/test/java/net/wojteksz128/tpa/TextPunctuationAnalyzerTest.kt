package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TextPunctuationAnalyzerTest {
    private val languageAlphabet = TestLanguageAlphabet()
    private val analyzer = TextPunctuationAnalyzer(languageAlphabet)

    @Test
    fun `Analyze empty text returns empty analyse result`() {
        val text = TestText.Builder(languageAlphabet).build()

        val result = analyzer.analyze(text.getFullText())

        thenResultHasFilledInputText(text, result)
        thenAnalyzerRecognized(result, HypotheticalResult(0, 0, 0))
    }

    @Test
    fun `Analyze text with one word returns result with recognized one word`() {
        val text = TestText.Builder(languageAlphabet).word("Test").build()

        val result = analyzer.analyze(text.getFullText())

        thenResultHasFilledInputText(text, result)
        thenAnalyzerRecognized(result, HypotheticalResult(1, 1, 0))
        thenPartAtIndexIs<Word>(result, text, 0)
    }

    @Test
    fun `Analyze text with only words returns result with recognized all words`() {
        val text = TestText.Builder(languageAlphabet).word("Ala").word("ma").word("kota").build()

        val result = analyzer.analyze(text.getFullText())

        thenResultHasFilledInputText(text, result)
        thenAnalyzerRecognized(result, HypotheticalResult(5, 3, 0))
        thenPartAtIndexIs<Word>(result, text, 0)
        thenPartAtIndexIs<Separator>(result, text, 1)
        thenPartAtIndexIs<Word>(result, text, 2)
        thenPartAtIndexIs<Separator>(result, text, 3)
        thenPartAtIndexIs<Word>(result, text, 4)
    }

    @Test
    fun `Analyze text with punctuator returns result with recognized punctuator`() {
        val text = TestText.Builder(languageAlphabet).word("Ala").word("ma").word("kota").dot().build()

        val result = analyzer.analyze(text.getFullText())

        thenResultHasFilledInputText(text, result)
        thenAnalyzerRecognized(result, HypotheticalResult(6, 3, 1))
        thenPartAtIndexIs<Word>(result, text, 0)
        thenPartAtIndexIs<Separator>(result, text, 1)
        thenPartAtIndexIs<Word>(result, text, 2)
        thenPartAtIndexIs<Separator>(result, text, 3)
        thenPartAtIndexIs<Word>(result, text, 4)
        thenPartAtIndexIs<PunctuationMark>(result, text, 5)
    }

    private fun thenResultHasFilledInputText(text: TestText, result: TextAnalyseResult) {
        assertEquals(text.getFullText(), result.text)
    }

    private fun thenAnalyzerRecognized(result: TextAnalyseResult, hypotheticalResult: HypotheticalResult) {
        assertEquals(hypotheticalResult.partsNo, result.textParts.size)
        assertEquals(hypotheticalResult.wordsNo, result.words.size)
        assertEquals(hypotheticalResult.punctuationsNo, result.punctuationMarks.size)
    }

    private inline fun <reified T> thenPartAtIndexIs(result: TextAnalyseResult, text: TestText, index: Int) {
        assertTrue { result.textParts[index] is T }
        assertEquals(result.textParts[index].get(), text.getParts()[index].getText())
    }
}