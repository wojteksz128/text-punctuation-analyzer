package net.wojteksz128.tpa.utils.morfeusz

object MorfeuszTagDecode {

    private val classesMap: Map<String, GrammarClass> = MorfeuszWordTags.classes.map { it.shortcut to it }.toMap()

    fun decode(tag: String): MorfeuszDecoded {
        val tagParts = tag.split("[:.]".toRegex()).toMutableList()

        val grammarClass = classesMap[tagParts.removeAt(0)]
        val grammarCategories = grammarClass?.properties?.flatMap { it.values }?.map { it.shortcut to it }?.toMap()
                ?: mapOf()

        val wordCategories = tagParts.mapNotNull { grammarCategories[it] }.toList()
        return MorfeuszDecoded(tag, grammarClass, wordCategories)
    }
}