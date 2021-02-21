package net.wojteksz128.tpa.polish.test.action

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.TextSolution
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.random.Random

class PrepareAction : Action {
    private val pattern = Regex("(\\. \\w|\\.|,|;)")

    override fun execute(loadedArgs: LoadedArgs) {
        val map = loadedArgs.texts.map { splitTextIntoTextWithErrorsAndErrorsSolutions(it) }.toMap()
        storeTextsIntoTxtFile(map, loadedArgs)
        storeSolutionsIntoJsonFile(map, loadedArgs)
    }

    private fun splitTextIntoTextWithErrorsAndErrorsSolutions(text: String): Pair<String, TextSolution> {
        val syntheticErrorsSolution = pattern.findAll(text).mapNotNull {
            when {
                it.value.startsWith(".") -> prepareDotErrorFor(it)
                it.value.startsWith(",") -> prepareCommaErrorFor(it)
                it.value.startsWith(";") -> prepareSemicolonErrorFor(it)
                else -> null
            }
        }
        val brokenText = applyReverseErrors(text, syntheticErrorsSolution)
        return Pair(
            brokenText,
            TextSolution(generateTextId(brokenText), listOf(), syntheticErrorsSolution.toList())
        )
    }

    private fun prepareDotErrorFor(matchResult: MatchResult): PossibleChange {
        // TODO: 21.02.2021 Może być bardziej rozbudowane i testować więcej koniecznych zmian
        val position = matchResult.range.first
        val changeSentenceFirstChar = Random.nextBoolean()
        return if (changeSentenceFirstChar && matchResult.range.last - matchResult.range.first > 0) {
            val old = matchResult.value.removeRange(0..0).toLowerCase()
            val new = matchResult.value
            PossibleChange(ChangeType.REPLACE, position, old, new)
        } else {
            val new = matchResult.value.first().toString()
            PossibleChange(ChangeType.INSERT, position, new = new)
        }
    }

    private fun prepareCommaErrorFor(matchResult: MatchResult): PossibleChange {
        // TODO: 21.02.2021 Może być bardziej rozbudowane i testować więcej koniecznych zmian
        val position = matchResult.range.first
        val new = matchResult.value
        return PossibleChange(ChangeType.INSERT, position, new = new)
    }

    private fun prepareSemicolonErrorFor(matchResult: MatchResult): PossibleChange {
        // TODO: 21.02.2021 Może być bardziej rozbudowane i testować więcej koniecznych zmian
        val position = matchResult.range.first
        val new = matchResult.value
        return PossibleChange(ChangeType.INSERT, position, new = new)
    }

    private fun applyReverseErrors(text: String, syntheticErrorsSolution: Sequence<PossibleChange>): String {
        val brokenText = StringBuilder(text)

        syntheticErrorsSolution.sortedByDescending { it.position }.forEach {
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

    private fun generateTextId(text: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(text.toByteArray())).toString(16).padStart(32, '0')
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
