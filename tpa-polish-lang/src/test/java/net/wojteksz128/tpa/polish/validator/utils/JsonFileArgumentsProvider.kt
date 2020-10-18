package net.wojteksz128.tpa.polish.validator.utils

import com.beust.klaxon.Klaxon
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.support.AnnotationConsumer
import java.io.InputStream
import java.util.*
import java.util.stream.Stream

class JsonFileArgumentsProvider : ArgumentsProvider, AnnotationConsumer<JsonFileSource<Group>> {

    lateinit var resources: Array<String>

    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return ArrayList<Arguments>(resources.map { openInputStream(context, it) }.map { readValues(it) }.flatten()
                .map { Arguments.arguments(it) }).stream()
    }

    private fun readValues(inputStream: InputStream): List<TextExpectationTest> {
        return Klaxon().parseArray(inputStream) ?: listOf()
    }

    private fun openInputStream(context: ExtensionContext?, resourcePath: String): InputStream {
        val requiredTestClass = context?.requiredTestClass!!
        return requiredTestClass.getResourceAsStream(resourcePath)
    }

    override fun accept(t: JsonFileSource<Group>?) {
        resources = t?.resources ?: arrayOf()
    }

}
