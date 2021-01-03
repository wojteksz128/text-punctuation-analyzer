package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.part.Word
import net.wojteksz128.tpa.utils.dag.grammar.GrammarCategory
import net.wojteksz128.tpa.utils.dag.grammar.GrammarClass
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

// TODO: 01.01.2021 Może warto zwracać procent poprawności odpowiedzi w oparciu o pozostałe rezultaty?
infix fun Word.isTypeOf(partOfSpeech: PartOfSpeech) =
        possibleCategories.firstOrNull()
                ?.let { it.textPartSpecification.grammarClass.partOfSpeech == partOfSpeech } == true

// TODO: 01.01.2021 Może warto zwracać procent poprawności odpowiedzi w oparciu o pozostałe rezultaty?
infix fun Word.isClassOf(grammarClass: GrammarClass) =
        possibleCategories.firstOrNull()?.let { it.textPartSpecification.grammarClass == grammarClass } == true

// TODO: 01.01.2021 Może warto zwracać procent poprawności odpowiedzi w oparciu o pozostałe rezultaty?
fun Word.haveAnyOf(vararg categories: GrammarCategory) =
        possibleCategories.firstOrNull()
                ?.let { decoded -> decoded.textPartSpecification.wordCategories.any { it in categories } } == true

// TODO: 01.01.2021 Może warto zwracać procent poprawności odpowiedzi w oparciu o pozostałe rezultaty?
fun Word.haveAllOf(vararg categories: GrammarCategory) =
        possibleCategories.firstOrNull()?.textPartSpecification?.wordCategories?.containsAll(categories.toList()) == true