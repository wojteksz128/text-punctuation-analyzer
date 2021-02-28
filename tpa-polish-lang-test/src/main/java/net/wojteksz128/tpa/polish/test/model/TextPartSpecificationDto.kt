package net.wojteksz128.tpa.polish.test.model

data class TextPartSpecificationDto(
    val tag: String,
    val grammarClass: GrammarClassDto,
    val categories: List<GrammarCategoryDto>,
    val probability: Float
)