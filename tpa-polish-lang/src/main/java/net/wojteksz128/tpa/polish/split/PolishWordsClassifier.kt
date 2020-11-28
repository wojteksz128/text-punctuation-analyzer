package net.wojteksz128.tpa.polish.split

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.utils.concraft.ContractProbabilityCalculator
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszClassifier

class PolishWordsClassifier : MorfeuszClassifier() {
    private val concraftInstance = ContractProbabilityCalculator

    override fun classify(result: TextAnalyseResult) {
        super.classify(result)
        concraftInstance.calculate(result)
    }

    companion object {
        val instance: PolishWordsClassifier = PolishWordsClassifier()
    }
}