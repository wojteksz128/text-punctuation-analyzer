package net.wojteksz128.tpa

class TextAnalyseResult(val text: String) {

    val textParts = mutableListOf<TextPart>()
    val punctuationMarks = mutableListOf<PunctuationMark>()
    val words = mutableListOf<Word>()

    class PunctuationMark private constructor(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt) {
        override fun get() = text.substring(startAt, endAt)
    }

    class Word private constructor(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt) {
        override fun get() = text.substring(startAt, endAt)
    }
}

abstract class TextPart protected constructor(val text: String, val startAt: Int, val endAt: Int) {
    abstract fun get(): String
}
