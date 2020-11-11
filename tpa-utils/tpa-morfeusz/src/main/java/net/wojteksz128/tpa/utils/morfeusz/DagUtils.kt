package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.utils.dag.NodeInfo
import net.wojteksz128.tpa.utils.dag.TextPartSpecification
import net.wojteksz128.tpa.utils.dag.grammar.GrammarCategory
import net.wojteksz128.tpa.utils.dag.grammar.GrammarClass
import net.wojteksz128.tpa.utils.dag.grammar.Klasa
import pl.sgjp.morfeusz.Morfeusz
import pl.sgjp.morfeusz.MorphInterpretation


private val tagPartsPattern = "[:.]".toRegex()

@Suppress("TestFunctionName")
fun NodeInfo(interpretation: MorphInterpretation): NodeInfo = NodeInfo(interpretation.startNode, interpretation.endNode)

@Suppress("TestFunctionName")
fun TextPartSpecification(interpretation: MorphInterpretation, instance: Morfeusz): TextPartSpecification {
    val orth = interpretation.orth
    val lemma = interpretation.lemma
    val tagId = interpretation.tagId
    val tag = interpretation.getTag(instance)
    val nameId = interpretation.nameId
    val name = interpretation.getName(instance)
    val labelsId = interpretation.labelsId
    val labels = interpretation.getLabels(instance)
    val grammarClass = findGrammarClass(tag)
    val wordCategories = findGrammarCategory(grammarClass, tag)
    return TextPartSpecification(orth, lemma, tagId, tag, nameId, name, labelsId, labels, grammarClass, wordCategories)
}

private fun findGrammarClass(tag: String): GrammarClass = Klasa.classesMap[tag.split(tagPartsPattern)[0]]
        ?: throw Exception("Grammar class not found")

private fun findGrammarCategory(grammarClass: GrammarClass, tag: String): List<GrammarCategory> {
    val classCategories = grammarClass.properties.flatMap { it.values }.map { it.shortcut to it }.toMap()
    return tag.split(tagPartsPattern).drop(1).mapNotNull { classCategories[it] }
}