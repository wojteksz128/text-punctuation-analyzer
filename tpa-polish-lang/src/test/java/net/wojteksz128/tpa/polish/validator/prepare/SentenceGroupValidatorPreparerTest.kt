package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.polish.validator.Sentence
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.prepareTextAnalyseResult
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SentenceGroupValidatorPreparerTest {

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun sentencesPrepare() = listOf(
            Arguments.of("", listOf<ExpectedSentence>()),
//            Arguments.of("Tak", listOf<ExpectedSentence>()),    // TODO: 03.01.2021 Dodaj równoważniki zdania
//            Arguments.of("Piękna pogoda", listOf<ExpectedSentence>()),    // TODO: 03.01.2021 Dodaj równoważniki zdania
            Arguments.of("Idę", listOf(ExpectedSentence(statementWord = "Idę"))),
            Arguments.of("Idę.", listOf(ExpectedSentence(statementWord = "Idę"))),
            Arguments.of("Ala idzie", listOf(ExpectedSentence(listOf("Ala"), "idzie"))),
            Arguments.of("Ala. idzie", listOf(ExpectedSentence(listOf("Ala"), "idzie"))),
            Arguments.of("Ala idzie.", listOf(ExpectedSentence(listOf("Ala"), "idzie"))),
            Arguments.of("Ala ma kota", listOf(ExpectedSentence(listOf("Ala"), "ma", listOf("kota")))),
            Arguments.of("Ala. ma kota", listOf(ExpectedSentence(listOf("Ala"), "ma", listOf("kota")))),
            Arguments.of("Ala ma. kota", listOf(ExpectedSentence(listOf("Ala"), "ma", listOf("kota")))),
            Arguments.of("Ala ma kota.", listOf(ExpectedSentence(listOf("Ala"), "ma", listOf("kota")))),
            Arguments.of(
                "Ala ma bardzo małego kota",
                listOf(ExpectedSentence(listOf("Ala"), "ma", listOf("bardzo", "małego", "kota")))
            ),
            Arguments.of(
                "Mała Ala ma bardzo małego kota",
                listOf(ExpectedSentence(listOf("Mała", "Ala"), "ma", listOf("bardzo", "małego", "kota")))
            ),
            Arguments.of(
                "Kobieta myje włosy szamponem.",
                listOf(ExpectedSentence(listOf("Kobieta"), "myje", listOf("włosy", "szamponem")))
            ),
            Arguments.of(
                "Włosy są myte przez kobietę szamponem.",
                listOf(ExpectedSentence(listOf("Włosy"), "są", listOf("myte", "przez", "kobietę", "szamponem")))
            ),
            Arguments.of(
                "Ala ma kota kot ma Alę", listOf(
                    ExpectedSentence(listOf("Ala"), "ma", listOf("kota")),
                    ExpectedSentence(listOf("kot"), "ma", listOf("Alę"))
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("sentencesPrepare")
    fun `Sentences prepare tests`(text: String, expectedSentences: List<ExpectedSentence>) {
        val objects = whenPrepareSentencesFromText(text)
        thenSentencesAreTheSameAsExpected(objects, expectedSentences)
    }

    private fun whenPrepareSentencesFromText(text: String): List<*>? {
        val result = prepareTextAnalyseResult(text, listOf(SentenceGroupValidatorPreparer))
        return result.additionalParts[PolishAdditionalPartsName.SENTENCE_GROUP.name]
    }

    private fun thenSentencesAreTheSameAsExpected(objects: List<*>?, expectedSentences: List<ExpectedSentence>) {
        assertNotNull(objects)
        assertEquals(expectedSentences.size, objects?.size, "Number of sentences are not the same.")
        val sentences = getExpectedSentences(objects!!)

        expectedSentences.zip(sentences).forEach {
            thenSentenceSubjectWordsHasWords(it.first, it.second)
            thenSentenceStatementIsEqual(it.first.statementWord, it.second)
            thenSentenceComplementWordsHasWords(it.first, it.second)
        }
    }

    private fun getExpectedSentences(objects: List<*>): List<Sentence> {
        val sentences = mutableListOf<Sentence>()

        objects.forEach { obj ->
            assertTrue({ obj is Sentence }, "Object is not type of net.wojteksz128.tpa.polish.validator.Sentence.")
            sentences.add(obj as Sentence)
        }

        return sentences
    }

    private fun thenSentenceSubjectWordsHasWords(expectedSentence: ExpectedSentence, sentence: Sentence) =
        thenSentenceWordsCollectionHasWords(
            expectedSentence, sentence, ExpectedSentence::subjectWords,
            { s -> s.subjectWords.map { it.text } }, "Subject words"
        )

    private fun thenSentenceStatementIsEqual(expectedStatement: String, sentence: Sentence) {
        assertEquals(expectedStatement, sentence.statementWord.text, "Statement word in sentence is not the same")
    }

    private fun thenSentenceComplementWordsHasWords(expectedSentence: ExpectedSentence, sentence: Sentence) =
        thenSentenceWordsCollectionHasWords(
            expectedSentence, sentence, ExpectedSentence::complementWords,
            { s -> s.complementWords.map { it.text } }, "Complement words"
        )

    private fun thenSentenceWordsCollectionHasWords(
        expectedSentence: ExpectedSentence, sentence: Sentence,
        expectedFunction: (ExpectedSentence) -> List<String>,
        sentenceFunction: (Sentence) -> List<String>,
        collectionName: String
    ) {
        val expectedElements: List<String> = expectedFunction(expectedSentence)
        val actualElements: List<String> = sentenceFunction(sentence)
        assertEquals(
            expectedElements.size, actualElements.size, "$collectionName count for sentence is not the same.\n" +
                    "\tExpected: $expectedElements\n" +
                    "\tActual: $actualElements\n"
        )
        expectedElements.zip(actualElements)
            .forEach { assertEquals(it.first, it.second, "Word in sentence is not the same.") }
    }

    data class ExpectedSentence(
        val subjectWords: List<String> = listOf(),
        val statementWord: String,
        val complementWords: List<String> = listOf()
    )
}
