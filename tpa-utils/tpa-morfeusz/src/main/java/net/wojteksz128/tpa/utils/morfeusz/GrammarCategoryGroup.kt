package net.wojteksz128.tpa.utils.morfeusz

class GrammarCategoryGroup(val name: String, val values: List<GrammarCategory>) {
    init {
        values.forEach { it.property = this }
    }

    override fun toString() = "GrammarCategoryGroup(name='$name')"
}