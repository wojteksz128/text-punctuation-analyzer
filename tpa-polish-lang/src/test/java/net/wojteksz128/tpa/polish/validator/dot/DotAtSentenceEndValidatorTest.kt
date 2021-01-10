package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToDeletePossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToInsertPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToReplacePossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import net.wojteksz128.tpa.polish.validator.utils.StringToIntArrayConverter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource

internal class DotAtSentenceEndValidatorTest {

    @ParameterizedTest(name = "{index}. text=\"{0}\"")
    @CsvFileSource(resources = ["/dotAtSentenceEnd/correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        verifyTextPossibleChanges(text, listOf()) { DotAtSentenceEndValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/dotAtSentenceEnd/insert_dots.csv"], numLinesToSkip = 1)
    fun `Verification returns possible inserting dot in list of possible changes`(
        text: String,
        @ConvertWith(StringToIntArrayConverter::class) position: IntArray
    ) {
        verifyTextPossibleChanges(
            text,
            convertToInsertPossibleChanges(position, ".")
        ) { DotAtSentenceEndValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/dotAtSentenceEnd/replace_to_dot.csv"], numLinesToSkip = 1)
    fun `Verification returns possible replacing comma or semicolon to dot in list of possible changes`(
        text: String,
        @ConvertWith(
            StringToIntArrayConverter::class
        ) position: IntArray,
        replacedSign: String
    ) {
        verifyTextPossibleChanges(
            text,
            convertToReplacePossibleChanges(position, replacedSign, ".")
        ) { DotAtSentenceEndValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/dotAtSentenceEnd/delete_dots.csv"], numLinesToSkip = 1)
    fun `Verification returns possible deleting dot in list of possible changes`(
        text: String,
        @ConvertWith(StringToIntArrayConverter::class) position: IntArray
    ) {
        verifyTextPossibleChanges(
            text,
            convertToDeletePossibleChanges(position, ".")
        ) { DotAtSentenceEndValidator.validate(it) }
    }
}