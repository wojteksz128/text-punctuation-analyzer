package net.wojteksz128.tpa.polish.test.args

import net.wojteksz128.tpa.polish.test.action.Action
import net.wojteksz128.tpa.polish.test.printer.ResultPrinter

data class LoadedArgs(
    val texts: List<String>,
    val action: Action,
    val outputName: String?,
    val resultFile: String?,
    val prepareSolutionFile: String?,
    val resultPrinter: ResultPrinter
)