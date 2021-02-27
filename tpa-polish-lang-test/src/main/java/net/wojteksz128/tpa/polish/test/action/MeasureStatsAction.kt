package net.wojteksz128.tpa.polish.test.action

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.polish.test.action.measureStats.ActualTextSolutionNotExistsException
import net.wojteksz128.tpa.polish.test.action.measureStats.AnalyseCorrectnessStats
import net.wojteksz128.tpa.polish.test.action.measureStats.ConnectedExpectedWithActual
import net.wojteksz128.tpa.polish.test.action.measureStats.ExpectedTextSolutionNotExistsException
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.AnalyseExecutionResult
import net.wojteksz128.tpa.polish.test.model.TextAnalyzeResultDto
import net.wojteksz128.tpa.polish.test.model.TextSolution
import net.wojteksz128.tpa.text.PossibleChange
import java.io.File
import kotlin.time.ExperimentalTime

class MeasureStatsAction : Action {
    private val klaxon = Klaxon()

    @ExperimentalTime
    override fun execute(loadedArgs: LoadedArgs) {
        val prepareStepSolution = loadPrepareStepSolution(loadedArgs)
        val analyzeResult = loadAnalyzeResult(loadedArgs)

        val textAnalyseConnectedWithOriginal =
            prepareStepSolution.map { it.textId to ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>(it) }
                .toMap()
        analyzeResult.results.forEach {
            if (textAnalyseConnectedWithOriginal.containsKey(it.textId))
                textAnalyseConnectedWithOriginal[it.textId]?.actual = it
            else throw ExpectedTextSolutionNotExistsException()
        }

        val analyseStatsForTexts = textAnalyseConnectedWithOriginal.values.map { expectedWithActual ->
            val map = expectedWithActual.expected.solution.map {
                it.position to ConnectedExpectedWithActual<PossibleChange?, MutableList<PossibleChange>>(
                    it,
                    mutableListOf()
                )
            }.toMap().toMutableMap()
            (expectedWithActual.actual ?: throw ActualTextSolutionNotExistsException()).solution.forEach {
                if (!map.containsKey(it.position))
                    map[it.position] = ConnectedExpectedWithActual<PossibleChange?, MutableList<PossibleChange>>(
                        null,
                        mutableListOf(it)
                    )
                map[it.position]?.actual?.plusAssign(it)
            }

            // Stosunek ilości znalezionych rozwiązań w stosunku do ilości wprowadzonych zmian w tekście oryginalnym (np. 1 z 2 (50%)),
            val correctChangeSize = map.values.filter { it.expected in it.actual!! }.size
            val requiredChangesSize = expectedWithActual.expected.solution.size

            // Ilość błędnych miejsc,
            val wrongChangeSize = map.values.filter { it.expected == null }.size

            // Ilość poprawnych miejsc, ale niepoprawnych znaków.
            val wrongSignInCorrectPlaceSize =
                map.values.filter { expectedChangesWithActual -> expectedChangesWithActual.expected != null && expectedChangesWithActual.actual?.any { expectedChangesWithActual.expected != it } ?: false }.size

            AnalyseCorrectnessStats(
                correctChangeSize,
                requiredChangesSize,
                wrongChangeSize,
                wrongSignInCorrectPlaceSize
            )
        }
        val analyseStats = if (analyseStatsForTexts.isNotEmpty()) analyseStatsForTexts.reduce { a, b -> a + b }
        else AnalyseCorrectnessStats(0, 0, 0, 0)

        println("=== Statystyka łączna ===")
        println()
        println("Czas realizacji analizy całego tekstu:                       \t${analyzeResult.totalExecutionTimeMillis} ms")
        println("Ilość poprawnych propozycji zmian:                           \t${analyseStats.correctChangeSize}")
        println("Ilość oryginalnych zmian:                                    \t${analyseStats.requiredChangesSize}")
        println("Procent zgodności propozycji zmian poprawnych z oryginalnymi:\t${analyseStats.correctnessPercent * 100}%")
        println("Ilość błędnych pozycji zmian:                                \t${analyseStats.wrongChangeSize}")
        println("Ilość błędnych znaków na poprawnej pozycji                   \t${analyseStats.wrongSignInCorrectPlaceSize}")
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
}

