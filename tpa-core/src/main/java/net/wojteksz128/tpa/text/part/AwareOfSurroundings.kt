package net.wojteksz128.tpa.text.part

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