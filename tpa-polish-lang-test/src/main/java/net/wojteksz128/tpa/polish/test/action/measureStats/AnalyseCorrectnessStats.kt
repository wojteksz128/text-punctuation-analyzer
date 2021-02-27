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

    class Builder {
        val expectedChangesMap = mutableMapOf<Symbol, MutableSet<PossibleChange>>()
        val actualChangesMap = mutableMapOf<Symbol, MutableMap<Symbol, MutableSet<PossibleChange>>>()

        @ExperimentalStdlibApi
        fun build(): AnalyseCorrectnessStats {
            val correctChangeSize = actualChangesMap.mapNotNull { it.value[it.key]?.size }.sum()
            val requiredChangesSize = expectedChangesMap.mapNotNull { (_, list) -> list.size }.sum()

            val wrongChangeSize = actualChangesMap[Symbol.NONE]?.map { (_, list) -> list.size }?.sum() ?: 0

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