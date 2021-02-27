package net.wojteksz128.tpa.polish.test.action

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.polish.test.action.measureStats.AnalyseCorrectnessStats
import net.wojteksz128.tpa.polish.test.action.measureStats.StatsCalculator
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.AnalyseExecutionResult
import net.wojteksz128.tpa.polish.test.model.TextSolution
import java.io.File
import kotlin.time.ExperimentalTime

@ExperimentalStdlibApi
class MeasureStatsAction : Action {
    private val klaxon = Klaxon()
    private val statsCalculator = StatsCalculator()

    @ExperimentalTime
    override fun execute(loadedArgs: LoadedArgs) {
        val prepareStepSolution = loadPrepareStepSolution(loadedArgs)
        val analyzeResult = loadAnalyzeResult(loadedArgs)

        val analyseStats = statsCalculator.calculate(prepareStepSolution, analyzeResult)

        printStats(analyzeResult, analyseStats)
    }

    private fun loadPrepareStepSolution(loadedArgs: LoadedArgs): List<TextSolution> {
        val prepareSolutionFilePath = loadedArgs.prepareSolutionFile
            ?: throw IllegalArgumentException("Nie zdefiniowano parametru '--prepare-solution-file'.")
        return klaxon.parseArray(File(prepareSolutionFilePath))
            ?: throw IllegalStateException("Nie udało się załadować pliku '$prepareSolutionFilePath'")
    }

    private fun loadAnalyzeResult(loadedArgs: LoadedArgs): AnalyseExecutionResult {
        val resultFilePath =
            loadedArgs.resultFile ?: throw IllegalArgumentException("Nie zdefiniowano parametru '--result-file'.")
        return klaxon.parse<AnalyseExecutionResult>(File(resultFilePath))
            ?: throw IllegalStateException("Nie udało się załadować pliku '$resultFilePath'")
    }


    @ExperimentalTime
    private fun printStats(
        analyzeResult: AnalyseExecutionResult,
        analyseStats: AnalyseCorrectnessStats
    ) {
        println("=== Statystyka łączna ===")
        println()
        println("Czas realizacji analizy całego tekstu:                       \t${analyzeResult.totalExecutionTimeMillis} ms")
        println("Ilość poprawnych propozycji zmian:                           \t${analyseStats.correctChangeSize}")
        println("Ilość oryginalnych zmian:                                    \t${analyseStats.requiredChangesSize}")
        println("Procent zgodności propozycji zmian poprawnych z oryginalnymi:\t${analyseStats.correctnessPercent * 100}%")
        println("Ilość błędnych pozycji zmian:                                \t${analyseStats.wrongChangeSize}")
        println("Ilość błędnych znaków na poprawnej pozycji                   \t${analyseStats.wrongSignInCorrectPlaceSize}")
    }
}

