package net.wojteksz128.tpa.text

class TestText(private val parts: List<TestTextPart>) {

    fun getFullText() = parts.joinToString("") { it.getText() }
    fun getParts() = parts
    fun getPartsNo() = parts.size
    fun getWordsNo() = parts.filterIsInstance<TestWord>().size
    fun getPunctuationsNo() = parts.filterIsInstance<TestPunctuation>().size

    companion object {
        fun builder() = Builder()
    }

    class Builder internal constructor() {
        private val parts = mutableListOf<TestTextPart>()

        fun build() = TestText(parts.toList())
        fun word(word: String): Builder {
            parts.add(TestWord(word))
            return this
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
