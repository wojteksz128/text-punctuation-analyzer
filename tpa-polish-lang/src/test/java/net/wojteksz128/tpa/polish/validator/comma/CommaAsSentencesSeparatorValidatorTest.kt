package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.polish.validator.TextValidationUtils.convertToInsertPossibleChanges
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.verifyTextPossibleChanges
import org.junit.jupiter.api.Test

internal class CommaAsSentencesSeparatorValidatorTest {

    //    @ParameterizedTest(name = "{index}. text=\"{0}\", position={1}")
//    @CsvFileSource(resources = ["/CASS_insert_comma.csv"], numLinesToSkip = 1)
    @Test
    fun `Verification returns possible inserting comma in list of possible changes`(/*text: String, @ConvertWith(StringToIntArrayConverter::class) position: IntArray*/) {
        verifyTextPossibleChanges("Poszedł tam pomimo że się bał.", convertToInsertPossibleChanges(intArrayOf(10), ",")) { CommaAsSentencesSeparatorValidator.validate(it) }
    }
}