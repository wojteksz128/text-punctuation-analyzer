package net.wojteksz128.tpa.utils

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator

class MockTextValidator(private val returns: List<PossibleChange>) : TextValidator() {
    override fun validate(analyseData: TextAnalyseData) = returns
}