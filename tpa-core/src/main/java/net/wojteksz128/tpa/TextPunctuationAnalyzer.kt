package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.LanguageAlphabet

class TextPunctuationAnalyzer(private val languageAlphabet: LanguageAlphabet) {
    fun analyze(text: String): TextAnalyseResult {
        val result = TextAnalyseResult(text)
        result.textParts += recognize(text)
        result.words += result.textParts.filterIsInstance<TextAnalyseResult.Word>()
        return result
    }

    private fun recognize(text: String): List<TextPart> {
        val recognizedTextParts = mutableListOf<TextPart>()

        val wordsRegex = "[${ languageAlphabet.getLetters().joinToString("") }]+".toRegex()
        wordsRegex.findAll(text.toUpperCase()).forEach {
            recognizedTextParts += TextAnalyseResult.Word(text, it.range.first, it.range.last)
        }

        return recognizedTextParts.toList()
    }
}