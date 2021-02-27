package net.wojteksz128.tpa.polish.test.action.measureStats

import net.wojteksz128.tpa.text.PossibleChange

data class AnalyseCorrectnessStats(
    val correctChangeSize: Int,
    val requiredChangesSize: Int,
    val wrongChangeSize: Int,
    val wrongSignInCorrectPlaceSize: Int
) {
    val correctnessPercent: Double
        get() = correctChangeSize.toDouble() / requiredChangesSize

    operator fun plus(other: AnalyseCorrectnessStats): AnalyseCorrectnessStats {
        val correctChangeSize = this.correctChangeSize + other.correctChangeSize
        val requiredChangesSize = this.requiredChangesSize + other.requiredChangesSize
        val wrongChangeSize = this.wrongChangeSize + other.wrongChangeSize
        val wrongSignInCorrectPlaceSize = this.wrongSignInCorrectPlaceSize + other.wrongSignInCorrectPlaceSize

        return AnalyseCorrectnessStats(
            correctChangeSize,
            requiredChangesSize,
            wrongChangeSize,
            wrongSignInCorrectPlaceSize
        )
    }

    class Builder {
        val expectedChangesMap = mutableMapOf<Symbol, MutableSet<PossibleChange>>()
        val actualChangesMap = mutableMapOf<Symbol, MutableMap<Symbol, MutableSet<PossibleChange>>>()

        @ExperimentalStdlibApi
        fun build(): AnalyseCorrectnessStats {
            // Stosunek ilości znalezionych rozwiązań w stosunku do ilości wprowadzonych zmian w tekście oryginalnym (np. 1 z 2 (50%)),
            val correctChangeSize = actualChangesMap.mapNotNull { it.value[it.key]?.size }.sum()
            val requiredChangesSize = expectedChangesMap.mapNotNull { (_, list) -> list.size }.sum()

            // Ilość błędnych miejsc,
            val wrongChangeSize = actualChangesMap[Symbol.NONE]?.map { (_, list) -> list.size }?.sum() ?: 0

            // Ilość poprawnych miejsc, ale niepoprawnych znaków.
            val wrongSignInCorrectPlaceSize = actualChangesMap.filterNot { it.key == Symbol.NONE }
                .mapNotNull { (symbol, map) ->
                    map.filterNot { it.key == symbol }.map { entry -> entry.value.filterNot { it.position == -1 }.size }
                        .sum()
                }.reduceOrNull { acc, i -> acc + i } ?: 0

            return AnalyseCorrectnessStats(
                correctChangeSize,
                requiredChangesSize,
                wrongChangeSize,
                wrongSignInCorrectPlaceSize
            )
        }
    }
}