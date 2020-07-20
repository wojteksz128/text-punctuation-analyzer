package net.wojteksz128.tpa.text

abstract class TextPart(val text: String, val startAt: Int, val endAt: Int, val possibleCategories: List<TextPartCategory>) {
    open fun get() = text.substring(startAt, endAt + 1)
}

class PunctuationMark(text: String, startAt: Int, endAt: Int, possibleCategories: List<TextPartCategory>) : TextPart(text, startAt, endAt, possibleCategories)

class Word(text: String, startAt: Int, endAt: Int, possibleCategories: List<TextPartCategory>) : TextPart(text, startAt, endAt, possibleCategories)

class Separator(text: String, startAt: Int, endAt: Int, possibleCategories: List<TextPartCategory>) : TextPart(text, startAt, endAt, possibleCategories)

interface TextPartCategory
