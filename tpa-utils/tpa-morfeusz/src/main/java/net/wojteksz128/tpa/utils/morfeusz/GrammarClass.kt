package net.wojteksz128.tpa.utils.morfeusz

class GrammarClass(val shortcut: String, val name: String, val properties: List<GrammarCategoryGroup>) {
    override fun toString() = "WordClass(shortcut='$shortcut', name='$name')"
}