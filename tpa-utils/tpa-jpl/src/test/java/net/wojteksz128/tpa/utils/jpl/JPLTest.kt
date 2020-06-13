package net.wojteksz128.tpa.utils.jpl

import org.jpl7.*

/**
 * Test of functionality, based on materials from https://github.com/SWI-Prolog/packages-jpl/wiki/Getting-Started---An-Example-Tutorial
 * and https://jpl7.org/TutorialGettingStarted.
 */
fun main() {
    val initSwiConfig = "dummy --home=${System.getenv("SWI_HOME_DIR")} -g true -q"
    JPL.setDefaultInitArgs(initSwiConfig.split("\\s+").toTypedArray())
    JPL.init()

    `import data from test_pl`()
    `test child_of`()
    `test descendent_of`()
    val x = `test getting descendent_of`()
    `test getting other descendent_of by iterator`(x)
}

private fun `import data from test_pl`() {
    val q1 = Query("consult", arrayOf(Atom("test.pl")))
    println("consult ${if (q1.hasSolution()) "succeeded" else "failed"}")
    println("==================================================")
}

private fun `test child_of`() {
    val q2 = Query("child_of", arrayOf<Term>(Atom("joe"), Atom("ralf")))
    println("child_of(joe, ralf) is ${if (q2.hasSolution()) "provable" else "not provable"}")
    println("==================================================")
}

private fun `test descendent_of`() {
    val q3 = Query("descendent_of", arrayOf<Term>(Atom("steve"), Atom("ralf")))
    println("descendent_of(steve, ralf) is ${if (q3.hasSolution()) "provable" else "not provable"}")
    println("==================================================")
}

private fun `test getting descendent_of`(): Variable {
    val x = Variable("X")
    val q4 = Query("descendent_of", arrayOf(x, Atom("ralf")))

    val solution = q4.oneSolution()

    println("first solution of descendent_of(X, ralf)")
    println("X = ${solution["X"]}")
    println("==================================================")

    val solutions = q4.allSolutions()   // May be replaced by 'q4.nSolutions(20)'
    solutions.forEach { println("X = ${it["X"]}") }
    println("==================================================")
    return x
}

private fun `test getting other descendent_of by iterator`(x: Variable) {
    val y = Variable("Y")
    val q5 = Query("descendent_of", arrayOf(x, y))

    while (q5.hasMoreSolutions()) {
        val solution = q5.nextSolution()
        println("X = ${solution["X"]}, Y = ${solution["Y"]}")
    }
}
