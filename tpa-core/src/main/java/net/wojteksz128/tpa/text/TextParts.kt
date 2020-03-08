package net.wojteksz128.tpa.text

abstract class TextPart(val text: String, val startAt: Int, val endAt: Int) {
    open fun get() = text.substring(startAt, endAt + 1)
}

class PunctuationMark(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt)

class Word(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt)

class Separator(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt)