package net.wojteksz128.tpa.utils.jpl

import org.jpl7.Atom
import org.jpl7.JPL
import org.jpl7.Query

object JPLInitializer {
    @JvmStatic
    fun main(args: Array<String>) {
        println("java.library.path=${System.getProperty("java.library.path")}")
        val initSwiConfig = "dummy --home=${System.getenv("SWI_HOME_DIR")} -g true -q"
        JPL.setDefaultInitArgs(initSwiConfig.split("\\s+").toTypedArray())
        JPL.init()

        `import data from test_pl`()
    }

    private fun `import data from test_pl`() {
        val q1 = Query("consult", arrayOf(Atom("test.pl")))
        println("consult ${if (q1.hasSolution()) "succeeded" else "failed"}")
        println("==================================================")
    }

    fun init() {
        println("java.library.path=${System.getProperty("java.library.path")}")
        val initSwiConfig = "dummy --home=${System.getenv("SWI_HOME_DIR")} -g true -q"
        JPL.setDefaultInitArgs(initSwiConfig.split("\\s+").toTypedArray())
        JPL.init()
    }
}