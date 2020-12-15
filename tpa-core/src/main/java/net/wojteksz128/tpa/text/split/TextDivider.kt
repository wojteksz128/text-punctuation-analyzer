package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.text.part.TextPart

interface TextDivider {
    fun divide(text: String): List<TextPart>
}
