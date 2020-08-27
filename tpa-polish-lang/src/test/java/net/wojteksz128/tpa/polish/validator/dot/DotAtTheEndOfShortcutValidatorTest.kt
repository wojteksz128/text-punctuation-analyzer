package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToInsertPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource

internal class DotAtTheEndOfShortcutValidatorTest {

    @ParameterizedTest(name = "{index}. text=\"{0}\"")
    @CsvFileSource(resources = ["/DATEOS_correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        verifyTextPossibleChanges(text, listOf()) { DotAtTheEndOfShortcutValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/DATEOS_one_dot.csv"], numLinesToSkip = 1)
    fun `Verification returns possible dot in list of possible changes`(text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray) {
        verifyTextPossibleChanges(text, convertToInsertPossibleChanges(position, ".")) { DotAtTheEndOfShortcutValidator.validate(it) }
    }
}