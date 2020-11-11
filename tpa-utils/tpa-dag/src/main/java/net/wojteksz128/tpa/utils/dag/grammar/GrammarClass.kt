package net.wojteksz128.tpa.utils.dag.grammar

class GrammarClass(val shortcut: String, val name: String, val partOfSpeech: PartOfSpeech, val properties: List<GrammarCategoryGroup>) {
    override fun toString() = "WordClass(shortcut='$shortcut', name='$name')"
}