package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.*
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.STATEMENT_GROUP
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.Klasa
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech
import net.wojteksz128.tpa.utils.morfeusz.Przypadek

// TODO: 23.08.2020 Prepare some tests
object StatementGroupTextValidatorPreparer : TextValidatorPreparer {
    override fun prepare(result: TextAnalyseResult) {
        val verb = result.words.filter { it isTypeOf PartOfSpeech.VERB }
        val statementGroups = verb.map {
            prepareStatementGroup(it, result)
        }

        result.additionalParts[STATEMENT_GROUP.name] = statementGroups
    }

    private fun prepareStatementGroup(statement: Word, result: TextAnalyseResult): StatementGroup {
        val statementGroupWords = mutableListOf(statement)
        statementGroupWords += prepareComplement(statement, result)

        return StatementGroup(result.text, statementGroupWords.first().startAt, statementGroupWords.last().endAt, statementGroupWords)
    }

    private fun prepareComplement(statement: Word, result: TextAnalyseResult): List<Word> {
        val statementComplements = mutableListOf<Word>()
        isNounPossible = true

        statementComplements += result.textParts.filter { statement.endAt < it.startAt && it is Word }                   // get words after statement
                .map { it as Word }
                .takeWhile { canBePartOfComplement(it) }

        return statementComplements
    }

    private fun canBePartOfComplement(it: Word): Boolean {
        val isInfinitive = it isClassOf Klasa.BEZOKOLICZNIK
        val isNoun = it isTypeOf PartOfSpeech.NOUN && it.haveAnyOf(Przypadek.DOPELNIACZ, Przypadek.CELOWNIK, Przypadek.BIERNIK, Przypadek.NARZEDNIK, Przypadek.MIEJSCOWNIK)
                && isNounPossible
        if (isNoun && it.haveAnyOf(Przypadek.MIANOWNIK)) isNounPossible = false
        val isPronoun = it isTypeOf PartOfSpeech.PRONOUN
        val isAdverb = it isTypeOf PartOfSpeech.ADVERB
        return isInfinitive || isNoun || isPronoun || isAdverb
    }
}