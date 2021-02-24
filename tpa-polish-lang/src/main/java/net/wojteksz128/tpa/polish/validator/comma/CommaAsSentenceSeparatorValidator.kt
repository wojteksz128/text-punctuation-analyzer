package net.wojteksz128.tpa.polish.validator.comma

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

object CommaAsSentenceSeparatorValidator :
    TextValidator(listOf(SimpleSentenceMayHaveDotAtTheEndRule, DotInsideSentenceNotPossibleRule))

object SimpleSentenceMayHaveDotAtTheEndRule : Rule {
    override fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak> {
        val sentences = analyseData.additionalParts[SENTENCE_GROUP.name]?.map { it as Sentence } ?: listOf()

        return sentences.filter { !markAfter(",", it.lastWord) }
            .map { RuleBreak(this, it.lastWord, analyseData) }
    }

    override fun prepareSolution(ruleBreak: RuleBreak): PossibleChange {
        @Suppress("UNCHECKED_CAST") val lastWord = ruleBreak.textPart as AwareOfSurroundings<Word>
        return if (isAfterOtherPunctuationMark(lastWord, ruleBreak.analyseData)) {
            val afterWord = lastWord.partsBetweenLaterWord
            PossibleChange(
                ChangeType.REPLACE,
                afterWord.first().startAt,
                afterWord.joinToString(""),
                ", "
            )
        } else
            PossibleChange(ChangeType.INSERT, lastWord.endAt.inc(), new = ",")
    }

    private fun isAfterOtherPunctuationMark(lastWord: AwareOfSurroundings<Word>, analyseData: TextAnalyseData) =
        lastWord.partsBetweenLaterWord.any { sign -> analyseData.languageAlphabet.separators.none { it == sign.text } }
}

object DotInsideSentenceNotPossibleRule : Rule {
    override fun findBreaks(analyseData: TextAnalyseData): Iterable<RuleBreak> {
        val sentencesObjects = analyseData.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()

        return sentencesObjects.map { it as Sentence }
            .flatMap { it.subjectWords + it.statementWord + it.complementWords }
            .dropLast(1)
            .flatMap { it.partsBetweenLaterWord }
            .filter { it.text == "," }
            .map { RuleBreak(this, it, analyseData) }
    }

    override fun prepareSolution(ruleBreak: RuleBreak): PossibleChange {
        return PossibleChange(ChangeType.DELETE, ruleBreak.textPart.startAt, old = ruleBreak.textPart.text)
    }
}
