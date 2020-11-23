package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import pl.sgjp.morfeusz.Morfeusz

open class MorfeuszClassifier : Classifier {

    private val morfeuszInstance: Morfeusz = MorfeuszUtils.morfeuszInstance

    fun classify(word: String): List<TextPartInterpretation> {
        val interpretation = morfeuszInstance.analyseAsList(word)

        return interpretation.mapNotNull { MorphInterpretationConverter.convert(it, morfeuszInstance) }
    }

    override fun classify(result: TextAnalyseResult) {
        val interpretationList = morfeuszInstance.analyseAsList(result.text)
        val iterator = result.textParts.iterator()
        var textPart: TextPart? = null

        return interpretationList.groupBy { "${it.startNode}_${it.orth}" }.forEach { interpretation ->
            while (textPart == null || !interpretation.key.contains(textPart!!.get()))
                textPart = iterator.next()

            interpretation.value.mapNotNull { MorphInterpretationConverter.convert(it, morfeuszInstance) }.forEach {
                textPart?.possibleCategories?.add(it)
            }
        }
    }

    companion object {
        val instance: MorfeuszClassifier = MorfeuszClassifier()
    }
}
