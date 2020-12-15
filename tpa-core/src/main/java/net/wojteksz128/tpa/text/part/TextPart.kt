package net.wojteksz128.tpa.text.part

import net.wojteksz128.tpa.utils.dag.TextPartInterpretation

abstract class TextPart(
    val text: String, val startAt: Int, val endAt: Int,
    var possibleCategories: MutableList<TextPartInterpretation> = mutableListOf()
) {
    open fun get() = text.substring(startAt, endAt + 1)
}

