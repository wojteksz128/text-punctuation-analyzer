package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import java.io.File
import kotlin.time.Duration
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
    val textsToAnalyse = readTextsToAnalyseFromArgs(args)

    textsToAnalyse.forEach { text ->
        val recognizingText = printPreparingToClassifyText(text)
        val (result, executionTime) = measureTimedValue {
            analyzer.analyze(text)
        }
        printRecognizedParts(recognizingText, result)
        printPossibleChanges(result)
        printRealizationTime(executionTime)
    }
}

private fun readTextsToAnalyseFromArgs(args: Array<String>): MutableList<String> {
    val textsToAnalyse = mutableListOf<String>()
    var filePathExpected = false

    args.forEach {
        if (listOf("--file", "-f", "-file").contains(it) && !filePathExpected) {
            filePathExpected = true
        } else if (filePathExpected) {
            val fileContentStream = File(it).inputStream()
            textsToAnalyse += fileContentStream.bufferedReader().readLines()
            filePathExpected = false
        } else {
            textsToAnalyse += it
        }
    }
    return textsToAnalyse
}

private fun printPreparingToClassifyText(text: String): String {
    println("----------")
    println()
    println("Wczytany tekst: $text")
    println()
    val recognizingText = "Trwa rozpoznawanie..."
    print(recognizingText)
    return recognizingText
}

private fun printRecognizedParts(recognizingText: String, result: TextAnalyseResult) {
    1.rangeTo(recognizingText.length).forEach { _ -> print("\b \b") }
    println("\rRozpoznano:")
    result.textParts.forEach { textPart ->
        println(
            " -\t${textPart.javaClass.simpleName} '${textPart.text}' na pozycji ${textPart.startAt}-${textPart.endAt} " +
                    if (textPart.possibleCategories.isNotEmpty()) "sklasyfikowany jako:" else "bez klasyfikacji"
        )
        textPart.possibleCategories.forEach { println("\t\t${formatToPrint(it)}") }
        println()
    }
}

private fun printPossibleChanges(result: TextAnalyseResult) {
    println("Sugerowane zmiany")
    result.possibleChanges.forEach {
        val message = when (it.changeType) {
            ChangeType.INSERT -> "Wstaw \"${it.new}\" na pozycję ${it.position}"
            ChangeType.REPLACE -> "Zamień \"${it.old}\" z pozycji ${it.position} na \"${it.new}\""
            ChangeType.DELETE -> "Usuń \"${it.old}\" z pozycji ${it.position}"
        }
        println("  -\t$message")
    }
}

private fun formatToPrint(interpretation: TextPartInterpretation): String {
    val partSpecification = interpretation.textPartSpecification
    val probability = "%.5f".format(partSpecification.probability)
    val grammarClass = partSpecification.grammarClass.name
    val categories = partSpecification.wordCategories.joinToString(prefix = ", ") { it.displayName }

    return "(${probability}) $grammarClass$categories"
}

@ExperimentalTime
private fun printRealizationTime(executionTime: Duration) {
    println("Realization time: ${executionTime.inMilliseconds} ms")
}
