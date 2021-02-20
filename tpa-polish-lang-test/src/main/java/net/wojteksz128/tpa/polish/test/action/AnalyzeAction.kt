package net.wojteksz128.tpa.polish.test.action

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.polishTextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.printer.InConsoleResultPrinter
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class AnalyzeAction : Action {
    private val resultPrinter = InConsoleResultPrinter()
    private val analyzer: TextPunctuationAnalyzer =
        TextPunctuationAnalyzer.Builder(TextPunctuationAnalyzer.polishTextPunctuationAnalyzer()).build()

    @ExperimentalTime
    override fun execute(loadedArgs: LoadedArgs) {
        loadedArgs.texts.forEach { text ->
            resultPrinter.printPreparingToAnalyse(text)
            val (result, executionTime) = measureTimedValue {
                analyzer.analyze(text)
            }
            resultPrinter.printResult(result, executionTime)
        }
    }
}