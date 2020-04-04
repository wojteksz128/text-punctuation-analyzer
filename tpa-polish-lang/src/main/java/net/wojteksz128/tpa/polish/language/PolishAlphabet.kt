package net.wojteksz128.tpa.polish.language

import net.wojteksz128.tpa.language.LanguageAlphabet

object PolishAlphabet : LanguageAlphabet {

    override fun getLetters() = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ".toCharArray()

    override fun getSeparator() = " "

    override fun getPartsPattern() = ("(([${getLetters().joinToString("")}]+)|[${getSeparator()}" +
            "${getPunctuations().joinToString("")}])").toRegex()

    override fun getPunctuations() = listOf(".", ";", ",", "\\u2026", "\\u2010", "\\u002D", "\\u2212",
            "\\u2013", "\\u2014", "?", "!", ":", "", "(", ")", "\\[", "\\]", "{", "}", "<", ">", "\\u201E", "\\u201D",
            "\"", "\'")
}
