package net.wojteksz128.tpa.polish.validator.prepare

import net.wojteksz128.tpa.polish.validator.Sentence
import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

internal data class SentenceGroupingProcessData(
    val sentences: MutableList<Sentence> = mutableListOf(),
    val dependencyMap: MutableMap<PartOfSpeech, MutableList<AwareOfSurroundings<Word>>> = mutableMapOf(),
    var previousSentenceBuilder: Sentence.Builder? = null,
    var sentenceBuilder: Sentence.Builder = Sentence.Builder()
) {

    internal fun insertSubjectWordIntoSentence(word: AwareOfSurroundings<Word>) {
        sentenceBuilder.subjectWord(word)
    }

    internal fun insertStatementWordIntoSentence(word: AwareOfSurroundings<Word>) {
        sentenceBuilder.statementWord(word)
    }

    internal fun insertComplementWordIntoSentence(word: AwareOfSurroundings<Word>) {
        sentenceBuilder.complementWord(word)
        fillPreviousWordsDependency(this, word)
        insertDependenciesFromWordGrammarClass(word, this)
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

    internal fun assignLastWordsIntoPreviousSentence() {
        removeLastSentenceIfExists()
        copyWordsIntoPreviousSentence()
    }

    internal fun insertSentenceIntoSentencesList() {
        applySentenceIntoSentencesList()
        previousSentenceBuilder = sentenceBuilder
        sentenceBuilder = Sentence.Builder()
    }

    internal fun applySentenceIntoSentencesList() {
        val sentence = sentenceBuilder.build()
        sentences.add(sentence)
    }

    private fun removeLastSentenceIfExists() {
        if (sentences.isNotEmpty()) {
            sentences.remove(sentences.last())
        }
    }

    private fun copyWordsIntoPreviousSentence() {
        previousSentenceBuilder?.run {
            this.complementWords.addAll(sentenceBuilder.subjectWords)
            sentences.add(build())
        }
    }
}