package net.wojteksz128.tpa

class TextAnalyseResult(val text: String) {

    val textParts = mutableListOf<TextPart>()
    val punctuationMarks = mutableListOf<PunctuationMark>()
    val words = mutableListOf<Word>()

    class PunctuationMark(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt) {
        override fun get() = text.substring(startAt, endAt + 1)
    }

    class Word(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt) {
        override fun get() = text.substring(startAt, endAt + 1)
    }
}

abstract class TextPart(val text: String, val startAt: Int, val endAt: Int) {
    abstract fun get(): String
}
