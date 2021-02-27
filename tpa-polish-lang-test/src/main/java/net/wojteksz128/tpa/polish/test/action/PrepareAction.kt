package net.wojteksz128.tpa.polish.test.action

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.polish.test.AnalyzeUtils.generateTextId
import net.wojteksz128.tpa.polish.test.action.prepare.RemoveMarker
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.TextSolution
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import java.io.File
import kotlin.random.Random

class PrepareAction : Action {
    private val pattern = Regex("(\\. \\w|\\.|,|;)")

    override fun execute(loadedArgs: LoadedArgs) {
        val map = loadedArgs.texts.map { splitTextIntoTextWithErrorsAndErrorsSolutions(it) }.toMap()
        storeTextsIntoTxtFile(map, loadedArgs)
        storeSolutionsIntoJsonFile(map, loadedArgs)
    }

    private fun splitTextIntoTextWithErrorsAndErrorsSolutions(text: String): Pair<String, TextSolution> {
        var removedFromEarlier = 0
        val removeMarkers = pattern.findAll(text).sortedBy { it.range.first }.mapNotNull {
            val (removeMarker, removedChar) = when {
                it.value.startsWith(".") -> prepareDotErrorFor(it, removedFromEarlier)
                it.value.startsWith(",") -> prepareCommaErrorFor(it, removedFromEarlier)
                it.value.startsWith(";") -> prepareSemicolonErrorFor(it, removedFromEarlier)
                else -> Pair<RemoveMarker?, Int>(null, 0)
            }
            removedFromEarlier += removedChar
            removeMarker
        }.toList()
        val brokenText = applyReverseErrors(text, removeMarkers)
        return Pair(
            brokenText,
            TextSolution(generateTextId(brokenText), removeMarkers.map { it.changeAfterRemove }.toList())
        )
    }

    private fun prepareDotErrorFor(matchResult: MatchResult, removedFromEarlier: Int): Pair<RemoveMarker?, Int> {
        // TODO: 21.02.2021 Może być bardziej rozbudowane i testować więcej koniecznych zmian
        val position = matchResult.range.first
        val changeSentenceFirstChar = Random.nextBoolean()
        return if (changeSentenceFirstChar && matchResult.range.last - matchResult.range.first > 0) {
            val old = matchResult.value.removeRange(0..0).toLowerCase()
            val new = matchResult.value
            Pair(RemoveMarker(PossibleChange(ChangeType.REPLACE, position, old, new), removedFromEarlier), 1)
        } else {
            val new = matchResult.value.first().toString()
            Pair(RemoveMarker(PossibleChange(ChangeType.INSERT, position, new = new), removedFromEarlier), 1)
        }
    }

    private fun prepareCommaErrorFor(matchResult: MatchResult, removedFromEarlier: Int): Pair<RemoveMarker?, Int> {
        // TODO: 21.02.2021 Może być bardziej rozbudowane i testować więcej koniecznych zmian
        val position = matchResult.range.first
        val new = matchResult.value
        return Pair(RemoveMarker(PossibleChange(ChangeType.INSERT, position, new = new), removedFromEarlier), 1)
    }

    private fun prepareSemicolonErrorFor(matchResult: MatchResult, removedFromEarlier: Int): Pair<RemoveMarker?, Int> {
        // TODO: 21.02.2021 Może być bardziej rozbudowane i testować więcej koniecznych zmian
        val position = matchResult.range.first
        val new = matchResult.value
        return Pair(RemoveMarker(PossibleChange(ChangeType.INSERT, position, new = new), removedFromEarlier), 1)
    }

    private fun applyReverseErrors(text: String, removeMarkers: List<RemoveMarker>): String {
        val brokenText = StringBuilder(text)

        removeMarkers.sortedByDescending { it.position }.forEach {
            when (it.changeType) {
                ChangeType.INSERT -> brokenText.delete(it.position, it.position + it.new!!.length)
                ChangeType.REPLACE -> {
                    brokenText.delete(it.position, it.position + it.new!!.length).insert(it.position, it.old)
                }
                ChangeType.DELETE -> {
                    brokenText.insert(it.position, it.old)
                }
            }
        }

        return brokenText.toString()
    }

    private fun storeTextsIntoTxtFile(textForTestWithSolution: Map<String, TextSolution>, loadedArgs: LoadedArgs) {
        val joinedTexts = textForTestWithSolution.keys.joinToString("\n")
        val filePath = "${loadedArgs.outputName ?: "output"}.txt"
        File(filePath).writeText(joinedTexts)
        println("Teksty zostały zapisane w pliku $filePath.")
    }

    private fun storeSolutionsIntoJsonFile(textForTestWithSolution: Map<String, TextSolution>, loadedArgs: LoadedArgs) {
        val jsonArrayString = Klaxon().toJsonString(textForTestWithSolution.values)
        val filePath = "${loadedArgs.outputName ?: "output"}.solution.json"
        File(filePath).writeText(jsonArrayString)
        println("Rozwiązania zostały zapisane w pliku $filePath.")
    }
}

