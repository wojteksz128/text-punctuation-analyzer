package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.polish.validator.TextValidationUtils
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToInsertPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import net.wojteksz128.tpa.polish.validator.utils.StringToIntArrayConverter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource

internal class DotAtTheEndOfShortcutValidatorTest {

    @ParameterizedTest(name = "{index}. text=\"{0}\"")
    @CsvFileSource(resources = ["/dotAtTheEndOfShortcut/correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        verifyTextPossibleChanges(text, listOf()) { DotAtTheEndOfShortcutValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/dotAtTheEndOfShortcut/insert_dots.csv"], numLinesToSkip = 1)
    fun `Verification returns possible dot in list of possible changes`(text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray) {
        verifyTextPossibleChanges(text, convertToInsertPossibleChanges(position, ".")) { DotAtTheEndOfShortcutValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/dotAtTheEndOfShortcut/delete_dots.csv"], numLinesToSkip = 1)
    fun `Verification returns possible deleting dot in list of possible changes`(text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray) {
        verifyTextPossibleChanges(text, TextValidationUtils.convertToDeletePossibleChanges(position, ".")) { DotAtTheEndOfShortcutValidator.validate(it) }
    }
}