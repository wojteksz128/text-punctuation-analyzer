package net.wojteksz128.tpa.polish.test.action

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.polishTextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class AnalyzeAction : Action {
    private val analyzer: TextPunctuationAnalyzer =
        TextPunctuationAnalyzer.Builder(TextPunctuationAnalyzer.polishTextPunctuationAnalyzer()).build()

    @ExperimentalTime
    override fun execute(loadedArgs: LoadedArgs) {
        loadedArgs.texts.forEach { text ->
            loadedArgs.resultPrinter.printPreparingToAnalyse(text)
            val (result, executionTime) = measureTimedValue {
                analyzer.analyze(text)
            }
            loadedArgs.resultPrinter.printResult(result, executionTime, loadedArgs)
        }
    }
}