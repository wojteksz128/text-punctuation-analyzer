package net.wojteksz128.tpa

import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.split.TextDivider

open class TextPunctuationAnalyzer(private val textDivider: TextDivider) {

    val validatorPreparers = mutableListOf<TextValidatorPreparer>()
    val validators = mutableListOf<TextValidator>()

    fun analyze(text: String): TextAnalyseResult {
        val textParts = textDivider.divide(text)
        val result = TextAnalyseResult(text, textParts)

        validatorPreparers.forEach { it.prepare(result) }
        result.possibleChanges += validators.flatMap { it.validate(result) }

        return result
    }
}