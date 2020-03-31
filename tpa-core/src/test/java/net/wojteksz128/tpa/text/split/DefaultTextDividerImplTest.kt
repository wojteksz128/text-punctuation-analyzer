package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.language.TestLanguageAlphabet
import net.wojteksz128.tpa.text.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DefaultTextDividerImplTest {
    private val languageAlphabet = TestLanguageAlphabet()
    private val textSplitter: TextDivider = DefaultTextDividerImpl(languageAlphabet)

    @Test
    fun `Analyze empty text returns empty analyse result`() {
        val text = TestText.Builder(languageAlphabet).build()

        val result = textSplitter.divide(text.getFullText())

        thenAnalyzerRecognized(result, text, HypotheticalResult(0, 0, 0))
    }

    @Test
    fun `Analyze text with one word returns result with recognized one word`() {
        val text = TestText.Builder(languageAlphabet).word("Test").build()

        val result = textSplitter.divide(text.getFullText())

        thenAnalyzerRecognized(result, text, HypotheticalResult(1, 1, 0))
    }

    @Test
    fun `Analyze text with only words returns result with recognized all words`() {
        val text = TestText.Builder(languageAlphabet).word("Ala").word("ma").word("kota").build()

        val result = textSplitter.divide(text.getFullText())

        thenAnalyzerRecognized(result, text, HypotheticalResult(5, 3, 0))
    }

    @Test
    fun `Analyze text with punctuator returns result with recognized punctuator`() {
        val text = TestText.Builder(languageAlphabet).word("Ala").word("ma").word("kota").dot().build()

        val result = textSplitter.divide(text.getFullText())

        thenAnalyzerRecognized(result, text, HypotheticalResult(6, 3, 1))
    }

    private fun thenAnalyzerRecognized(result: List<TextPart>, text: TestText, hypotheticalResult: HypotheticalResult) {
        var wordsNo = 0
        var punctuationMarksNo = 0

        result.zip(text.getParts()).forEach {
            when (it.second) {
                is TestWord -> {
                    thenPartIs<Word>(it.first, it.second)
                    ++wordsNo
                }
                is TestPunctuation -> {
                    thenPartIs<PunctuationMark>(it.first, it.second)
                    ++punctuationMarksNo
                }
                is TestSeparator -> thenPartIs<Separator>(it.first, it.second)
            }
        }

        Assertions.assertEquals(hypotheticalResult.partsNo, result.size)
        Assertions.assertEquals(hypotheticalResult.wordsNo, wordsNo)
        Assertions.assertEquals(hypotheticalResult.punctuationsNo, punctuationMarksNo)
    }

    private inline fun <reified T> thenPartIs(first: TextPart, second: TestTextPart) {
        Assertions.assertTrue { first is T }
        Assertions.assertEquals(first.get(), second.getText())
    }
}