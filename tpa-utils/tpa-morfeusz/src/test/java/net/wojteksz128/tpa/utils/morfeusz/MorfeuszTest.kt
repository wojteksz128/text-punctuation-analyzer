package net.wojteksz128.tpa.utils.morfeusz

import pl.sgjp.morfeusz.Morfeusz

fun main() {
    val instance = Morfeusz.createInstance()

    val analyseAsList = instance.analyseAsList("Ala ma kota.")
    analyseAsList.forEach { println("${it.orth}, ${it.lemma}, ${it.getTag(instance)}") }
}