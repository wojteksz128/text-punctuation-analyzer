package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

class DefaultTextDividerImpl(languageAlphabet: LanguageAlphabet)
    : TextDivider {
    private val partsPattern = languageAlphabet.getPartsPattern()
    private val separatorPattern = "[${languageAlphabet.getSeparator()}]".toRegex()
    private val punctuationMarkPattern = "[${languageAlphabet.getPunctuations().joinToString("")}]".toRegex()

    override fun divide(text: String) = partsPattern.findAll(text.toUpperCase()).map { prepareTextPartObject(it, text) }.toList()

    private fun prepareTextPartObject(it: MatchResult, text: String): TextPart {
        return when {
            separatorPattern.matches(it.value) -> Separator(text, it.range.first, it.range.last)
            punctuationMarkPattern.matches(it.value) -> PunctuationMark(text, it.range.first, it.range.last)
            else -> Word(text, it.range.first, it.range.last)
        }
    }
}
