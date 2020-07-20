package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.text.TextPartCategory

interface Classifier {
    fun classify(word: String): List<TextPartCategory>
}
