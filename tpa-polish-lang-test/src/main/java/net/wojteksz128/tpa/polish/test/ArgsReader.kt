package net.wojteksz128.tpa.polish.test

internal class ArgsReader {
    fun readArgs(args: Array<String>): MutableList<String> {
        val textFileReader = TextFileReader()
        val textsToAnalyse = mutableListOf<String>()

        args.forEach {
            when {
                textFileReader.filePathProcess(it, textsToAnalyse) -> {
                }
                else -> textsToAnalyse += it
            }
        }
        return textsToAnalyse
    }
}