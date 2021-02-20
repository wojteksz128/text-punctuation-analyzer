package net.wojteksz128.tpa.polish.test.printer

import com.beust.klaxon.Klaxon
import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.*
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.utils.dag.TextPartSpecification
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class JsonResultPrinter : ResultPrinter {
    private val progressText = "Trwa analiza..."

    override fun printPreparingToAnalyse(text: String) {
        println("----------")
        println()
        println("Wczytany tekst: $text")
        println()
        println(progressText)
    }

    @ExperimentalTime
    override fun printResult(result: TextAnalyseResult, executionTime: Duration, loadedArgs: LoadedArgs) {
        1.rangeTo(progressText.length).forEach { _ -> print("\b \b") }
        val textSolution = prepareSolution(result)
        save(textSolution, loadedArgs.outputName ?: "result.json")
        printRealizationTime(executionTime)

    }

    private fun prepareSolution(result: TextAnalyseResult): TextSolution {
        val textPartsDto = result.textParts.map { it.toDto() }
        return TextSolution(generateTextId(result.text), textPartsDto, result.possibleChanges)
    }

    private fun save(textSolution: TextSolution, filePath: String) {
        val toJsonString = Klaxon().toJsonString(textSolution)
        File(filePath).writeText(toJsonString)
    }

    private fun generateTextId(text: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(text.toByteArray())).toString(16).padStart(32, '0')
    }

    @ExperimentalTime
    private fun printRealizationTime(executionTime: Duration) {
        println("Realization time: ${executionTime.inMilliseconds} ms")
    }

    private fun TextPart.toDto(): TextPartDto {
        val possibleCategoriesDto = this.possibleCategories.map { it.textPartSpecification.toDto() }
        return TextPartDto(this.text, this.startAt, this.endAt, possibleCategoriesDto)
    }

    private fun TextPartSpecification.toDto(): TextPartSpecificationDto {
        val grammarClassDto = GrammarClassDto(this.grammarClass.shortcut, this.grammarClass.name)
        val categories = this.wordCategories.map { GrammarCategoryDto(it.shortcut, it.displayName, it.property.name) }
        return TextPartSpecificationDto(this.tag, grammarClassDto, categories, this.probability)
    }

}