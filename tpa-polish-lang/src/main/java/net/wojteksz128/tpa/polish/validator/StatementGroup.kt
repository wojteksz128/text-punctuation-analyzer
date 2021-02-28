package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.TextPart
import net.wojteksz128.tpa.text.part.Word

class StatementGroup(text: String, startAt: Int, endAt: Int, val items: MutableList<AwareOfSurroundings<Word>>) :
    TextPart(text, startAt, endAt, mutableListOf())
