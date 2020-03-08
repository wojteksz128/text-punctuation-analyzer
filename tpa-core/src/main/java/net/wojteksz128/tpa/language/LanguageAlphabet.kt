package net.wojteksz128.tpa.language

interface LanguageAlphabet {
    fun getLetters(): CharArray
    fun getSeparator(): String
    fun getPartsPattern(): Regex
}
