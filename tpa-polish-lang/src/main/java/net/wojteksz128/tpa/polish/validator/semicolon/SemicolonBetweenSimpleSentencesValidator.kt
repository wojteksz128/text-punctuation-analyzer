package net.wojteksz128.tpa.polish.validator.semicolon

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.Sentence
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word
import net.wojteksz128.tpa.text.rule.Rule
import net.wojteksz128.tpa.text.rule.RuleBreak

object SemicolonBetweenSimpleSentencesValidator :
    TextValidator(listOf(SimpleSentenceMayHaveSemicolonAtTheEndRule))

object SimpleSentenceMayHaveSemicolonAtTheEndRule : Rule {

    override fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak> {
        val sentences = analyseData.additionalParts[SENTENCE_GROUP.name]?.map { it as Sentence } ?: listOf()

        return sentences.filter { !markAfter(";", it.lastWord) }
            .map { RuleBreak(this, it.lastWord, analyseData) }
    }

    override fun prepareSolution(ruleBreak: RuleBreak): PossibleChange {
        @Suppress("UNCHECKED_CAST") val lastWord = ruleBreak.textPart as AwareOfSurroundings<Word>
        return PossibleChange(ChangeType.INSERT, lastWord.endAt.inc(), new = ";")
    }
}
