package net.wojteksz128.tpa.text.split

import net.wojteksz128.tpa.TextAnalyseData

interface Classifier {
    fun classify(analyseData: TextAnalyseData)
}
