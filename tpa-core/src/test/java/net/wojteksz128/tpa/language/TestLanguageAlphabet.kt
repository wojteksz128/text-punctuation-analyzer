package net.wojteksz128.tpa.language

class TestLanguageAlphabet : LanguageAlphabet {

    override fun getLetters(): CharArray = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ".toCharArray()
    override fun getSeparator() = " "
    override fun getPartsPattern() = "(([${getLetters().joinToString("")}]+)|([${getSeparator()}]))".toRegex()
}
