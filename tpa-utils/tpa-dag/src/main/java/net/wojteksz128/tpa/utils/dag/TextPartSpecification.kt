package net.wojteksz128.tpa.utils.dag

import net.wojteksz128.tpa.utils.dag.grammar.GrammarCategory
import net.wojteksz128.tpa.utils.dag.grammar.GrammarClass

data class TextPartSpecification(
        val orth: String,
        val lemma: String,
        val tagId: Int,
        var tag: String,
        val nameId: Int,
        var name: String,
        val labelsId: Int,
        var labels: Collection<String>,
        var grammarClass: GrammarClass,
        var wordCategories: List<GrammarCategory>,
        var probability: Float = 0.0f,
        var endOfSentence: Boolean = false
) {
}
