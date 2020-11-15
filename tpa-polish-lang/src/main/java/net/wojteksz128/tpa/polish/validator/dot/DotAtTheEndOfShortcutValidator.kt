package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.net.wojteksz128.tpa.polish.split.PolishWordsClassifier
import net.wojteksz128.tpa.polish.validator.haveAllOf
import net.wojteksz128.tpa.polish.validator.isClassOf
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.dag.grammar.Klasa
import net.wojteksz128.tpa.utils.dag.grammar.Liczba
import net.wojteksz128.tpa.utils.dag.grammar.Przypadek

object DotAtTheEndOfShortcutValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findShortcutsWithoutRequiredDot(text)
        possibleChanges += findShortcutsWithUnnecessaryDot(text)

        return possibleChanges
    }

    private fun findShortcutsWithoutRequiredDot(text: TextAnalyseResult): Iterable<PossibleChange> {
        return text.words.filter { it.isClassOf(Klasa.SKROT) || it.isClassOf(Klasa.FORMA_NIEROZPOZNANA) }
                .filter { it.requiresDot && !text.markAfter(".", it) }
                .map { PossibleChange(ChangeType.INSERT, it.endAt + 1, new = ".") }
    }

    private fun findShortcutsWithUnnecessaryDot(text: TextAnalyseResult): Iterable<PossibleChange> {
        return text.words.filter { it.isClassOf(Klasa.SKROT) || itMayBeShortcut(it) }
                .filter { text.markAfter(".", it) }
                .map { PossibleChange(ChangeType.DELETE, it.endAt + 1, old = ".") }
    }

    private fun itMayBeShortcut(word: Word) =
            word.isClassOf(Klasa.RZECZOWNIK) && word.haveAllOf(Przypadek.MIANOWNIK, Liczba.POJEDYNCZA)
}

// TODO: 15.11.2020 Zmiana implementacji konieczna
private val Word.requiresDot: Boolean
    get() {
        val decodedWord = PolishWordsClassifier.instance.classify(this.get()).first()
        val decodedWordWithDot = PolishWordsClassifier.instance.classify("${this.get()}.").first()
        return decodedWordWithDot.textPartSpecification.grammarClass == Klasa.SKROT
                && decodedWordWithDot.textPartSpecification.grammarClass != decodedWord.textPartSpecification.grammarClass
    }