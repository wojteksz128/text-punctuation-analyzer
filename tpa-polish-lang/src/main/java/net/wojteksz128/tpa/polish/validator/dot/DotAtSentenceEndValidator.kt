package net.wojteksz128.tpa.polish.validator.dot

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.Sentence
import net.wojteksz128.tpa.polish.validator.markAfter
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word

object DotAtSentenceEndValidator : TextValidator {

    override fun validate(analyseData: TextAnalyseData): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSentenceWithoutDotAtEnd(analyseData)
        possibleChanges += findIncorrectPlacedDot(analyseData)

        return possibleChanges
    }

    private fun findSentenceWithoutDotAtEnd(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()
        val sentences = analyseData.additionalParts[SENTENCE_GROUP.name]?.map { it as Sentence } ?: listOf()

        sentences.filter { !markAfter(".", it.lastWord) }
            .map { it.lastWord }
            .forEach { lastWord ->
                val replaceNextWord = findRequiredNextWordReplace(lastWord)
                possibleChanges += if (isAfterOtherPunctuationMark(
                        lastWord,
                        analyseData
                    ) || replaceNextWord.containsChange
                ) {
                    val afterWord = lastWord.partsBetweenLaterWord
                    PossibleChange(
                        ChangeType.REPLACE,
                        afterWord.first().startAt,
                        "${afterWord.joinToString("")}${replaceNextWord.old}",
                        ". ${replaceNextWord.new}"
                    )
                } else
                    PossibleChange(ChangeType.INSERT, lastWord.endAt.inc(), new = ".")
            }

        return possibleChanges
    }

    private fun findRequiredNextWordReplace(lastWord: AwareOfSurroundings<Word>): ReplaceStrings {
        return if (lastWord.wordAfter?.text?.first()?.isLowerCase() == true) ReplaceStrings(
            lastWord.wordAfter!!.text.first().toString(),
            lastWord.wordAfter!!.text.first().toUpperCase().toString()
        ) else ReplaceStrings("", "")
    }

    private fun isAfterOtherPunctuationMark(lastWord: AwareOfSurroundings<Word>, analyseData: TextAnalyseData) =
        lastWord.partsBetweenLaterWord.any { sign -> analyseData.languageAlphabet.separators.none { it == sign.text } }

    private fun findIncorrectPlacedDot(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val sentencesObjects = analyseData.additionalParts[SENTENCE_GROUP.name] ?: listOf<Any>()

        return sentencesObjects.map { it as Sentence }
            .flatMap { it.subjectWords + it.statementWord + it.complementWords }
            .dropLast(1)
            .flatMap { it.partsBetweenLaterWord }
            .filter { it.text == "." }
            .map { PossibleChange(ChangeType.DELETE, it.startAt, old = it.text) }
    }

    private data class ReplaceStrings(val old: String, val new: String) {
        val containsChange: Boolean
            get() = old.isNotEmpty() && new.isNotEmpty() && old != new
    }
}
