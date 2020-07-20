package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.text.TextPartCategory
import net.wojteksz128.tpa.text.split.Classifier
import pl.sgjp.morfeusz.Morfeusz

object MorfeuszClassifier : Classifier {

    private val instance: Morfeusz = Morfeusz.createInstance()

    override fun classify(word: String): List<TextPartCategory> {
        val interpretation = instance.analyseAsList(word)

        return interpretation.map { MorfeuszTagDecode.decode(it.getTag(instance)) }
    }

}
