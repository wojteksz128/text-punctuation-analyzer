package net.wojteksz128.tpa.polish.split

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.utils.concraft.ContractProbabilityCalculator
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier

class PolishWordsClassifier : MorfeuszClassifier() {
    private val concraftInstance = ContractProbabilityCalculator

    override fun classify(analyseData: TextAnalyseData) {
        super.classify(analyseData)
        concraftInstance.calculate(analyseData)
    }

    companion object {
        val instance: PolishWordsClassifier = PolishWordsClassifier()
    }
}