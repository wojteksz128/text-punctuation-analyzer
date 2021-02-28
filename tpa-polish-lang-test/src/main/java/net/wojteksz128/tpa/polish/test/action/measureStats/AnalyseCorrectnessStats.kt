package net.wojteksz128.tpa.polish.test.action.measureStats

import net.wojteksz128.tpa.text.PossibleChange

data class AnalyseCorrectnessStats(
    val correctChangeSize: Int,
    val requiredChangesSize: Int,
    val wrongChangeSize: Int,
    val wrongSignInCorrectPlaceSize: Int,
    val requiredChangesNoMap: Map<Symbol, Int>,
    val actualChangesNoInExpectedCharsMap: Map<Symbol, Map<Symbol, Int>>
) {
    val correctnessPercent: Double
        get() = correctChangeSize.toDouble() / requiredChangesSize

    private val calculatedPrecisionValues = mutableMapOf<Symbol, Double>()
    private val calculatedRecallValues = mutableMapOf<Symbol, Double>()

    fun calculatePrecision(symbol: Symbol): Double {
        if (!calculatedPrecisionValues.containsKey(symbol)) {
            val truePositiveNo = actualChangesNoInExpectedCharsMap[symbol]?.get(symbol)?.toDouble() ?: 0.0
            val sumOfSymbolAssignments =
                Symbol.values().map { actualChangesNoInExpectedCharsMap[it]?.get(symbol)?.toDouble() ?: 0.0 }.sum()

            calculatedPrecisionValues[symbol] =
                if (sumOfSymbolAssignments == 0.0) 0.0 else truePositiveNo / sumOfSymbolAssignments
        }
        return calculatedPrecisionValues[symbol]!!
    }

    fun calculateRecall(symbol: Symbol): Double {
        if (!calculatedRecallValues.containsKey(symbol)) {
            val truePositiveNo = actualChangesNoInExpectedCharsMap[symbol]?.get(symbol)?.toDouble() ?: 0.0
            val sumOfExpectedSymbolAssignments =
                actualChangesNoInExpectedCharsMap[symbol]?.map { it.value }?.sum()?.toDouble() ?: 0.0

            calculatedRecallValues[symbol] =
                if (sumOfExpectedSymbolAssignments == 0.0) 0.0 else truePositiveNo / sumOfExpectedSymbolAssignments
        }
        return calculatedRecallValues[symbol]!!
    }

    operator fun plus(other: AnalyseCorrectnessStats): AnalyseCorrectnessStats {
        val correctChangeSize = this.correctChangeSize + other.correctChangeSize
        val requiredChangesSize = this.requiredChangesSize + other.requiredChangesSize
        val wrongChangeSize = this.wrongChangeSize + other.wrongChangeSize
        val wrongSignInCorrectPlaceSize = this.wrongSignInCorrectPlaceSize + other.wrongSignInCorrectPlaceSize
        val requiredChangesNoMap = sumElementsOf(this.requiredChangesNoMap, other.requiredChangesNoMap)
        val actualChangesNoInExpectedCharsMap = Symbol.values().map {
            it to sumElementsOf(
                (this.actualChangesNoInExpectedCharsMap[it] ?: mapOf()),
                (other.actualChangesNoInExpectedCharsMap[it] ?: mapOf())
            )
        }.toMap()

        return AnalyseCorrectnessStats(
            correctChangeSize,
            requiredChangesSize,
            wrongChangeSize,
            wrongSignInCorrectPlaceSize,
            requiredChangesNoMap,
            actualChangesNoInExpectedCharsMap
        )
    }

    private fun sumElementsOf(firstMap: Map<Symbol, Int>, secondMap: Map<Symbol, Int>) =
        Symbol.values().map { it to (firstMap[it] ?: 0) + (secondMap[it] ?: 0) }.toMap()

    fun calculateF1Score(symbol: Symbol): Double {
        val precision = calculatePrecision(symbol)
        val recall = calculateRecall(symbol)
        val f1Score = 2 * precision * recall / (precision + recall)
        return if (f1Score.isNaN()) 0.0 else f1Score
    }

    class Builder {
        val expectedChangesMap = mutableMapOf<Symbol, MutableSet<PossibleChange>>()
        val actualChangesMap = mutableMapOf<Symbol, MutableMap<Symbol, MutableSet<PossibleChange>>>()

        @ExperimentalStdlibApi
        fun build(): AnalyseCorrectnessStats {
            val correctChangeSize =
                actualChangesMap.filter { it.key != Symbol.NONE }.mapNotNull { it.value[it.key]?.size }.sum()
            val requiredChangesSize = expectedChangesMap.mapNotNull { (_, list) -> list.size }.sum()

            val wrongChangeSize =
                actualChangesMap[Symbol.NONE]?.filterNot { it.key == Symbol.NONE }?.map { (_, list) -> list.size }
                    ?.sum() ?: 0

            val wrongSignInCorrectPlaceSize = actualChangesMap.filterNot { it.key == Symbol.NONE }
                .mapNotNull { (symbol, map) ->
                    map.filterNot { it.key == symbol }.map { entry -> entry.value.filterNot { it.position == -1 }.size }
                        .sum()
                }.sum()

            val requiredChangesNoMap = Symbol.values().map { it to (expectedChangesMap[it]?.size ?: 0) }.toMap()
            val actualChangesNoInExpectedCharsMap = Symbol.values().map { requiredSymbol ->
                requiredSymbol to Symbol.values().map { expectedSymbol ->
                    expectedSymbol to (actualChangesMap[requiredSymbol]?.get(expectedSymbol)?.size ?: 0)
                }.toMap()
            }.toMap()

            return AnalyseCorrectnessStats(
                correctChangeSize,
                requiredChangesSize,
                wrongChangeSize,
                wrongSignInCorrectPlaceSize,
                requiredChangesNoMap,
                actualChangesNoInExpectedCharsMap
            )
        }
    }
}