package net.wojteksz128.tpa

class TextAnalyseResult(val text: String) {

    val punctuationMarks = mutableListOf<PunctuationMark>()

    val words = mutableListOf<Word>()

    class PunctuationMark private constructor(val text: String, val startAt: Int, val endAt: Int) {
        fun getMark() = text.substring(startAt, endAt)
    }

    class Word private constructor(val text: String, val startAt: Int, val endAt: Int) {
        fun getWord() = text.substring(startAt, endAt)
    }
}
