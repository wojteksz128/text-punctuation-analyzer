package net.wojteksz128.tpa.polish.test.model

import com.beust.klaxon.Json
import net.wojteksz128.tpa.text.PossibleChange

data class TextSolution(
    @Json(index = 1) val textId: String,
    @Json(index = 2) val solution: List<PossibleChange>,
    @Json(index = 3) val spaces: Set<Int>
)
