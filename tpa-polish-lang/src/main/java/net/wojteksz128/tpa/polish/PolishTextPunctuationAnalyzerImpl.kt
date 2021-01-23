package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.language.LanguageAlphabetLoader
import net.wojteksz128.tpa.polish.split.PolishWordsClassifier
import net.wojteksz128.tpa.polish.validator.comma.CommaAsSentencesSeparatorValidator
import net.wojteksz128.tpa.polish.validator.dot.DotAtSentenceEndValidator
import net.wojteksz128.tpa.polish.validator.dot.DotAtTheEndOfShortcutValidator
import net.wojteksz128.tpa.polish.validator.prepare.SentenceGroupValidatorPreparer
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl

fun TextPunctuationAnalyzer.Companion.polishTextPunctuationAnalyzer(): TextPunctuationAnalyzer =
    TextPunctuationAnalyzer.Builder().textDivider(DefaultTextDividerImpl(LanguageAlphabetLoader.load()))
        .classifier(PolishWordsClassifier.instance)
        .validatorPreparers(listOf(SentenceGroupValidatorPreparer))
        .validators(listOf(DotAtSentenceEndValidator, DotAtTheEndOfShortcutValidator, CommaAsSentencesSeparatorValidator))
        .build()
