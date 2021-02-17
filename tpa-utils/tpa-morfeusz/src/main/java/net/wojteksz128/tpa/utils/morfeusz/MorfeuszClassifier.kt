package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import pl.sgjp.morfeusz.Morfeusz

open class MorfeuszClassifier : Classifier {

    private val morfeuszInstance: Morfeusz = MorfeuszUtils.morfeuszInstance

    fun classify(word: String): List<TextPartInterpretation> {
        val interpretation = morfeuszInstance.analyseAsList(word)

        return interpretation.mapNotNull { MorphInterpretationConverter.convert(it, morfeuszInstance) }
    }

    override fun classify(analyseData: TextAnalyseData) {
        val interpretationList = morfeuszInstance.analyseAsList(analyseData.text)
        val iterator = analyseData.textParts.iterator()
        var textPart: TextPart? = null

        return interpretationList.groupBy { Triple<Int, Int, String>(it.startNode, it.endNode, it.orth) }
            .forEach { (key, value) ->
                while (textPart == null || !(textPart!!.text == key.third || textPart!!.text.startsWith(key.third) || textPart!!.text.endsWith(
                        key.third
                    ))
                )
                    textPart = iterator.next()

                value.mapNotNull { MorphInterpretationConverter.convert(it, morfeuszInstance) }.forEach {
                    textPart?.possibleCategories?.add(it)
                }
//            textPart = if (iterator.hasNext()) iterator.next() else null
            }
    }

    companion object {
        val instance: MorfeuszClassifier = MorfeuszClassifier()
    }
}
