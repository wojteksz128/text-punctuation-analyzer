package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.Klasa
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech
import net.wojteksz128.tpa.utils.morfeusz.Przypadek.BIERNIK
import net.wojteksz128.tpa.utils.morfeusz.Przypadek.CELOWNIK
import net.wojteksz128.tpa.utils.morfeusz.Przypadek.DOPELNIACZ
import net.wojteksz128.tpa.utils.morfeusz.Przypadek.MIANOWNIK
import net.wojteksz128.tpa.utils.morfeusz.Przypadek.MIEJSCOWNIK
import net.wojteksz128.tpa.utils.morfeusz.Przypadek.NARZEDNIK

internal var isNounPossible = true

fun TextAnalyseResult.prepareStatementGroup(statement: Word): StatementGroup {
    val statementGroupWords = mutableListOf(statement)
    statementGroupWords += prepareComplement(statement)

    return StatementGroup(this.text, statementGroupWords.first().startAt, statementGroupWords.last().endAt, statementGroupWords)
}

private fun TextAnalyseResult.prepareComplement(statement: Word): List<Word> {
    val sentenceComplements = mutableListOf<Word>()
    isNounPossible = true

    sentenceComplements += textParts.filter { statement.endAt < it.startAt && it !is Separator }                        // get words after statement
            .takeWhile { it is Word && canBePartOfComplement(it) }
            .map { it as Word }                                                                                         // map to Word

    return sentenceComplements
}

private fun canBePartOfComplement(it: Word): Boolean {
    val isInfinitive = it isClassOf Klasa.BEZOKOLICZNIK
    val isNoun = it isTypeOf PartOfSpeech.NOUN && it.haveAnyOf(DOPELNIACZ, CELOWNIK, BIERNIK, NARZEDNIK, MIEJSCOWNIK)
            && isNounPossible
    if (isNoun && it.haveAnyOf(MIANOWNIK)) isNounPossible = false
    val isPronoun = it isTypeOf PartOfSpeech.PRONOUN
    val isAdverb = it isTypeOf PartOfSpeech.ADVERB
    return isInfinitive || isNoun || isPronoun || isAdverb
}

fun TextAnalyseResult.markAfter(mark: String, part: TextPart) = punctuationMarks.filter { it.get() == mark && it.startAt == part.endAt + 1 }.size == 1