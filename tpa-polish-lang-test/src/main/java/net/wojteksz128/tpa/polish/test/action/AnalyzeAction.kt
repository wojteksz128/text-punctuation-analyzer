package net.wojteksz128.tpa.polish.test.action

import net.wojteksz128.tpa.TextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.polishTextPunctuationAnalyzer
import net.wojteksz128.tpa.polish.test.AnalyzeUtils.generateTextId
import net.wojteksz128.tpa.polish.test.args.LoadedArgs
import net.wojteksz128.tpa.polish.test.model.*
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.utils.dag.TextPartSpecification
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class AnalyzeAction : Action {
    private val analyzer: TextPunctuationAnalyzer =
        TextPunctuationAnalyzer.Builder(TextPunctuationAnalyzer.polishTextPunctuationAnalyzer()).build()

    @ExperimentalTime
    override fun execute(loadedArgs: LoadedArgs) {
        val analyzeExecutionResult = AnalyseExecutionResult()

        loadedArgs.texts.forEach { text ->
            loadedArgs.resultPrinter.printPreparingToAnalyse(text)
            val (result, executionTime) = measureTimedValue {
                analyzer.analyze(text)
            }
            val textAnalyzeResult = TextAnalyzeResultDto(
                generateTextId(text),
                result.possibleChanges,
                result.textParts.map { it.toDto() },
                executionTime.toLongMilliseconds()
            )
            analyzeExecutionResult.results += textAnalyzeResult

            loadedArgs.resultPrinter.printOneTextAnalyseResult(textAnalyzeResult, loadedArgs)

        }
        loadedArgs.resultPrinter.printAfterAllAnalysis(analyzeExecutionResult, loadedArgs)
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