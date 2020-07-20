package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.text.TextPartCategory

class MorfeuszDecoded(val tag: String, val grammarClass: GrammarClass?, val wordCategories: List<GrammarCategory>) : TextPartCategory {
    override fun toString(): String {
        return "MorfeuszDecoded(tag='$tag', grammarClass=$grammarClass, wordCategories=$wordCategories)"
    }
}