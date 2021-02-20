package net.wojteksz128.tpa.polish.test.printer

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class InConsoleResultPrinter : ResultPrinter {
    private val progressText = "Trwa analiza..."

    override fun printPreparingToAnalyse(text: String) {
        println("----------")
        println()
        println("Wczytany tekst: $text")
        println()
        print(progressText)
    }

    @ExperimentalTime
    override fun printResult(result: TextAnalyseResult, executionTime: Duration, loadedArgs: LoadedArgs) {
        printRecognizedParts(result)
        printPossibleChanges(result)
        printRealizationTime(executionTime)
    }

    private fun printRecognizedParts(result: TextAnalyseResult) {
        1.rangeTo(progressText.length).forEach { _ -> print("\b \b") }
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
}