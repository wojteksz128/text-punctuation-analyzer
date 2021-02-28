package net.wojteksz128.tpa.polish.test.action.prepare

import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange

data class RemoveMarker(val changeFromOriginal: PossibleChange, val removedEarlier: Int, val toRemove: Boolean = true) {
    val changeAfterRemove: PossibleChange
        get() = PossibleChange(changeType, position - removedEarlier, old, new)

    val changeType: ChangeType
        get() = changeFromOriginal.changeType

    val position: Int
        get() = changeFromOriginal.position

    val old: String?
        get() = changeFromOriginal.old

    val new: String?
        get() = changeFromOriginal.new
}