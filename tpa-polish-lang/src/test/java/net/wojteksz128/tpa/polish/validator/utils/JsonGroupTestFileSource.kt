package net.wojteksz128.tpa.polish.validator.utils

import org.junit.jupiter.params.provider.ArgumentsSource

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(JsonFileArgumentsProvider::class)
annotation class JsonGroupTestFileSource(val resources: Array<String>)
