package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.TextAnalyseData

interface TextValidatorPreparer {
    fun prepare(analyseData: TextAnalyseData)
}
