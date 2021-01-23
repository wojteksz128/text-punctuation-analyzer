package net.wojteksz128.tpa.polish

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation

/*
* Examples:
*   "Ala ma kota."
*   "Chciałem Ci powiedzieć, że lubię często kłamać..."
*   "Proszę, kochaj mnie..."
*   "Zażółć gęślą jaźń"
*/

fun main(args: Array<String>) {
    val analyzer: TextPunctuationAnalyzer = TextPunctuationAnalyzer.Builder(TextPunctuationAnalyzer.polishTextPunctuationAnalyzer()).build()

    args.forEach { text ->
        val recognizingText = printPreparingToClassifyText(text)
        val result = analyzer.analyze(text)
        printRecognizedParts(recognizingText, result)
        printPossibleChanges(result)
    }
}

private fun printPreparingToClassifyText(text: String): String {
    println("----------")
    println()
    println("Wczytany tekst: $text")
    println()
    val recognizingText = "Trwa rozpoznawanie..."
    print(recognizingText)
    return recognizingText
}

private fun printRecognizedParts(recognizingText: String, result: TextAnalyseResult) {
    1.rangeTo(recognizingText.length).forEach { _ -> print("\b \b") }
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

fun printPossibleChanges(result: TextAnalyseResult) {
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
