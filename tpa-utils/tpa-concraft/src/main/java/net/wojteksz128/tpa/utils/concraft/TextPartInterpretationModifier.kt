package net.wojteksz128.tpa.utils.concraft

import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation
import net.wojteksz128.tpa.utils.dag.TextPartSpecification
import net.wojteksz128.tpa.utils.dag.grammar.GrammarCategory

// TODO: 15.11.2020 przygotuj testy
object TextPartInterpretationModifier {

    fun splitMergedTags(textPart: TextPart) {
        val possibilityInterpretations = textPart.possibleCategories.flatMap { preparePossibilitiesList(it) }
        textPart.possibleCategories.clear()
        textPart.possibleCategories.plusAssign(possibilityInterpretations)
    }

    private fun preparePossibilitiesList(interpretation: TextPartInterpretation): List<TextPartInterpretation> {
        val wordCategories = interpretation.textPartSpecification.wordCategories.toMutableList()
        val tag = interpretation.textPartSpecification.tag

        val alternativeCategoriesGroups = wordCategories.groupBy { it.property }
                .filter { it.value.size > 1 }.map { it.value }

        if (alternativeCategoriesGroups.isEmpty()) {
            return listOf(interpretation)
        }
        val alternativeCategories = alternativeCategoriesGroups.flatten()
        alternativeCategories.forEach { category -> wordCategories -= category }

        val combinationsOfAlternatives = prepareCombinationsOfAlternatives(alternativeCategoriesGroups)
        return combinationsOfAlternatives.map { alternativeGroups ->
            val newCategories = wordCategories + alternativeGroups
            var newTag = tag
            (alternativeCategories - alternativeGroups).map { category -> category.shortcut }
                    .forEach { newTag = newTag.replace(if (newTag.contains("$it.")) "$it." else ".$it", "") }
            val orth = interpretation.textPartSpecification.orth
            val lemma = interpretation.textPartSpecification.lemma
            val tagId = interpretation.textPartSpecification.tagId
            val nameId = interpretation.textPartSpecification.nameId
            val name = interpretation.textPartSpecification.name
            val labelsId = interpretation.textPartSpecification.labelsId
            val labels = interpretation.textPartSpecification.labels
            val grammarClass = interpretation.textPartSpecification.grammarClass
            val specification = TextPartSpecification(orth, lemma, tagId, newTag, nameId, name, labelsId, labels,
                    grammarClass, newCategories)
            TextPartInterpretation(interpretation.nodeInfo, specification)
        }
    }

    private fun prepareCombinationsOfAlternatives(alternativeCategoriesGroups: List<List<GrammarCategory>>,
                                                  partialCombination: List<GrammarCategory> = listOf()): List<List<GrammarCategory>> {
        val combinations = mutableListOf<List<GrammarCategory>>()

        alternativeCategoriesGroups[0].forEach { category ->
            combinations += if (alternativeCategoriesGroups.size == 1) {
                listOf(partialCombination + category)
            } else {
                prepareCombinationsOfAlternatives(alternativeCategoriesGroups.drop(1),
                        partialCombination + category)
            }
        }

        return combinations.toList()
    }

    fun mergeCalculatedIntoExisted(preparedToInterpretation: List<TextPartInterpretation>, interpretedDag: List<TextPartInterpretation>?) {
        interpretedDag?.forEach { interpreted ->
            preparedToInterpretation.find { it similar interpreted }
                    ?.apply {
                        this.textPartSpecification.probability = interpreted.textPartSpecification.probability
                        this.textPartSpecification.endOfSentence = interpreted.textPartSpecification.endOfSentence
                    }
        }
    }

    fun orderByMostProbablyInterpretation(textPart: TextPart) {
        textPart.possibleCategories.sortByDescending { it.textPartSpecification.probability }
    }

    private infix fun TextPartInterpretation.similar(other: TextPartInterpretation) = this.nodeInfo.startNode == other.nodeInfo.startNode
            && this.nodeInfo.endNode == other.nodeInfo.endNode
            && this.textPartSpecification.orth == other.textPartSpecification.orth
            && this.textPartSpecification.lemma == other.textPartSpecification.lemma
            && this.textPartSpecification.tag == other.textPartSpecification.tag
            && this.textPartSpecification.name == other.textPartSpecification.name
}