package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.PunctuationMark
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

class DefaultTextDividerImpl(private val languageAlphabet: LanguageAlphabet)
    : TextDivider {

    override fun divide(text: String) = languageAlphabet.partsPattern.findAll(text.toUpperCase()).map { prepareTextPartObject(it, text) }.toList()

    private fun prepareTextPartObject(it: MatchResult, text: String): TextPart {
        return when {
            languageAlphabet.separatorPattern.matches(it.value) -> Separator(text, it.range.first, it.range.last)
            languageAlphabet.punctuationMarkPattern.matches(it.value) -> PunctuationMark(text, it.range.first, it.range.last)
            else -> Word(text, it.range.first, it.range.last)
        }
    }
}
