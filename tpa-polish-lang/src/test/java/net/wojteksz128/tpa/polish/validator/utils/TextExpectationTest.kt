package net.wojteksz128.tpa.polish.validator.utils

data class TextExpectationTest(val text: String, val expected: List<Group>) {
    override fun toString(): String {
        return "text = '$text', expected = List<Group>(size = ${expected.size}, items = $expected)"
    }
}
