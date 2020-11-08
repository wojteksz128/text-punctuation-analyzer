package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.TextAnalyseResult

interface Classifier {
    fun classify(result: TextAnalyseResult)
}
