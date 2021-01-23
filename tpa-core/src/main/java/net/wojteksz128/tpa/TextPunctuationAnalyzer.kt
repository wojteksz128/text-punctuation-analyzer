package net.wojteksz128.tpa

import net.wojteksz128.tpa.language.LanguageAlphabet
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.text.split.TextDivider

class TextPunctuationAnalyzer private constructor(
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

    class Builder(punctuationAnalyzer: TextPunctuationAnalyzer? = null) {
        private lateinit var textDivider: TextDivider
        private lateinit var classifier: Classifier
        private var validatorPreparers = mutableListOf<TextValidatorPreparer>()
        private var validators = mutableListOf<TextValidator>()

        init {
            punctuationAnalyzer?.let {
                this.textDivider = it.textDivider
                this.classifier = it.classifier
                this.validatorPreparers = it.validatorPreparers.toMutableList()
                this.validators = it.validators.toMutableList()
            }
        }

        fun textDivider(textDivider: TextDivider) = apply { this.textDivider = textDivider }
        fun classifier(classifier: Classifier) = apply { this.classifier = classifier }
        fun validatorPreparers(validatorPreparers: List<TextValidatorPreparer>) = apply { this.validatorPreparers = validatorPreparers.toMutableList() }
        fun validatorPreparer(validatorPreparer: TextValidatorPreparer) = apply { this.validatorPreparers.add(validatorPreparer) }
        fun validators(validators: List<TextValidator>) = apply { this.validators = validators.toMutableList() }
        fun validator(validator: TextValidator) = apply { this.validators.add(validator) }

        fun build() = TextPunctuationAnalyzer(textDivider, classifier, validatorPreparers.toList(), validators.toList())
    }

    companion object
}
