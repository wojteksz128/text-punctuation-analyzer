package net.wojteksz128.tpa.utils.dag.grammar

class GrammarCategory(val shortcut: String, val valueName: String) {
    lateinit var property: GrammarCategoryGroup

    val displayName: String
        get() = "${property.name}: $valueName"

    override fun toString(): String {
        return "GrammarCategory(shortcut='$shortcut', valueName='$valueName', property=$property)"
    }
}