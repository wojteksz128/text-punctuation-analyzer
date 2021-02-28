package net.wojteksz128.tpa.polish.validator.utils

import com.beust.klaxon.Klaxon
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.converter.ArgumentConverter

class StringToGroupListConverter : ArgumentConverter {

    override fun convert(source: Any?, context: ParameterContext?): Any {
        if ((source !is String)) {
            throw IllegalArgumentException("The argument is not be a string ($source).")
        }
        return Klaxon().parseArray<Group>(source)!!
    }
}