package net.wojteksz128.tpa.polish.test

import net.wojteksz128.tpa.TextAnalyseResult
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

internal interface ResultPrinter {
    fun printPreparingToAnalyse(text: String)

    @ExperimentalTime
    fun printResult(result: TextAnalyseResult, executionTime: Duration)
}