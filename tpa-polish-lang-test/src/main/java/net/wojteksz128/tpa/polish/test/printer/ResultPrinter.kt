package net.wojteksz128.tpa.polish.test.printer

import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.AnalyseExecutionResult
import net.wojteksz128.tpa.polish.test.model.TextAnalyzeResultDto
import kotlin.time.ExperimentalTime

interface ResultPrinter {
    fun printPreparingToAnalyse(text: String)

    @ExperimentalTime
    fun printOneTextAnalyseResult(result: TextAnalyzeResultDto, loadedArgs: LoadedArgs)
    fun printAfterAllAnalysis(analyzeExecutionResult: AnalyseExecutionResult, loadedArgs: LoadedArgs)
}