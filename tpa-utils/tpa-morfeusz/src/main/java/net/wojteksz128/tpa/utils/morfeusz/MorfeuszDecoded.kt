package net.wojteksz128.tpa.utils.morfeusz

class MorfeuszDecoded(val tag: String, val grammarClass: GrammarClass?, val wordCategories: List<GrammarCategory>) {
    override fun toString(): String {
        return "MorfeuszDecoded(tag='$tag', grammarClass=$grammarClass, wordCategories=$wordCategories)"
    }
}