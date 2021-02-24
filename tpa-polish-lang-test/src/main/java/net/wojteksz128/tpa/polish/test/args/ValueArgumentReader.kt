package net.wojteksz128.tpa.polish.test.args

class ValueArgumentReader {
    var value: String? = null
    private var isValueExpected = false

    fun checkOutputName(arg: String, vararg expectedPattern: String): Boolean {
        return when {
            isValueExpected -> {
                if (arg.startsWith("-")) throw IllegalStateException("Nazwą pliku nie może zaczynać się od znaku '-' (wprowadzono '$arg')")
                value = arg
                isValueExpected = false
                true
            }
            expectedPattern.contains(arg) -> true.also { isValueExpected = it }
            else -> false
        }
    }
}
