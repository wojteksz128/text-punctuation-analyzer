package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.prepareTextAnalyseResult
import net.wojteksz128.tpa.polish.validator.utils.JsonGroupTestFileSource
import net.wojteksz128.tpa.polish.validator.utils.TextExpectationTest
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class StatementGroupTextValidatorPreparerTest {
    @Test
    fun `Text with no verb cannot have statement group`() {
        val text = "Ala."
        val result = prepareTextAnalyseResult(text, listOf(StatementGroupTextValidatorPreparer))
        val statementGroups = result.additionalParts[PolishAdditionalPartsName.STATEMENT_GROUP.name]
        assertTrue { statementGroups?.isEmpty() ?: false }
    }

    @ParameterizedTest(name = "{index}. {0}")
    @JsonGroupTestFileSource(resources = ["/statementGroupsPreparer/statement_groups.json"])
    fun `Text with only verb have one statement group`(textExpectation: TextExpectationTest) {
        val result = prepareTextAnalyseResult(textExpectation.text, listOf(StatementGroupTextValidatorPreparer))
        val statementGroups = result.additionalParts[PolishAdditionalPartsName.STATEMENT_GROUP.name]

        assertTrue { statementGroups?.isNotEmpty() ?: false }
        assertEquals(textExpectation.expected.size, statementGroups?.size)

        statementGroups?.forEach { assertTrue { it is AwareOfSurroundings<*> } }

        textExpectation.expected.zip((statementGroups as List<*>).map { it as AwareOfSurroundings<*> })
            .forEach { groupPair ->
                val expectedGroup = groupPair.first
                val actualGroup = groupPair.second
                run {
                    val group = actualGroup.base as StatementGroup
                    assertEquals(expectedGroup.items.size, group.items.size)
                    expectedGroup.items.zip(group.items).forEach { groupItemPair ->
                        assertEquals(groupItemPair.first, groupItemPair.second.get())
                    }
                }
            }
    }
}