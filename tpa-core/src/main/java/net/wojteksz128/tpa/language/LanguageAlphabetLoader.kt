package net.wojteksz128.tpa.language

import com.beust.klaxon.Klaxon
import java.io.File
import java.io.InputStream

object LanguageAlphabetLoader {

    fun load() = load(openExternalFile(System.getProperty("language.file"))
            ?: LanguageAlphabetLoader::class.java.getResourceAsStream("/default_lang.json"))

    private fun openExternalFile(filePath: String?): InputStream? {
        return filePath?.let { File(filePath).inputStream() }
    }

    fun load(langAlphabetInputStream: InputStream): LanguageAlphabet {
        return Klaxon().parse<LanguageAlphabet>(langAlphabetInputStream) ?: throw Exception("File wrong parsed.")
    }
}