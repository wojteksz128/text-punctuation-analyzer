package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.TextPart

internal var isNounPossible = true



fun TextAnalyseResult.markAfter(mark: String, part: TextPart) = punctuationMarks.filter { it.get() == mark && it.startAt == part.endAt + 1 }.size == 1