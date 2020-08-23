package net.wojteksz128.tpa.text

import net.wojteksz128.tpa.TextAnalyseResult

interface TextValidatorPreparer {
    fun prepare(result: TextAnalyseResult)
}
