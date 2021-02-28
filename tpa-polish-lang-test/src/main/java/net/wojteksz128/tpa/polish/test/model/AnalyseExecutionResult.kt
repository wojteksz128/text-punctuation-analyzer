package net.wojteksz128.tpa.polish.test.model

import com.beust.klaxon.Json
import kotlin.time.ExperimentalTime

data class AnalyseExecutionResult(val results: MutableList<TextAnalyzeResultDto> = mutableListOf()) {
    @ExperimentalTime
    @Json(ignored = true)
    val totalExecutionTimeMillis: Long
        get() = if (results.isNotEmpty()) results.map { it.executionTimeMillis }.reduce { a, b -> a + b } else 0
}