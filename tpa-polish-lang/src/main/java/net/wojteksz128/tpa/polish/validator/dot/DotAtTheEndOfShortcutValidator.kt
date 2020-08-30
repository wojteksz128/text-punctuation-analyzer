package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.haveAllOf
import net.wojteksz128.tpa.polish.validator.isClassOf
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.*

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

private val Word.requiresDot: Boolean
    get() {
        val decodedWord = MorfeuszClassifier.classify(this.get()).first() as MorfeuszDecoded
        val decodedWordWithDot = MorfeuszClassifier.classify("${this.get()}.").first() as MorfeuszDecoded
        return decodedWordWithDot.grammarClass == Klasa.SKROT && decodedWordWithDot.grammarClass != decodedWord.grammarClass
    }