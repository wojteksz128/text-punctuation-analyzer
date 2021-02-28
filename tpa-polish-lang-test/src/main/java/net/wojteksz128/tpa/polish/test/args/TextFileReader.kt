package net.wojteksz128.tpa.polish.test.args

import java.io.File

class TextFileReader {
    private var filePathExpected = false

    fun checkIsFilePath(arg: String, textsToAnalyse: MutableList<String>): Boolean {
        return when {
            filePathExpected -> {
                if (arg.startsWith("-")) throw IllegalStateException("Nazwą pliku nie może zaczynać się od znaku '-' (wprowadzono '$arg')")
                assignFileContentToList(arg, textsToAnalyse)
                true
            }
            listOf("--file", "-f").contains(arg) -> true.also { filePathExpected = it }
            else -> false
        }
    }

    private fun assignFileContentToList(arg: String, textsToAnalyse: MutableList<String>) {
        val fileContentStream = File(arg).inputStream()
        textsToAnalyse += fileContentStream.bufferedReader().readLines()
        filePathExpected = false
    }
}