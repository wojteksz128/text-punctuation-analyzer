package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.text.TextValidatorPreparer

// TODO: 31.08.2020 Prepare some tests
object SentenceGroupValidatorPreparer : TextValidatorPreparer {
    override fun prepare(result: TextAnalyseResult) {
        val textParts = result.textParts
        val sentences = textParts.filter { it.get() == "." }
                .map { textPart -> textParts.takeWhile { it != textPart }.plus(textPart).toMutableList() }.toMutableList()
        sentences.add(textParts.toMutableList())
        sentences.reversed().zipWithNext { first, second -> first.removeAll(second) }
        sentences.removeIf { it.size == 0 }
        result.additionalParts[SENTENCE_GROUP.name] = sentences
    }
}