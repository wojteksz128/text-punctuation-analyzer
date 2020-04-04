package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.language.PolishAlphabet
import net.wojteksz128.tpa.text.split.DefaultTextDividerImpl

class PolishTextPunctuationAnalyzerImpl : TextPunctuationAnalyzer(DefaultTextDividerImpl(PolishAlphabet))
