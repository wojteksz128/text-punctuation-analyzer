package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource

internal class DotAtSentenceEndValidatorTest {

    @ParameterizedTest(name = "{index}. text=\"{0}\"")
    @CsvFileSource(resources = ["/DASEV_correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        verifyTextPossibleChanges(text, listOf()) { DotAtSentenceEndValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/DASEV_one_dot.csv"], numLinesToSkip = 1)
    fun `Verification returns possible dot in list of possible changes`(text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray) {
        verifyTextPossibleChanges(text, convertToPossibleChanges(position, ".")) { DotAtSentenceEndValidator.validate(it) }
    }
}