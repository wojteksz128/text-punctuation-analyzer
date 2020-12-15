package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.AwareOfSurroundings
import net.wojteksz128.tpa.text.TextPart

internal var isNounPossible = true

// TODO: 14.12.2020 Sprawdza występowanie mark po AwareOfSurrounding - nie czy następny znak to mark
fun <T : TextPart> markAfter(mark: String, part: AwareOfSurroundings<T>) =
    part.partsBetweenLaterWord.any { it.get() == mark }
