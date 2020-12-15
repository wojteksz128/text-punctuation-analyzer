package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.PunctuationMark
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.text.part.Word

data class TextAnalyseData(val text: String, val textParts: List<TextPart>) {
    val words = textParts.filterIsInstance<Word>().map { AwareOfSurroundings(it) }.sortedBy { it.startAt }
    val punctuationMarks = textParts.filterIsInstance<PunctuationMark>().map { AwareOfSurroundings(it) }
    val additionalParts = mutableMapOf<String, List<*>>()
    val possibleChanges = mutableMapOf<TextValidator, List<PossibleChange>>()

    init {
        words.zipWithNext { a, b -> a.withWordAfter(b); b.withWordBefore(a); }
        words.forEach { word ->
            val earlierParts =
                textParts.filter { textPart -> word.wordBefore?.let { textPart.startAt > it.endAt } ?: true && textPart.endAt < word.startAt }
            val laterParts =
                textParts.filter { textPart -> textPart.startAt > word.endAt && word.wordAfter?.let { textPart.endAt < it.startAt } ?: true }

            word.withPartsBetweenEarlierWord(earlierParts).withPartsBetweenLaterWord(laterParts)
        }

        punctuationMarks.forEach { punctuationMark ->
            val previous =
                words.minBy { if (it.endAt > punctuationMark.startAt) Int.MAX_VALUE else punctuationMark.startAt - it.endAt }
            val next =
                words.minBy { if (it.startAt < punctuationMark.endAt) Int.MAX_VALUE else it.startAt - punctuationMark.endAt }
            val earlierParts =
                textParts.filter { textPart -> punctuationMark.wordBefore?.let { textPart.startAt > it.endAt } ?: true && textPart.endAt < punctuationMark.startAt }
            val laterParts =
                textParts.filter { textPart -> textPart.startAt > punctuationMark.endAt && punctuationMark.wordAfter?.let { textPart.endAt < it.startAt } ?: true }

            punctuationMark.withWordBefore(previous)
                .withWordAfter(next)
                .withPartsBetweenEarlierWord(earlierParts)
                .withPartsBetweenLaterWord(laterParts)
        }
    }
}
