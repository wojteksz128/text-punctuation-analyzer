package net.wojteksz128.tpa.utils.jpl

import org.jpl7.Atom
import org.jpl7.Query
import java.io.File

class JPLInstance {
    init {
        val swigraPath = System.getProperty("swigra.path")
        importPLScript(File("$swigraPath/swigra2_batch.pl"))
    }

    fun importPLScript(vararg scriptPath: File) {
        val q1 = Query("consult", scriptPath.map { Atom(it.absolutePath) }.toTypedArray())
        println("importing ${scriptPath.map { Atom(it.absolutePath) }.joinToString()} ${if (q1.hasSolution()) "succeeded" else "failed"}")
    }

    fun analise(text: String) = Query("analiza", arrayOf(Atom(text)))
}
