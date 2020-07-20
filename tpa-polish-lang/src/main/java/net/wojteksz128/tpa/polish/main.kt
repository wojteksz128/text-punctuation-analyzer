package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszTagDecode
import pl.sgjp.morfeusz.Morfeusz

/*
* Examples:
*   "Ala ma kota."
*   "Chciałem Ci powiedzieć, że lubię często kłamać..."
*   "Proszę, kochaj mnie..."
*   "Zażółć gęślą jaźń"
*/

fun main(args: Array<String>) {
    val analyzer: TextPunctuationAnalyzer = PolishTextPunctuationAnalyzerImpl()
    val instance: Morfeusz = Morfeusz.createInstance()

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
        result.textParts.forEach {
            println(" -\t${it.javaClass.simpleName} '${it.get()}' na pozycji ${it.startAt}-${it.endAt}")
            val analyzed = instance.analyseAsList(it.get())
            analyzed.forEach { morthInterpretation ->
                println("\t -\t${morthInterpretation.orth}, ${morthInterpretation.lemma}, ${morthInterpretation.getTag(instance)}")
                val decoded = MorfeuszTagDecode.decode(morthInterpretation.getTag(instance))
                println("\t\t$decoded")
            }
            println()
        }
    }
}