package net.wojteksz128.tpa.utils.morfeusz

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.sgjp.morfeusz.Morfeusz
import kotlin.test.assertTrue

internal class MorfeuszTest {
    private lateinit var instance: Morfeusz

    @BeforeEach
    fun initMorfeusz() {
        instance = Morfeusz.createInstance()
    }

    @Test
    fun `Morfeusz return result for example 'Ala ma kota'`() {
        val analyzedText = "Ala ma kota"
        val result = instance.analyseAsList(analyzedText)
        result.forEach { println("${it.orth}, ${it.lemma}, ${it.getTag(instance)}") }
        assertTrue { result.isNotEmpty() }
    }

    @Test
    fun `Word 'Ala' tag from Morfeusz correct decoded`() {
        val analyzedText = "Ala"
        val result = instance.analyseAsList(analyzedText)
        assertTrue { result.size == 3 }
        result.forEach { morphInterpretation ->
            println("${morphInterpretation.orth}, ${morphInterpretation.lemma}, ${morphInterpretation.getTag(instance)}")
            val decoded = MorphInterpretationConverter.convert(morphInterpretation, instance)
            println(decoded)
            println()
        }
    }
}