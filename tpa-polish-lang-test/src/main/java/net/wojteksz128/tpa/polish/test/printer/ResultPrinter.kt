package net.wojteksz128.tpa.polish.test.printer

import net.wojteksz128.tpa.TextAnalyseResult
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

interface ResultPrinter {
    fun printPreparingToAnalyse(text: String)

    @ExperimentalTime
    fun printResult(result: TextAnalyseResult, executionTime: Duration)
}