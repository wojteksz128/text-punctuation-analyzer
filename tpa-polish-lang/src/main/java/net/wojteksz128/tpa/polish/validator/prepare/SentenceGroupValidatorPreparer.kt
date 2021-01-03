package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.Sentence
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
            insertStatementWordIntoSentence(processData, word)
        } else {
            if (!processData.sentenceBuilder.isStatementExists()) {
                insertSubjectWordIntoSentence(processData, word)
            } else {
                if (isCurrentSentenceFill(processData)) {
                    insertSentenceIntoSentencesList(processData)
                    insertSubjectWordIntoSentence(processData, word)
                } else {
                    insertComplementWordIntoSentence(processData, word)
                }
            }
        }
    }

    private fun isProbablyStatementWord(word: AwareOfSurroundings<Word>) =
        word.base isTypeOf PartOfSpeech.VERB && !word.base.isAnyClassOf(
            Klasa.IM_PRZYM_BIERNY, Klasa.IM_PRZYM_CZYNNY
        )

    private fun insertStatementWordIntoSentence(
        processData: SentenceGroupingProcessData,
        word: AwareOfSurroundings<Word>
    ) {
        if (processData.sentenceBuilder.isStatementExists()) {
            insertSentenceIntoSentencesList(processData)
        }
        processData.sentenceBuilder.statementWord(word)
    }

    private fun isCurrentSentenceFill(processData: SentenceGroupingProcessData) =
        processData.dependencyMap.isEmpty() && processData.sentenceBuilder.complementWords.isNotEmpty()

    private fun insertSentenceIntoSentencesList(processData: SentenceGroupingProcessData) {
        addSentenceIntoSentencesList(processData)
        processData.previousSentenceBuilder = processData.sentenceBuilder
        processData.sentenceBuilder = Sentence.Builder()
    }

    private fun insertSubjectWordIntoSentence(
        processData: SentenceGroupingProcessData,
        word: AwareOfSurroundings<Word>
    ) {
        processData.sentenceBuilder.subjectWord(word)
    }

    private fun insertComplementWordIntoSentence(
        processData: SentenceGroupingProcessData,
        word: AwareOfSurroundings<Word>
    ) {
        processData.sentenceBuilder.complementWord(word)
        fillPreviousWordsDependency(processData, word)
        insertDependenciesFromWordGrammarClass(word, processData)
    }

    private fun fillPreviousWordsDependency(processData: SentenceGroupingProcessData, word: AwareOfSurroundings<Word>) {
        removeWordsWithFilledDependency(processData, word)
        removeEmptyElementsFromDependencyMap(processData)
    }

    private fun removeWordsWithFilledDependency(
        processData: SentenceGroupingProcessData,
        word: AwareOfSurroundings<Word>
    ) {
        processData.dependencyMap[word.possibleCategories.first().textPartSpecification.grammarClass.partOfSpeech]
            ?.let { listOfElementsToRemove ->
                val wordsToRemove = listOfElementsToRemove.toList()
                wordsToRemove.forEach { wordToRemove ->
                    processData.dependencyMap.values.forEach { it.remove(wordToRemove) }
                }
            }
    }

    private fun removeEmptyElementsFromDependencyMap(processData: SentenceGroupingProcessData) {
        processData.dependencyMap.toMap().forEach { (partOfSpeech, wordsDependentToPartOfSpeech) ->
            if (wordsDependentToPartOfSpeech.isEmpty())
                processData.dependencyMap.remove(partOfSpeech)
        }
    }

    private fun insertDependenciesFromWordGrammarClass(
        word: AwareOfSurroundings<Word>,
        processData: SentenceGroupingProcessData
    ) {
        val partOfSpeech = word.possibleCategories.first().textPartSpecification.grammarClass.partOfSpeech
        partOfSpeech.dependsOfSpeech.forEach { processData.dependencyMap.putIfAbsent(it, mutableListOf())?.add(word) }
    }

    private fun processPotentiallyLastSentence(processData: SentenceGroupingProcessData) {
        if (!processData.sentenceBuilder.isStatementExists()) {
            assignLastWordsIntoPreviousSentence(processData)
        } else {
            addSentenceIntoSentencesList(processData)
        }
    }

    private fun assignLastWordsIntoPreviousSentence(processData: SentenceGroupingProcessData) {
        removeLastSentenceIfExists(processData)
        copyWordsIntoPreviousSentence(processData)
    }

    private fun copyWordsIntoPreviousSentence(processData: SentenceGroupingProcessData) {
        processData.previousSentenceBuilder?.run {
            this.complementWords.addAll(processData.sentenceBuilder.subjectWords)
            processData.sentences.add(build())
        }
    }

    private fun removeLastSentenceIfExists(processData: SentenceGroupingProcessData) {
        if (processData.sentences.isNotEmpty()) {
            processData.sentences.remove(processData.sentences.last())
        }
    }

    private fun addSentenceIntoSentencesList(processData: SentenceGroupingProcessData) {
        val sentence = processData.sentenceBuilder.build()
        processData.sentences.add(sentence)
    }
}
