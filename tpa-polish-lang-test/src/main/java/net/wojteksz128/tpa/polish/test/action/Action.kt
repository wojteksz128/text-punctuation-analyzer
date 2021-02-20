package net.wojteksz128.tpa.polish.test.action

import net.wojteksz128.tpa.polish.test.args.LoadedArgs

interface Action {
    fun execute(loadedArgs: LoadedArgs)
}
