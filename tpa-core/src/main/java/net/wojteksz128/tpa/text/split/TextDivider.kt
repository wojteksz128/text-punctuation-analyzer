package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.part.TextPart

interface TextDivider {
    val languageAlphabet: LanguageAlphabet

    fun divide(text: String): List<TextPart>
}
