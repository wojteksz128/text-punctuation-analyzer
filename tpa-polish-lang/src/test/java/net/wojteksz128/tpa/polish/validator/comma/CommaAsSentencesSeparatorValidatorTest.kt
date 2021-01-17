package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToDeletePossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToInsertPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import net.wojteksz128.tpa.polish.validator.utils.StringToIntArrayConverter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource

internal class CommaAsSentencesSeparatorValidatorTest {

    @ParameterizedTest(name = "{index}. text=\"{0}\"")
    @CsvFileSource(resources = ["/commaAsSentencesSeparator/correct.csv"], numLinesToSkip = 1)
    fun `Verification returns empty list of possible changes`(text: String) {
        verifyTextPossibleChanges(text, listOf()) { CommaAsSentencesSeparatorValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/commaAsSentencesSeparator/insert_commas.csv"], numLinesToSkip = 1)
    fun `Verification returns possible inserting comma in list of possible changes`(
        text: String,
        @ConvertWith(
            StringToIntArrayConverter::class
        ) position: IntArray
    ) {
        verifyTextPossibleChanges(
            text,
            convertToInsertPossibleChanges(position, ",")
        ) { CommaAsSentencesSeparatorValidator.validate(it) }
    }

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/commaAsSentencesSeparator/delete_commas.csv"], numLinesToSkip = 1)
    fun `Verification returns possible deleting comma in list of possible changes`(
        text: String,
        @ConvertWith(
            StringToIntArrayConverter::class
        ) position: IntArray
    ) {
        verifyTextPossibleChanges(
            text,
            convertToDeletePossibleChanges(position, ",")
        ) { CommaAsSentencesSeparatorValidator.validate(it) }
    }

    // TODO: 09.01.2021 create replace to comma tests
}