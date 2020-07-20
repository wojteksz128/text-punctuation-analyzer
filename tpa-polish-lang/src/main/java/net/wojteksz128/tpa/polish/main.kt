package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextPunctuationAnalyzer

/*
* Examples:
*   "Ala ma kota."
*   "Chciałem Ci powiedzieć, że lubię często kłamać..."
*   "Proszę, kochaj mnie..."
*   "Zażółć gęślą jaźń"
*/

fun main(args: Array<String>) {
    val analyzer: TextPunctuationAnalyzer = PolishTextPunctuationAnalyzerImpl()

    args.forEach { text ->
        println("----------")
        println()
        println("Wczytany tekst: $text")
        println()
        val recognizingText = "Trwa rozpoznawanie..."
        print(recognizingText)
        val result = analyzer.analyze(text)
        1.rangeTo(recognizingText.length).forEach { _ -> print("\b \b") }
        println("\rRozpoznano:")
        result.textParts.forEach { textPart ->
            println(" -\t${textPart.javaClass.simpleName} '${textPart.get()}' na pozycji ${textPart.startAt}-${textPart.endAt} " +
                    if (textPart.possibleCategories.isNotEmpty()) "sklasyfikowany jako:" else "bez klasyfikacji")
            textPart.possibleCategories.forEach { println("\t\t$it") }
            println()
        }
    }
}