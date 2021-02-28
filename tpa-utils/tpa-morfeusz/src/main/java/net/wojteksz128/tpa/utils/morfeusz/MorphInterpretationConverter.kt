package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import pl.sgjp.morfeusz.Morfeusz
import pl.sgjp.morfeusz.MorphInterpretation

object MorphInterpretationConverter {

    fun convert(morphInterpretation: MorphInterpretation, instance: Morfeusz): TextPartInterpretation? {
        return try {
            val nodeInfo = NodeInfo(morphInterpretation)
            val textPartSpecification = TextPartSpecification(morphInterpretation, instance)
            TextPartInterpretation(nodeInfo, textPartSpecification)
        } catch (e: Exception) {
            null
        }
    }
}