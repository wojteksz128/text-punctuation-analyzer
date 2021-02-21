package net.wojteksz128.tpa.polish.test

import net.wojteksz128.tpa.polish.test.action.HelpAction
import net.wojteksz128.tpa.polish.test.args.ArgsReader
import kotlin.time.ExperimentalTime

/*
* Examples:
*   "Ala ma kota."
*   "Chciałem Ci powiedzieć, że lubię często kłamać..."
*   "Proszę, kochaj mnie..."
*   "Zażółć gęślą jaźń"
*/

@ExperimentalTime
fun main(args: Array<String>) {
    try {
        val argsReader = ArgsReader()
        val loadedArgs = argsReader.readArgs(args)

        loadedArgs.action.execute(loadedArgs)
    } catch (e: IllegalStateException) {
        System.err.println("${e.message}\n")
        HelpAction().printHelp()
    } catch (e: Exception) {
        System.err.println("Wystąpił nieznany błąd")
        e.printStackTrace(System.err)
    }
}

