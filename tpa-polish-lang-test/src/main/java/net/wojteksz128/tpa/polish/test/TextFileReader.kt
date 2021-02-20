package net.wojteksz128.tpa.polish.test

import java.io.File

internal class TextFileReader {
    private var filePathExpected = false

    fun filePathProcess(arg: String, textsToAnalyse: MutableList<String>): Boolean {
        return when {
            filePathExpected -> {
                assignFileContentToList(arg, textsToAnalyse)
                true
            }
            listOf("--file", "-f", "-file").contains(arg) -> true.also { filePathExpected = it }
            else -> false
        }
    }

    private fun assignFileContentToList(arg: String, textsToAnalyse: MutableList<String>) {
        val fileContentStream = File(arg).inputStream()
        textsToAnalyse += fileContentStream.bufferedReader().readLines()
        filePathExpected = false
    }
}