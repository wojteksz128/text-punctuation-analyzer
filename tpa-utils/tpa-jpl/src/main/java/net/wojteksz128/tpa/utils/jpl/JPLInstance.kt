package net.wojteksz128.tpa.utils.jpl

import org.jpl7.Atom
import org.jpl7.Query
import java.io.File

class JPLInstance {
    init {
        val swigraPath = System.getProperty("swigra.path")
        importPLScript(File("$swigraPath/birnam_run.pl"))
        importPLScript(File("$swigraPath/birnam_dumpedges.pl"))
        importPLScript(File("$swigraPath/gfjp_morfologia.pl"))
        importPLScript(File("$swigraPath/gfjp_slowskr.pl"))
        importPLScript(File("$swigraPath/gfjp_slowpart.pl"))
        importPLScript(File("$swigraPath/slowczas.pl"))
        importPLScript(File("$swigraPath/slowrzecz.pl"))
        importPLScript(File("$swigraPath/slowprzym.pl"))
        importPLScript(File("$swigraPath/gfjp_analiza.pl"))
        importPLScript(File("$swigraPath/gfjp_wymagania.pl"))
        importPLScript(File("$swigraPath/birnam_sequences.pl"))
        importPLScript(File("$swigraPath/gfjp2_warunki.pl"))
        importPLScript(File("$swigraPath/gfjp2.pl"))
        importPLScript(File("$swigraPath/gfjp2_arnoscint.pl"))
        importPLScript(File("$swigraPath/gfjp_swidzinskify.pl"))
    }

    fun importPLScript(vararg scriptPath: File) {
        val q1 = Query("consult", scriptPath.map { Atom(it.absolutePath) }.toTypedArray())
        println("importing ${scriptPath.map { Atom(it.absolutePath) }.joinToString()} ${if (q1.hasSolution()) "succeeded" else "failed"}")
    }

    fun analise(text: String) = Query("analiza", arrayOf(Atom(text)))
}
