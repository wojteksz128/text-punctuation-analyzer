package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.language.LanguageAlphabet

class TestText private constructor(private val parts: List<TestTextPart>) {

    fun getFullText() = parts.joinToString("") { it.getText() }
    fun getParts() = parts
    fun getPartsNo() = parts.size
    fun getWordsNo() = parts.filterIsInstance<TestWord>().size
    fun getPunctuationsNo() = parts.filterIsInstance<TestPunctuation>().size

    data class Builder(private val languageAlphabet: LanguageAlphabet, private val parts: MutableList<TestTextPart> = mutableListOf()) {

        fun build() = TestText(parts.toList())
        fun word(word: String) = apply {
            if (parts.lastOrNull() is TestWord || parts.lastOrNull() is TestPunctuation)
                parts += TestSeparator(languageAlphabet.getSeparator())
            parts += TestWord(word)
        }
    }
}

interface TestTextPart {

    fun getText(): String

}
class TestWord(private val word: String) : TestTextPart {

    override fun getText() = word
}
class TestPunctuation(private val punctuation: String) : TestTextPart {

    override fun getText() = punctuation
}
class TestSeparator(private val separator: String) : TestTextPart {

    override fun getText() = separator
}
