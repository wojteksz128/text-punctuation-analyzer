package net.wojteksz128.tpa.text

data class PossibleChange(val changeType: ChangeType, val position: Int, val old: String? = null, val new: String? = null)
