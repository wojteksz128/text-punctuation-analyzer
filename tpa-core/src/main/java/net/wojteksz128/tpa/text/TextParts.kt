package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.utils.dag.TextPartInterpretation

// TODO: 15.12.2020 Split to separate classes
abstract class TextPart(
    val text: String, val startAt: Int, val endAt: Int,
    var possibleCategories: MutableList<TextPartInterpretation> = mutableListOf()
) {
    open fun get() = text.substring(startAt, endAt + 1)
}

class AwareOfSurroundings<T : TextPart>(val base: T) :
    TextPart(base.text, base.startAt, base.endAt, base.possibleCategories) {

    var wordBefore: AwareOfSurroundings<Word>? = null
        private set
    var wordAfter: AwareOfSurroundings<Word>? = null
        private set
    var partsBetweenEarlierWord: List<TextPart> = listOf()
        private set
    var partsBetweenLaterWord: List<TextPart> = listOf()
        private set

    fun withWordBefore(previous: AwareOfSurroundings<Word>?): AwareOfSurroundings<T> {
        wordBefore = previous
        return this
    }

    fun withWordAfter(next: AwareOfSurroundings<Word>?): AwareOfSurroundings<T> {
        wordAfter = next
        return this
    }

    fun withPartsBetweenEarlierWord(earlierParts: List<TextPart>): AwareOfSurroundings<T> {
        partsBetweenEarlierWord = earlierParts
        return this
    }

    fun withPartsBetweenLaterWord(laterParts: List<TextPart>): AwareOfSurroundings<T> {
        partsBetweenLaterWord = laterParts
        return this
    }
}

class PunctuationMark(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt)

class Word(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt)

class Separator(text: String, startAt: Int, endAt: Int) : TextPart(text, startAt, endAt)
