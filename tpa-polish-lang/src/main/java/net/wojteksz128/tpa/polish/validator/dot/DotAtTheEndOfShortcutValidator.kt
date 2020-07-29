package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.isClassOf
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.Klasa
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszDecoded

private val Word.requiresDot: Boolean
    get() {
        val decodedWord = MorfeuszClassifier.classify(this.get()).first() as MorfeuszDecoded
        val decodedWordWithDot = MorfeuszClassifier.classify("${this.get()}.").first() as MorfeuszDecoded
        return decodedWord.grammarClass != decodedWordWithDot.grammarClass
    }

object DotAtTheEndOfShortcutValidator : TextValidator {

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += getShortcutsWithoutRequiredDot(text)

        return possibleChanges
    }

    private fun getShortcutsWithoutRequiredDot(text: TextAnalyseResult): List<PossibleChange> {
        return text.words.filter { it.isClassOf(Klasa.SKROT) || it.isClassOf(Klasa.FORMA_NIEROZPOZNANA) }
                .filter { it.requiresDot && !text.markAfter(".", it) }
                .map { PossibleChange(it.endAt + 1, ".") }
    }
}
