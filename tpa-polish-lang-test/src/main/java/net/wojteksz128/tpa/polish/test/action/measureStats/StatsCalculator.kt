package net.wojteksz128.tpa.polish.test.action.measureStats

import net.wojteksz128.tpa.polish.test.model.AnalyseExecutionResult
import net.wojteksz128.tpa.polish.test.model.TextAnalyzeResultDto
import net.wojteksz128.tpa.polish.test.model.TextSolution
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange

class StatsCalculator {
    @ExperimentalStdlibApi
    fun calculate(
        prepareStepSolution: List<TextSolution>,
        analyzeResult: AnalyseExecutionResult
    ): AnalyseCorrectnessStats {
        val expectedWithActualTextSolutions = connectExpectedWithActualTextSolutions(prepareStepSolution, analyzeResult)
        val analyseStatsForTexts = expectedWithActualTextSolutions.values.map(this::calculateStatsForText)

        return if (analyseStatsForTexts.isNotEmpty()) analyseStatsForTexts.reduce { a, b -> a + b }
        else AnalyseCorrectnessStats(0, 0, 0, 0, mapOf(), mapOf())
    }

    private fun connectExpectedWithActualTextSolutions(
        prepareStepSolution: List<TextSolution>,
        analyzeResult: AnalyseExecutionResult
    ): Map<String, ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>> {
        val textAnalyseConnectedWithOriginal =
            prepareStepSolution.map { it.textId to ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>(it) }
                .toMap()
        analyzeResult.results.forEach {
            if (textAnalyseConnectedWithOriginal.containsKey(it.textId))
                textAnalyseConnectedWithOriginal[it.textId]?.actual = it
            else throw ExpectedTextSolutionNotExistsException()
        }
        return textAnalyseConnectedWithOriginal
    }

    @ExperimentalStdlibApi
    private fun calculateStatsForText(expectedWithActual: ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>): AnalyseCorrectnessStats {
        val expectedWithActualSolutions = connectExpectedSolutionWithActualSolutions(expectedWithActual)
        return calculateSolutionsFromMap(expectedWithActualSolutions, expectedWithActual)
    }

    private fun connectExpectedSolutionWithActualSolutions(expectedWithActual: ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>): MutableMap<Int, ConnectedExpectedWithActual<PossibleChange?, MutableSet<PossibleChange>>> {
        val map = expectedWithActual.expected.solution.map {
            it.position to ConnectedExpectedWithActual<PossibleChange?, MutableSet<PossibleChange>>(
                it,
                mutableSetOf()
            )
        }.toMap().toMutableMap()
        (expectedWithActual.actual ?: throw ActualTextSolutionNotExistsException()).solution.forEach {
            map.putIfAbsent(it.position, ConnectedExpectedWithActual(null, mutableSetOf()))
            map[it.position]?.actual?.add(it)
        }
        return map
    }

    @ExperimentalStdlibApi
    private fun calculateSolutionsFromMap(
        expectedWithActualSolutions: MutableMap<Int, ConnectedExpectedWithActual<PossibleChange?, MutableSet<PossibleChange>>>,
        expectedWithActualText: ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>
    ): AnalyseCorrectnessStats {
        val statsBuilder = AnalyseCorrectnessStats.Builder()
        fillExpectedChangesMap(statsBuilder, expectedWithActualText)
        fillActualChangesMap(statsBuilder, expectedWithActualSolutions, expectedWithActualText)

        return statsBuilder.build()
    }

    private fun fillActualChangesMap(
        statsBuilder: AnalyseCorrectnessStats.Builder,
        expectedWithActualSolutions: MutableMap<Int, ConnectedExpectedWithActual<PossibleChange?, MutableSet<PossibleChange>>>,
        expectedWithActualText: ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>
    ) {
        val spaces = expectedWithActualText.expected.spaces.toMutableSet()
        expectedWithActualSolutions.forEach { (_, expectedWithActual) ->
            val expectedSymbol = getChangeSymbol(expectedWithActual.expected)
            val actual = if (expectedWithActual.actual.isNullOrEmpty())
                listOf(PossibleChange(ChangeType.DELETE, -1, " "))
            else expectedWithActual.actual!!
            actual.forEach {
                val actualSymbol = getChangeSymbol(it)
                statsBuilder.actualChangesMap.putIfAbsent(expectedSymbol, mutableMapOf())
                statsBuilder.actualChangesMap[expectedSymbol]?.putIfAbsent(actualSymbol, mutableSetOf())
                statsBuilder.actualChangesMap[expectedSymbol]?.get(actualSymbol)?.add(it)
                spaces.remove(it.position)
            }
        }
        spaces.forEach {
            statsBuilder.actualChangesMap.putIfAbsent(Symbol.NONE, mutableMapOf())
            statsBuilder.actualChangesMap[Symbol.NONE]?.putIfAbsent(Symbol.NONE, mutableSetOf())
            statsBuilder.actualChangesMap[Symbol.NONE]?.get(Symbol.NONE)
                ?.add(PossibleChange(ChangeType.DELETE, it, " "))
        }
    }

    private fun fillExpectedChangesMap(
        statsBuilder: AnalyseCorrectnessStats.Builder,
        expectedWithActualText: ConnectedExpectedWithActual<TextSolution, TextAnalyzeResultDto>
    ) {
        expectedWithActualText.expected.solution.forEach {
            statsBuilder.expectedChangesMap.putIfAbsent(getChangeSymbol(it), mutableSetOf())
            statsBuilder.expectedChangesMap[getChangeSymbol(it)]?.add(it)
        }
    }

    private fun getChangeSymbol(change: PossibleChange?): Symbol {
        return if (change == null) {
            Symbol.NONE
        } else {
            val firstSign = when (change.changeType) {
                ChangeType.INSERT -> change.new!!.first()
                ChangeType.REPLACE -> change.new!!.first()
                ChangeType.DELETE -> change.old!!.first()
            }
            when (firstSign) {
                '.' -> Symbol.DOT
                ',' -> Symbol.COMMA
                ';' -> Symbol.SEMICOLON
                else -> Symbol.NONE
            }
        }
    }
}
