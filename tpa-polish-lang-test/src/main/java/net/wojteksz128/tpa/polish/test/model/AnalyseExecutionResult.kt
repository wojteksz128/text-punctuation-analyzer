package net.wojteksz128.tpa.polish.test.model

import com.beust.klaxon.Json
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

data class AnalyseExecutionResult(val results: MutableList<TextAnalyzeResultDto> = mutableListOf()) {
    @ExperimentalTime
    @Json(ignored = true)
    val totalExecutionTime: Duration
        get() = results.map { it.executionTime }.reduce { a, b -> a + b }
}