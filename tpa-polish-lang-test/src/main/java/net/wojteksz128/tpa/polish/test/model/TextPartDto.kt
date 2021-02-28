package net.wojteksz128.tpa.polish.test.model

data class TextPartDto(
    val text: String,
    val startAt: Int,
    val endAt: Int,
    val possibleCategories: List<TextPartSpecificationDto>
)