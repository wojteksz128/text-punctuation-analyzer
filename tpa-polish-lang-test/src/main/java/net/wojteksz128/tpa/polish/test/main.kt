package net.wojteksz128.tpa.polish.test

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.polishTextPunctuationAnalyzer
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

/*
* Examples:
*   "Ala ma kota."
*   "Chciałem Ci powiedzieć, że lubię często kłamać..."
*   "Proszę, kochaj mnie..."
*   "Zażółć gęślą jaźń"
*/

@ExperimentalTime
fun main(args: Array<String>) {
    val analyzer: TextPunctuationAnalyzer =
        TextPunctuationAnalyzer.Builder(TextPunctuationAnalyzer.polishTextPunctuationAnalyzer()).build()
    val resultPrinter = InConsoleResultPrinter()
    val argsReader = ArgsReader()
    val textsToAnalyse = argsReader.readArgs(args)

    textsToAnalyse.forEach { text ->
        resultPrinter.printPreparingToAnalyse(text)
        val (result, executionTime) = measureTimedValue {
            analyzer.analyze(text)
        }
        resultPrinter.printResult(result, executionTime)
    }
}

