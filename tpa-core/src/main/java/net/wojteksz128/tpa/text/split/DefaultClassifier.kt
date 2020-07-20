package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.text.TextPartCategory

class DefaultClassifier : Classifier {
    override fun classify(word: String) = listOf<TextPartCategory>()
}