package net.wojteksz128.tpa.polish.test.printer

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.AnalyseExecutionResult
import net.wojteksz128.tpa.polish.test.model.TextAnalyzeResultDto
import java.io.File
import kotlin.time.ExperimentalTime

class JsonResultPrinter : ResultPrinter {
    private val durationConverter = TextAnalyzeResultDto.DurationConverter()
    private val progressText = "Trwa analiza..."

    override fun printPreparingToAnalyse(text: String) {
        println("----------")
        println()
        println("Wczytany tekst: $text")
        println()
        println(progressText)
    }

    @ExperimentalTime
    override fun printOneTextAnalyseResult(result: TextAnalyzeResultDto, loadedArgs: LoadedArgs) {
        1.rangeTo(progressText.length).forEach { _ -> print("\b \b") }
        println("Czas realizacji: ${result.executionTime.inMilliseconds} ms")

    }

    @ExperimentalTime
    override fun printAfterAllAnalysis(analyzeExecutionResult: AnalyseExecutionResult, loadedArgs: LoadedArgs) {
        println("Łączny czas realizacji: ${analyzeExecutionResult.totalExecutionTime.inMilliseconds} ms")
        val filePath = loadedArgs.outputName ?: "result.json"
        save(analyzeExecutionResult, filePath)
        println("Rezultat analiz wszystkich tekstów został zapisany do pliku '$filePath'.")
    }

    private fun save(textSolution: AnalyseExecutionResult, filePath: String) {
        val toJsonString = Klaxon().fieldConverter(TextAnalyzeResultDto.KlaxonDuration::class, durationConverter)
            .toJsonString(textSolution)
        File(filePath).writeText(toJsonString)
    }
}