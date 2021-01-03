package net.wojteksz128.tpa.text.part

import net.wojteksz128.tpa.utils.dag.TextPartInterpretation

abstract class TextPart(
    val fullText: String, val startAt: Int, val endAt: Int,
    var possibleCategories: MutableList<TextPartInterpretation> = mutableListOf()
) {
    val text: String
        get() = fullText.substring(startAt, endAt + 1)

    override fun toString() = text
}

