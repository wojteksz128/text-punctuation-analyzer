package net.wojteksz128.tpa.polish.validator.dot

import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.converter.ArgumentConverter

class StringToIntArrayConverter : ArgumentConverter {

    val numberRegex = "\\d+".toRegex()

    override fun convert(source: Any?, context: ParameterContext?): Any {
        if ((source !is String) || !source.startsWith('[') || !source.endsWith(']')) {
            throw IllegalArgumentException("The argument should be a string with list of numbers separated by comma in " +
                    "square brackets, ex. '[1,2]'. Now is: '$source'")
        }
        try {
            return numberRegex.findAll(source).map { it.value.toInt() }.toList().toIntArray()
        } catch (e: Exception) {
            throw IllegalArgumentException("Failed to convert $source", e)
        }
    }
}