package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.text.split.TextDivider

open class TextPunctuationAnalyzer(
    private val textDivider: TextDivider,
    private val classifier: Classifier,
    val validatorPreparers: List<TextValidatorPreparer>,
    val validators: List<TextValidator>
) {

    fun analyze(text: String): TextAnalyseResult {
        val analyseData = prepareAnalyseData(text, textDivider.languageAlphabet)
        validateProvidedData(analyseData)
        return assembleResult(analyseData)
    }

    private fun prepareAnalyseData(text: String, languageAlphabet: LanguageAlphabet): TextAnalyseData {
        val textParts = textDivider.divide(text)
        val analyseData = TextAnalyseData(text, textParts, languageAlphabet)
        classifier.classify(analyseData)
        validatorPreparers.forEach { it.prepare(analyseData) }
        return analyseData
    }

    private fun validateProvidedData(analyseData: TextAnalyseData) {
        validators.forEach { analyseData.possibleChanges[it] = it.validate(analyseData) }
    }

    private fun assembleResult(analyseData: TextAnalyseData): TextAnalyseResult {
        val toList = analyseData.possibleChanges.toPossibleChangesList()
        return TextAnalyseResult(analyseData.text, analyseData.textParts, toList)
    }

    private fun Map<TextValidator, List<PossibleChange>>.toPossibleChangesList() =
        this.flatMap { it.value }.sortedBy { it.position }.toList()
}
