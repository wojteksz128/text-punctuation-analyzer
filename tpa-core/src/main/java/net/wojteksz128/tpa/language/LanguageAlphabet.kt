package net.wojteksz128.tpa.language

data class LanguageAlphabet(
        val letters: List<String>,
        val separators: List<String>,
        val punctuationMarks: List<String>) {

    @Suppress("MemberVisibilityCanBePrivate")
    val lettersPattern: Regex
        get() = letters.joinToString("|", "(", ")").toRegex()

    val separatorPattern: Regex
        get() = separators.joinToString("|", "(", ")").toRegex()

    val punctuationMarkPattern: Regex
        get() = punctuationMarks.joinToString("|", "(", ")").toRegex()

    val partsPattern: Regex
        get() = "($lettersPattern+|$separatorPattern|$punctuationMarkPattern)".toRegex()
}
