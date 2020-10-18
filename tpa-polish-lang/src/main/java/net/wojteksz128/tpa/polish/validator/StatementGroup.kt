package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.TextPart
import net.wojteksz128.tpa.text.Word

class StatementGroup(text: String, startAt: Int, endAt: Int, val items: MutableList<Word>) : TextPart(text, startAt, endAt, mutableListOf())
