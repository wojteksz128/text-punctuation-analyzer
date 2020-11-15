package net.wojteksz128.tpa.utils.concraft.api

import net.wojteksz128.tpa.utils.dag.NodeInfo
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import net.wojteksz128.tpa.utils.dag.TextPartSpecification
import net.wojteksz128.tpa.utils.dag.grammar.GrammarClass
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

object ParseServiceParamConverter {

    fun prepareDagParam(preparedToInterpretation: List<TextPartInterpretation>): DagParam {
        val dag = preparedToInterpretation.joinToString("\n", postfix = "\n\n") {
            "${it.nodeInfo.startNode}\t" +
                    "${it.nodeInfo.endNode}\t" +
                    "${it.textPartSpecification.orth}\t" +
                    "${it.textPartSpecification.lemma}\t" +
                    "${it.textPartSpecification.tag}\t" +
                    "${it.textPartSpecification.name}\t" +
                    "\t" +
                    "${it.textPartSpecification.probability}\t" +
                    "\t" +
                    "\t" +
                    "\t"
        }
        return DagParam(dag)
    }

    fun convertResponseToList(paramOptional: DagParam?): List<TextPartInterpretation> {
        return paramOptional?.let { param ->
            param.dag.split('\n').filterNot { it.trim().isEmpty() }.map { convertToPartInterpretation(it) }
        } ?: listOf()
    }

    private fun convertToPartInterpretation(paragraphLine: String): TextPartInterpretation {
        val paragraphValues = paragraphLine.split('\t')
        val nodeInfo = NodeInfo(paragraphValues[0].toInt(), paragraphValues[1].toInt())
        val textPartSpecification = TextPartSpecification(paragraphValues[2], paragraphValues[3], 0, paragraphValues[4],
                0, paragraphValues[5], 0, listOf(), GrammarClass("", "", PartOfSpeech.OTHER, listOf()),
                listOf(), paragraphValues[7].toFloat())
        return TextPartInterpretation(nodeInfo, textPartSpecification)
    }
}