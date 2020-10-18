package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.polish.validator.StatementGroup
import net.wojteksz128.tpa.polish.validator.TextValidationUtils.prepareTextAnalyseResult
import net.wojteksz128.tpa.polish.validator.utils.Group
import net.wojteksz128.tpa.polish.validator.utils.JsonFileSource
import net.wojteksz128.tpa.polish.validator.utils.TextExpectationTest
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
    @JsonFileSource<Group>(resources = ["/statementGroupsPreparer/statement_groups.json"])
    fun `Text with only verb have one statement group`(textExpectation: TextExpectationTest) {
        val result = prepareTextAnalyseResult(textExpectation.text, listOf(StatementGroupTextValidatorPreparer))
        val statementGroups = result.additionalParts[PolishAdditionalPartsName.STATEMENT_GROUP.name]

        assertTrue { statementGroups?.isNotEmpty() ?: false }
        assertEquals(textExpectation.expected.size, statementGroups?.size)

        statementGroups?.forEach { assertTrue { it is StatementGroup } }

        textExpectation.expected.zip((statementGroups as List<*>).map { it as StatementGroup }).forEach { groupPair ->
            val expectedGroup = groupPair.first
            val actualGroup = groupPair.second
            run {
                assertEquals(expectedGroup.items.size, actualGroup.items.size)
                expectedGroup.items.zip(actualGroup.items).forEach { groupItemPair ->
                    assertEquals(groupItemPair.first, groupItemPair.second.get())
                }
            }
        }
    }
}