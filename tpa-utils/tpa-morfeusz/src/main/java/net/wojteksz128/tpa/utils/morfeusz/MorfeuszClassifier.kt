package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.text.split.Classifier
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import pl.sgjp.morfeusz.Morfeusz
import pl.sgjp.morfeusz.MorphInterpretation

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

        val interpretationNodeGroup = this.prepareWordInterpretationNodeGroup(interpretationList)

        interpretationNodeGroup.map { groupRange -> groupRange to interpretationList.filter { groupRange.contains(it.startNode) } }
            .map { group -> Pair(group.first, group.second.maxBy { it.orth.length }) to group.second }
            .forEach { (key, value) ->
                while (textPart == null || textPart!!.text != key.second!!.orth)
                    textPart = iterator.next()

                value.mapNotNull { MorphInterpretationConverter.convert(it, morfeuszInstance) }.forEach {
                    textPart?.possibleCategories?.add(it)
                }
            }
    }

    private fun prepareWordInterpretationNodeGroup(interpretationList: MutableList<MorphInterpretation>): List<IntRange> {
        val list = interpretationList.map { it.startNode until it.endNode }.distinct()
        return list.filter { elem -> list.none { it != elem && elem.first >= it.first && elem.last <= it.last } }
    }

    companion object {
        val instance: MorfeuszClassifier = MorfeuszClassifier()
    }
}
