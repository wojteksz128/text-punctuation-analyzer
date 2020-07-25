package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.Separator
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.Klasa
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech
import net.wojteksz128.tpa.utils.morfeusz.Przypadek

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
    val isNoun = it isTypeOf PartOfSpeech.NOUN/* && it.haveOneOf(Przypadek.DOPELNIACZ, Przypadek.CELOWNIK, Przypadek.BIERNIK, Przypadek.NARZEDNIK, Przypadek.MIEJSCOWNIK)*/
            && isNounPossible
    if (isNoun && it.haveOneOf(Przypadek.MIANOWNIK)) isNounPossible = false
    val isPronoun = it isTypeOf PartOfSpeech.PRONOUN
    val isAdverb = it isTypeOf PartOfSpeech.ADVERB
    return isInfinitive || isNoun || isPronoun || isAdverb


    /*
    val possibleComplement
            = textParts.filter { statement.endAt < it.startAt && it !is Separator }
            .takeWhile { it is Word && !it.isTypeOf(PartOfSpeech.VERB) }.map { it as Word }
    possibleComplement.forEach {
        if (it.isInClass("inf")
                || (it.isTypeOf(PartOfSpeech.NOUN)/* && it.isInOneOfCategories("gen", "dat", "acc", "inst", "loc")*/)
                || it.isTypeOf(PartOfSpeech.PRONOUN)) {
            sentenceComplements += possibleComplement
        }
    }*/
}

fun TextAnalyseResult.markAfter(mark: String, part: TextPart) = punctuationMarks.filter { it.get() == mark && it.startAt == part.endAt + 1 }.size == 1