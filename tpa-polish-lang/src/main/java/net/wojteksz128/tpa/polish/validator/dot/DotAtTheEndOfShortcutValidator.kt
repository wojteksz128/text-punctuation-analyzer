package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.split.PolishWordsClassifier
import net.wojteksz128.tpa.polish.validator.haveAllOf
import net.wojteksz128.tpa.polish.validator.isClassOf
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.part.Word
import net.wojteksz128.tpa.text.rule.Rule
import net.wojteksz128.tpa.text.rule.RuleBreak
import net.wojteksz128.tpa.utils.dag.grammar.Klasa
import net.wojteksz128.tpa.utils.dag.grammar.Liczba
import net.wojteksz128.tpa.utils.dag.grammar.Przypadek

object DotAtTheEndOfShortcutValidator
    : TextValidator(listOf(SomeShortcutsRequiresDotRule, SomeShortcutsNotNeedDotRule))

object SomeShortcutsRequiresDotRule : Rule {

    override fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak> {
        return analyseData.words.filter { it.base.isClassOf(Klasa.SKROT) || it.base.isClassOf(Klasa.FORMA_NIEROZPOZNANA) }
            .filter { it.base.requiresDot && !markAfter(".", it) }
            .map { RuleBreak(this, it, analyseData) }
    }

    override fun prepareSolution(ruleBreak: RuleBreak) =
        PossibleChange(ChangeType.INSERT, ruleBreak.textPart.endAt + 1, new = ".")
}

object SomeShortcutsNotNeedDotRule : Rule {

    override fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak> {
        return analyseData.words.filter { it.base.isClassOf(Klasa.SKROT) || it.base.mayBeShortcut }
            .filter { markAfter(".", it) }
            .map { RuleBreak(this, it, analyseData) }
    }

    override fun prepareSolution(ruleBreak: RuleBreak) =
        PossibleChange(ChangeType.DELETE, ruleBreak.textPart.endAt + 1, old = ".")
}

private val Word.mayBeShortcut: Boolean
    get() = isClassOf(Klasa.RZECZOWNIK) && haveAllOf(Przypadek.MIANOWNIK, Liczba.POJEDYNCZA)

// TODO: 15.11.2020 Zmiana implementacji konieczna
private val Word.requiresDot: Boolean
    get() {
        this.possibleCategories.any { it.textPartSpecification.grammarClass == Klasa.SKROT }

        val decodedWordWithDot = PolishWordsClassifier.instance.classify("${this.text}.")
        return decodedWordWithDot.any { it.textPartSpecification.grammarClass == Klasa.SKROT }
                && decodedWordWithDot.intersect(this.possibleCategories)
            .none { it.textPartSpecification.grammarClass == Klasa.SKROT }
    }