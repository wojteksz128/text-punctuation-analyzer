package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.isAnyClassOf
import net.wojteksz128.tpa.polish.validator.isTypeOf
import net.wojteksz128.tpa.polish.validator.prepare.PolishAdditionalPartsName.SENTENCE_GROUP
import net.wojteksz128.tpa.text.TextValidatorPreparer
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word
import net.wojteksz128.tpa.utils.dag.grammar.Klasa
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

object SentenceGroupValidatorPreparer : TextValidatorPreparer {
    override fun prepare(analyseData: TextAnalyseData) {
        val processData = SentenceGroupingProcessData()

        analyseData.words.forEach { assignWordIntoSentence(it, processData) }
        processPotentiallyLastSentence(processData)

        analyseData.additionalParts[SENTENCE_GROUP.name] = processData.sentences.toList()
    }

    private fun assignWordIntoSentence(word: AwareOfSurroundings<Word>, processData: SentenceGroupingProcessData) {
        if (isProbablyStatementWord(word)) {
            processWithStatementWord(processData, word)
        } else {
            if (!processData.sentenceBuilder.isStatementExists()) {
                processData.insertSubjectWordIntoSentence(word)
            } else {
                if (isCurrentSentenceFill(processData)) {
                    processData.insertSentenceIntoSentencesList()
                    processData.insertSubjectWordIntoSentence(word)
                } else {
                    processData.insertComplementWordIntoSentence(word)
                }
            }
        }
    }

    private fun isProbablyStatementWord(word: AwareOfSurroundings<Word>) =
        word.base isTypeOf PartOfSpeech.VERB && !word.base.isAnyClassOf(
            Klasa.IM_PRZYM_BIERNY, Klasa.IM_PRZYM_CZYNNY
        )

    private fun processWithStatementWord(processData: SentenceGroupingProcessData, word: AwareOfSurroundings<Word>) {
        if (processData.sentenceBuilder.isStatementExists()) {
            processData.insertSentenceIntoSentencesList()
        }
        processData.insertStatementWordIntoSentence(word)
    }

    private fun isCurrentSentenceFill(processData: SentenceGroupingProcessData) =
        processData.dependencyMap.isEmpty() && processData.sentenceBuilder.complementWords.isNotEmpty()

    private fun processPotentiallyLastSentence(processData: SentenceGroupingProcessData) {
        if (!processData.sentenceBuilder.isStatementExists()) {
            processData.assignLastWordsIntoPreviousSentence()
        } else {
            processData.applySentenceIntoSentencesList()
        }
    }
}
