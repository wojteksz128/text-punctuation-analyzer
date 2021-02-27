package net.wojteksz128.tpa.polish.test.action

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.polish.test.action.measureStats.AnalyseCorrectnessStats
import net.wojteksz128.tpa.polish.test.action.measureStats.StatsCalculator
import net.wojteksz128.tpa.polish.test.action.measureStats.Symbol
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
        println("""
=== Statystyka łączna ===

Czas realizacji analizy całego tekstu:                       $TAB${analyzeResult.totalExecutionTimeMillis} ms
Ilość poprawnych propozycji zmian:                           $TAB${analyseStats.correctChangeSize}
Ilość oryginalnych zmian:                                    $TAB${analyseStats.requiredChangesSize}
Procent zgodności propozycji zmian poprawnych z oryginalnymi:$TAB${analyseStats.correctnessPercent * 100}%
Ilość błędnych pozycji zmian:                                $TAB${analyseStats.wrongChangeSize}
Ilość błędnych znaków na poprawnej pozycji                   $TAB${analyseStats.wrongSignInCorrectPlaceSize}

Liczba oryginalnych zmian dla poszczególnych symboli:
${Symbol.values().joinToString("\n") { "\tZnak '${it.char}': ${analyseStats.requiredChangesNoMap[it] ?: 0}" }}

Tabela skuteczności klasyfikatora

                | ${Symbol.values().joinToString(" | ", postfix = " ") { "Znaleziono '${it.char}'" }}
----------------|${(1..Symbol.values().size).joinToString("|") { "----------------" }}
${
            Symbol.values().joinToString("\n") { requiredChar ->
                " Oczekiwano '${requiredChar.char}' | ${
                    Symbol.values().joinToString(" | ") {
                        "%14d".format(
                            analyseStats.actualChangesNoInExpectedCharsMap[requiredChar]?.get(it) ?: 0
                        )
                    }
                }"
            }
        }








""")
    }

    companion object {
        private const val TAB = "\t"
    }
}

