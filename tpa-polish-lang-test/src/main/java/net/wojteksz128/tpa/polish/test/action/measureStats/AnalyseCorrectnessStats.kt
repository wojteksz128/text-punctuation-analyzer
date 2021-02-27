package net.wojteksz128.tpa.polish.test.action.measureStats

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
}