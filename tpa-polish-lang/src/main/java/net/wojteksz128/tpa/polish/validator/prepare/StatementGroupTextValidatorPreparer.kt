package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.*
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.STATEMENT_GROUP
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word
import net.wojteksz128.tpa.utils.dag.grammar.Klasa
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech
import net.wojteksz128.tpa.utils.dag.grammar.Przypadek

// TODO: 23.08.2020 Prepare some tests
object StatementGroupTextValidatorPreparer : TextValidatorPreparer {
    override fun prepare(analyseData: TextAnalyseData) {
        val verb = analyseData.words.filter { it.base isTypeOf PartOfSpeech.VERB }
        val statementGroups = verb.map { prepareStatementGroup(it) }.toMutableList()
        statementGroups.reversed().zipWithNext { first, second -> first.items.removeAll(second.items) }
        statementGroups.removeIf { it.items.isEmpty() }

        // TODO: 15.12.2020 Assign surroundings
        analyseData.additionalParts[STATEMENT_GROUP.name] = statementGroups.map { AwareOfSurroundings(it) }.toList()
    }

    private fun prepareStatementGroup(statement: AwareOfSurroundings<Word>): StatementGroup {
        val complementWords = (listOf(statement) + selectComplementWords(statement)).toMutableList()

        return StatementGroup(
            statement.text,
            complementWords.first().startAt,
            complementWords.last().endAt,
            complementWords
        )
    }

    private fun selectComplementWords(statement: AwareOfSurroundings<Word>): List<AwareOfSurroundings<Word>> {
        val statementComplements = mutableListOf<AwareOfSurroundings<Word>>()
        isNounPossible = true

        var wordAwareOfSurroundings: AwareOfSurroundings<Word>? = statement.wordAfter

        while (wordAwareOfSurroundings?.let { canBePartOfComplement(it.base) } == true) {
            statementComplements += wordAwareOfSurroundings
            wordAwareOfSurroundings = wordAwareOfSurroundings.wordAfter
        }

        return statementComplements
    }

    private fun canBePartOfComplement(it: Word): Boolean {
        val isInfinitive = it isClassOf Klasa.BEZOKOLICZNIK
        val isNoun = it isTypeOf PartOfSpeech.NOUN && it.haveAnyOf(Przypadek.DOPELNIACZ, Przypadek.CELOWNIK, Przypadek.BIERNIK, Przypadek.NARZEDNIK, Przypadek.MIEJSCOWNIK)
                && isNounPossible
        isNounPossible = !(isNoun && it.haveAnyOf(Przypadek.MIANOWNIK))
        val isPronoun = it isTypeOf PartOfSpeech.PRONOUN
        val isPreposition = it isTypeOf PartOfSpeech.PREPOSITION
        val isAdverb = it isTypeOf PartOfSpeech.ADVERB
        return isInfinitive || isNoun || isPronoun || isAdverb || isPreposition
    }
}