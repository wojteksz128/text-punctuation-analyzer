package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToInsertPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import net.wojteksz128.tpa.polish.validator.dot.StringToIntArrayConverter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvFileSource

internal class CommaAsSentencesSeparatorValidatorTest {

    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
    @CsvFileSource(resources = ["/commaAsSentencesSeparator/insert_commas.csv"], numLinesToSkip = 1)
    fun `Verification returns possible inserting comma in list of possible changes`(text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray) {
        verifyTextPossibleChanges(text, convertToInsertPossibleChanges(position, ",")) { CommaAsSentencesSeparatorValidator.validate(it) }
    }
}