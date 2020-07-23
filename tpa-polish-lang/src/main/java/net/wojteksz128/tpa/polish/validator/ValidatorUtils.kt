package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszDecoded
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech


fun TextAnalyseResult.prepareStatementGroup(word: Word): StatementGroup {
    val statementGroupWords = mutableListOf(word)
    statementGroupWords += textParts.filter { it.startAt > word.endAt && it !is Separator }
            .sortedBy { it.startAt }
            .takeWhile { it is Word && !(it isTypeOf PartOfSpeech.VERB) }
            .map { it as Word }

    return StatementGroup(this.text, statementGroupWords.first().startAt, statementGroupWords.last().endAt, statementGroupWords)
}

infix fun Word.isTypeOf(partOfSpeech: PartOfSpeech) = this.possibleCategories.map { it as MorfeuszDecoded }.any { it.grammarClass?.partOfSpeech == partOfSpeech }

fun TextAnalyseResult.markAfter(mark: String, part: TextPart) = punctuationMarks.filter { it.get() == mark && it.startAt == part.endAt + 1 }.size == 1