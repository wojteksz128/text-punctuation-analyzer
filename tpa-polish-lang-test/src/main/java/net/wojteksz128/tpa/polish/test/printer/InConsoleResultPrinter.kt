package net.wojteksz128.tpa.polish.test.printer

import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.AnalyseExecutionResult
import net.wojteksz128.tpa.polish.test.model.TextAnalyzeResultDto
import net.wojteksz128.tpa.polish.test.model.TextPartDto
import net.wojteksz128.tpa.polish.test.model.TextPartSpecificationDto
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
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
    override fun printOneTextAnalyseResult(result: TextAnalyzeResultDto, loadedArgs: LoadedArgs) {
        printRecognizedParts(result.textParts)
        printPossibleChanges(result.solution)
        println("Czas realizacji: ${result.executionTime.inMilliseconds} ms")
    }

    private fun printRecognizedParts(textParts: List<TextPartDto>) {
        1.rangeTo(progressText.length).forEach { _ -> print("\b \b") }
        println("\rRozpoznano:")
        textParts.forEach { textPart ->
            println(
                " -\t${textPart.javaClass.simpleName} '${textPart.text}' na pozycji ${textPart.startAt}-${textPart.endAt} " +
                        if (textPart.possibleCategories.isNotEmpty()) "sklasyfikowany jako:" else "bez klasyfikacji"
            )
            textPart.possibleCategories.forEach { println("\t\t${formatToPrint(it)}") }
            println()
        }
    }

    private fun printPossibleChanges(solution: List<PossibleChange>) {
        println("Sugerowane zmiany")
        solution.forEach {
            val message = when (it.changeType) {
                ChangeType.INSERT -> "Wstaw \"${it.new}\" na pozycję ${it.position}"
                ChangeType.REPLACE -> "Zamień \"${it.old}\" z pozycji ${it.position} na \"${it.new}\""
                ChangeType.DELETE -> "Usuń \"${it.old}\" z pozycji ${it.position}"
            }
            println("  -\t$message")
        }
    }

    private fun formatToPrint(specificationDto: TextPartSpecificationDto): String {
        val probability = "%.5f".format(specificationDto.probability)
        val grammarClass = specificationDto.grammarClass.name
        val categories = specificationDto.categories.joinToString(prefix = ", ") { it.name }

        return "(${probability}) $grammarClass$categories"
    }

    @ExperimentalTime
    override fun printAfterAllAnalysis(analyzeExecutionResult: AnalyseExecutionResult, loadedArgs: LoadedArgs) {
        println("Łączny czas realizacji: ${analyzeExecutionResult.totalExecutionTime.inMilliseconds} ms")
    }
}