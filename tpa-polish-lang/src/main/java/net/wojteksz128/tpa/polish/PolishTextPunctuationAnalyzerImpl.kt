package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.language.PolishAlphabet
import net.wojteksz128.tpa.polish.validator.dot.DotAtSentenceEndValidator
import net.wojteksz128.tpa.polish.validator.dot.DotAtTheEndOfShortcutValidator
import net.wojteksz128.tpa.polish.validator.prepare.SentenceGroupValidatorPreparer
import net.wojteksz128.tpa.polish.validator.prepare.StatementGroupTextValidatorPreparer
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier

class PolishTextPunctuationAnalyzerImpl : TextPunctuationAnalyzer(DefaultTextDividerImpl(PolishAlphabet), MorfeuszClassifier) {

    init {
        validatorPreparers += StatementGroupTextValidatorPreparer
        validatorPreparers += SentenceGroupValidatorPreparer

        validators += DotAtSentenceEndValidator
        validators += DotAtTheEndOfShortcutValidator
    }
}
