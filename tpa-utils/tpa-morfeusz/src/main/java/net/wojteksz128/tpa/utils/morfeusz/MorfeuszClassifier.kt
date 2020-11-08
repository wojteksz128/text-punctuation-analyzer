package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.TextPartCategory
import net.wojteksz128.tpa.text.split.Classifier
import pl.sgjp.morfeusz.Morfeusz

object MorfeuszClassifier : Classifier {

    val instance: Morfeusz = Morfeusz.createInstance()

    fun classify(word: String): List<TextPartCategory> {
        val interpretation = instance.analyseAsList(word)

        return interpretation.map { MorfeuszTagDecode.decode(it.getTag(instance)) }
    }

    override fun classify(result: TextAnalyseResult) {
        val interpretationList = instance.analyseAsList(result.text)
        val iterator = result.textParts.iterator()
        var textPart: TextPart? = null

        return interpretationList.groupBy { "${it.startNode}_${it.orth}" }.forEach { interpretation ->
            while (textPart == null || !interpretation.key.contains(textPart!!.get()))
                textPart = iterator.next()

            interpretation.value.forEach {
                textPart?.possibleCategories?.add(MorfeuszTagDecode.decode(it.getTag(instance)))
            }
        }
    }
}
