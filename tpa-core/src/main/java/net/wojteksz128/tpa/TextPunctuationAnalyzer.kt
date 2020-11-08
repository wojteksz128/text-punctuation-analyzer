package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.text.split.TextDivider

open class TextPunctuationAnalyzer(private val textDivider: TextDivider, val classifier: Classifier) {

    val validatorPreparers = mutableListOf<TextValidatorPreparer>()
    val validators = mutableListOf<TextValidator>()

    fun analyze(text: String): TextAnalyseResult {
        val result = TextAnalyseResult(text, textDivider.divide(text))
        classifier.classify(result)

        validatorPreparers.forEach { it.prepare(result) }
        result.possibleChanges += validators.flatMap { it.validate(result) }

        return result
    }
}