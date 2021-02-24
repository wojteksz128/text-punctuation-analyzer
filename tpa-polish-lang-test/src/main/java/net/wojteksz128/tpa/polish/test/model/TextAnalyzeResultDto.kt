package net.wojteksz128.tpa.polish.test.model

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue
import net.wojteksz128.tpa.text.PossibleChange
import java.util.concurrent.TimeUnit
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

data class TextAnalyzeResultDto @JvmOverloads @ExperimentalTime constructor(
    val textId: String,
    val solution: List<PossibleChange>,
    val textParts: List<TextPartDto>,
    @KlaxonDuration
    val executionTime: Duration
) {

    class DurationConverter : Converter {
        @ExperimentalTime
        override fun canConvert(cls: Class<*>): Boolean =
            cls == Duration::class.java

        @ExperimentalTime
        override fun fromJson(jv: JsonValue): Any {
            return jv.objInt("value").toDuration(TimeUnit.NANOSECONDS)
        }

        @ExperimentalTime
        override fun toJson(value: Any): String {
            val duration = value as Duration
            return """{"value" : "${duration.toLongNanoseconds()}"}"""
        }
    }

    @Target(AnnotationTarget.FIELD)
    annotation class KlaxonDuration
}