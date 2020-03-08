package net.wojteksz128.tpa.language

class TestLanguageAlphabet : LanguageAlphabet {

    override fun getLetters(): CharArray = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ".toCharArray()
    override fun getSeparator() = " "
    override fun getPartsPattern() = "(([${getLetters().joinToString("")}]+)|[${getSeparator()}${getPunctuations().joinToString("")}])".toRegex()
    override fun getPunctuations() = listOf(".", ",", ";", "\\u2026", "\\u2010", "\\u002D", "\\u2212",
            "\\u2013", "\\u2014", "?", "!", ":", "(", ")", "\\[", "\\]", "{", "}", "<", ">", "\\u201E", "\\u201D", "\\u00BB",
            "\\u00AB", "\\u201A", "\\u2019", "\\u2018", "\\u201B", "\"", "\'")
}
