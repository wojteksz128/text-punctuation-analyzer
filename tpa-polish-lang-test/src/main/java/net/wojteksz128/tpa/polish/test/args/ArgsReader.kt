package net.wojteksz128.tpa.polish.test.args

import net.wojteksz128.tpa.polish.test.action.*
import net.wojteksz128.tpa.polish.test.printer.InConsoleResultPrinter
import net.wojteksz128.tpa.polish.test.printer.JsonResultPrinter
import net.wojteksz128.tpa.polish.test.printer.ResultPrinter

class ArgsReader {
    private val textFileReader = TextFileReader()
    private val outputNameReader = ValueArgumentReader()
    private val resultFileReader = ValueArgumentReader()
    private val prepareSolutionFileReader = ValueArgumentReader()

    private var action: Action? = null
    private var outputName: String? = null
    private var resultFile: String? = null
    private var prepareSolutionFile: String? = null
    private var resultPrinter: ResultPrinter? = null

    @ExperimentalStdlibApi
    fun readArgs(args: Array<String>): LoadedArgs {
        val textsToAnalyse = mutableListOf<String>()

        args.forEach {
            when {
                it.startsWith("-") && !registeredSwitches.contains(it) -> throw IllegalStateException("Użyto nieznanego przełącznika '$it'")
                textFileReader.checkIsFilePath(it, textsToAnalyse) -> {
                }
                outputNameReader.checkOutputName(it, "--output-name") -> outputName = outputNameReader.value
                resultFileReader.checkOutputName(it, "--result-file") -> resultFile = resultFileReader.value
                prepareSolutionFileReader.checkOutputName(it, "--prepare-solution-file") -> prepareSolutionFile =
                    prepareSolutionFileReader.value

                listOf("-p", "--prepare").contains(it) -> switchAction(PrepareAction())
                listOf("-a", "--analyze").contains(it) -> switchAction(AnalyzeAction())
                listOf("-m", "--measure-stats").contains(it) -> switchAction(MeasureStatsAction())
                listOf("-h", "--help").contains(it) -> switchAction(HelpAction())

                "--json".contains(it) -> resultPrinter = JsonResultPrinter()
                "--console".contains(it) -> resultPrinter = InConsoleResultPrinter()

                else -> textsToAnalyse += it
            }
        }
        return LoadedArgs(
            textsToAnalyse.toList(), action ?: AnalyzeAction(), outputName, resultFile,
            prepareSolutionFile, resultPrinter ?: InConsoleResultPrinter()
        )
    }

    private fun switchAction(newAction: Action) {
        if (action == null) {
            action = newAction
        } else {
            throw IllegalStateException("Zdefiniowana została więcej niż jedna akcja")
        }
    }

    companion object {
        val registeredSwitches = listOf(
            "--json",                   // wyjście z analizy w formacie JSON - używane przez AnalyzeAction
            "--console",                // wyjście z analizy na konsoli - używane przez AnalyzeAction
            "-f", "--file",             // ścieżka do wczytywanego pliku - używane przez TextFileReader
            "-p", "--prepare",          // etap przygotowania - używane przez PrepareAction
            "-a", "--analyze",          // etap realizacji analizy - używane przez AnalyzeAction
            "-m", "--measure-stats",    // etap wyliczania statystyk - używane przez MeasureStatsAction
            "-h", "--help",             // wyświetlanie pomocy - używane przez HelpAction
            "--output-name",            // nazwa plików wyjściowych - używane przez PrepareAction oraz AnalyzeAction
            "--result-file",            // ścieżka do pliku z wynikiem operacji - używane przez MeasureStatsAction
            "--prepare-solution-file"   // ścieżka do pliku z wykrytym w trakcie przygotowania wynikiem operacji - używane przez MeasureStatsAction
        )
    }
}

