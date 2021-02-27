package net.wojteksz128.tpa.polish.test.action.measureStats

data class ConnectedExpectedWithActual<E, A>(val expected: E, var actual: A? = null)