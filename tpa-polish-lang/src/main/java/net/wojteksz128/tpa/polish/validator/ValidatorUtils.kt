package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.TextPart

// TODO: 14.12.2020 Sprawdza występowanie mark po AwareOfSurrounding - nie czy następny znak to mark
fun <T : TextPart> markAfter(mark: String, part: AwareOfSurroundings<T>) =
    part.partsBetweenLaterWord.any { it.text == mark }
