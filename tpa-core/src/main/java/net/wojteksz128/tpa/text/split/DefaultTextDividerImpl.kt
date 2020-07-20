package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

class DefaultTextDividerImpl(private val languageAlphabet: LanguageAlphabet, private val classifier: Classifier) : TextDivider {

    override fun divide(text: String): List<TextPart> {
        val recognizedTextParts = mutableListOf<TextPart>()

        val wordsRegex = languageAlphabet.getPartsPattern()
        wordsRegex.findAll(text.toUpperCase()).forEach {
            val possibleCategories = classifier.classify(text.substring(it.range.first, it.range.last + 1))
            when {
                "[${languageAlphabet.getSeparator()}]".toRegex().matches(it.value) ->
                    recognizedTextParts += Separator(text, it.range.first, it.range.last, possibleCategories)
                "[${languageAlphabet.getPunctuations().joinToString("")}]".toRegex().matches(it.value) ->
                    recognizedTextParts += PunctuationMark(text, it.range.first, it.range.last, possibleCategories)
                else ->
                    recognizedTextParts += Word(text, it.range.first, it.range.last, possibleCategories)
            }
        }

        return recognizedTextParts.toList()
    }
}
