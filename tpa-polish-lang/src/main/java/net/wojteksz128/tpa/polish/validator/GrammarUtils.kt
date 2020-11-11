package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.Word
import net.wojteksz128.tpa.utils.dag.grammar.GrammarCategory
import net.wojteksz128.tpa.utils.dag.grammar.GrammarClass
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

infix fun Word.isTypeOf(partOfSpeech: PartOfSpeech) = possibleCategories
        .any { it.textPartSpecification.grammarClass.partOfSpeech == partOfSpeech }

infix fun Word.isClassOf(grammarClass: GrammarClass) = possibleCategories
        .any { it.textPartSpecification.grammarClass == grammarClass }

fun Word.haveAnyOf(vararg categories: GrammarCategory) = possibleCategories
        .any { decoded -> decoded.textPartSpecification.wordCategories.any { it in categories } }

fun Word.haveAllOf(vararg categories: GrammarCategory) = possibleCategories
        .any { decoded -> decoded.textPartSpecification.wordCategories.containsAll(categories.toList()) }