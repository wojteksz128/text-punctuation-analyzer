package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.morfeusz.GrammarCategory
import net.wojteksz128.tpa.utils.morfeusz.GrammarClass
import net.wojteksz128.tpa.utils.morfeusz.MorfeuszDecoded
import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech

infix fun Word.isTypeOf(partOfSpeech: PartOfSpeech) = possibleCategories.map { it as MorfeuszDecoded }.any { it.grammarClass?.partOfSpeech == partOfSpeech }

infix fun Word.isClassOf(grammarClass: GrammarClass) = possibleCategories.map { it as MorfeuszDecoded }.any { it.grammarClass == grammarClass }

fun Word.haveOneOf(vararg categories: GrammarCategory) = possibleCategories.map { it as MorfeuszDecoded }.any { decoded -> decoded.wordCategories.any { it in categories } }