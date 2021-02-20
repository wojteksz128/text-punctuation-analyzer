package net.wojteksz128.tpa.polish.test.action

import net.wojteksz128.tpa.polish.test.args.LoadedArgs

class HelpAction : Action {
    override fun execute(loadedArgs: LoadedArgs) {
        printHelp()
    }

    fun printHelp() {
        println("java -cp <ścieżka do jmorfeusz.jar>:<ścieżka do jar programu> net.wojteksz128.tpa.polish.test.MainKt [args]")
        println()
        println("o-----------------------------o")
        println("|                             |")
        println("| Etap przygotowania do testu |")
        println("|                             |")
        println("o-----------------------------o")
        println()
        println("W trakcie tego etapu z tekstu wprowadzonego na wejściu usuwane są wszystkie sprawdzane znaki")
        println("interpunkcyjne. Rezultatem są pliki:")
        println("\toutput.txt            zawiera tekst wejściowy z usuniętymi znakami")
        println("\toutput.solution.json  zawiera informacje o wszystkich usuniętych znakach z tekstu wejściowego")
        println()
        println("\t-p|--prepare [--output-name <nazwa>] [<tekst>] [-f|--file <ścieżka>]")
        println()
        println("Argumenty:")
        println("\t-p, --prepare          oznaczenie wykonania etapu przygotowania tekstu do wykonania testu")
        println("\t--output-name <nazwa>  (opcjonalne) określenie nazwy plików wyjściowych txt oraz json;")
        println("\t                       podawać bez rozszerzenia; domyślnie 'output'")
        println("<tekst>                  tekst wejściowy")
        println("-f, --file <ścieżka>     ścieżka do plików tekstów wejściowych")
        println()
        println("o--------------------o")
        println("|                    |")
        println("| Etap analizy testu |")
        println("|                    |")
        println("o--------------------o")
        println()
        println("W trakcie tego etapu z tekstu jest analizowany pod względem zgodności z regułami interpunkcynymi.")
        println()
        println("\t[-a|--analyze] [--json [--output-name <nazwa>]|--console] [<tekst>] [-f|--file <ścieżka>]")
        println()
        println("Argumenty:")
        println("\t-a, --analyze         (opcjonalne) oznaczenie wykonania etapu analizy tekstu; domyślnie aktywowany etap")
        println("\t--json                (opcjonalne) określenie wydruku rozwiązania jako plik JSON")
        println("\t--output-name <nazwa> (opcjonalne) określenie nazwy pliku wyjściowego; domyślnie result.json")
        println("\t--console             (opcjonalne) określenie wydruku rozwiązania na ekranie terminala")
        println("<tekst>                 tekst wejściowy")
        println("-f, --file <ścieżka>    ścieżka do plików tekstów wejściowych")
        println()
        println("o--------------------------------------o")
        println("|                                      |")
        println("| Etap tworzenia statystyk rozwiązania |")
        println("|                                      |")
        println("o--------------------------------------o")
        println()
        println("W trakcie tego etapu rozwiązanie wygenerowane podczas analizy porównywane jest z oryginalnym tekstem.")
        println("Na podstawie zgodności z oryginałem drukowane są statystyki.")
        println()
        println("\t-m|--measure-stats --result-file <ścieżka> --prepare-solution-file <ścieżka>")
        println()
        println("Argumenty:")
        println("\t-m, --measure-stats      oznaczenie wykonania etapu tworzania statystyk rozwiązania")
        println("\t--result-file <ścieżka>            (wymagane) ścieżka do pliku JSON wygenerowanego na etapie analizy")
        println("\t--prepare-solution-file <ścieżka>  (wymagane) ścieżka do pliku JSON wygenerowanego na etapie przygotowania")
    }
}