package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.text.TextValidatorPreparer

// TODO: 31.08.2020 Prepare some tests
object SentenceGroupValidatorPreparer : TextValidatorPreparer {
    override fun prepare(analyseData: TextAnalyseData) {
        val textParts = analyseData.textParts
        val sentences = textParts.filter { it.get() == "." }
            .map { textPart -> textParts.takeWhile { it != textPart }.plus(textPart).toMutableList() }.toMutableList()
        sentences.add(textParts.toMutableList())
        sentences.reversed().zipWithNext { first, second -> first.removeAll(second) }
        sentences.removeIf { it.size == 0 }
        analyseData.additionalParts[SENTENCE_GROUP.name] = sentences
    }
}