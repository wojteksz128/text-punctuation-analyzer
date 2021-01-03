package net.wojteksz128.tpa.text.part

import net.wojteksz128.tpa.utils.dag.TextPartInterpretation

abstract class TextPart(
    val text: String, val startAt: Int, val endAt: Int,
    var possibleCategories: MutableList<TextPartInterpretation> = mutableListOf()
) {
    // TODO: 03.01.2021 change to property
    open fun get() = text.substring(startAt, endAt + 1)
    override fun toString() = get()
}

