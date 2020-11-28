package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.language.LanguageAlphabetLoader
import net.wojteksz128.tpa.polish.net.wojteksz128.tpa.polish.split.PolishWordsClassifier
import net.wojteksz128.tpa.polish.validator.dot.DotAtSentenceEndValidator
import net.wojteksz128.tpa.polish.validator.dot.DotAtTheEndOfShortcutValidator
import net.wojteksz128.tpa.polish.validator.prepare.SentenceGroupValidatorPreparer
import net.wojteksz128.tpa.polish.validator.prepare.StatementGroupTextValidatorPreparer
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl

class PolishTextPunctuationAnalyzerImpl : TextPunctuationAnalyzer(DefaultTextDividerImpl(LanguageAlphabetLoader.load()),
        PolishWordsClassifier.instance) {

    init {
        validatorPreparers += StatementGroupTextValidatorPreparer
        validatorPreparers += SentenceGroupValidatorPreparer

        validators += DotAtSentenceEndValidator
        validators += DotAtTheEndOfShortcutValidator
    }
}
