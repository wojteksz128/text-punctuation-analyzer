package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import pl.sgjp.morfeusz.Morfeusz

object MorfeuszClassifier : Classifier {

    private val instance: Morfeusz = Morfeusz.createInstance()

    fun classify(word: String): List<TextPartInterpretation> {
        val interpretation = instance.analyseAsList(word)

        return interpretation.mapNotNull { MorphInterpretationConverter.convert(it, instance) }
    }

    override fun classify(result: TextAnalyseResult) {
        val interpretationList = instance.analyseAsList(result.text)
        val iterator = result.textParts.iterator()
        var textPart: TextPart? = null

        return interpretationList.groupBy { "${it.startNode}_${it.orth}" }.forEach { interpretation ->
            while (textPart == null || !interpretation.key.contains(textPart!!.get()))
                textPart = iterator.next()

            interpretation.value.mapNotNull { MorphInterpretationConverter.convert(it, instance) }.forEach {
                textPart?.possibleCategories?.add(it)
            }
        }
    }
}
