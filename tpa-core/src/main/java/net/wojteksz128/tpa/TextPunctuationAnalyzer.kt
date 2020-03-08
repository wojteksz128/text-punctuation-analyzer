package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

class TextPunctuationAnalyzer(private val languageAlphabet: LanguageAlphabet) {
    fun analyze(text: String): TextAnalyseResult {
        val result = TextAnalyseResult(text)
        result.textParts += recognize(text)
        result.words += result.textParts.filterIsInstance<Word>()
        return result
    }

    private fun recognize(text: String): List<TextPart> {
        val recognizedTextParts = mutableListOf<TextPart>()

        val wordsRegex = languageAlphabet.getPartsPattern()
        wordsRegex.findAll(text.toUpperCase()).forEach {
            if ("[${languageAlphabet.getSeparator()}]".toRegex().matches(it.value))
                recognizedTextParts += Separator(text, it.range.first, it.range.last)
            else
                recognizedTextParts += Word(text, it.range.first, it.range.last)
        }

        return recognizedTextParts.toList()
    }
}