package net.wojteksz128.tpa.polish.validator

import net.wojteksz128.tpa.text.part.AwareOfSurroundings
import net.wojteksz128.tpa.text.part.Word

class Sentence private constructor(
    val subjectWords: List<AwareOfSurroundings<Word>>,
    val statementWord: AwareOfSurroundings<Word>,
    val complementWords: List<AwareOfSurroundings<Word>>
) {

    val lastWord: AwareOfSurroundings<Word>
        get() = complementWords.lastOrNull() ?: statementWord

    data class Builder(
        val subjectWords: MutableList<AwareOfSurroundings<Word>> = mutableListOf(),
        var statementWord: AwareOfSurroundings<Word>? = null,
        val complementWords: MutableList<AwareOfSurroundings<Word>> = mutableListOf()
    ) {

        fun subjectWord(word: AwareOfSurroundings<Word>) = apply { this.subjectWords.add(word) }
        fun isStatementExists() = this.statementWord != null
        fun statementWord(word: AwareOfSurroundings<Word>) = apply { this.statementWord = word }
        fun complementWord(word: AwareOfSurroundings<Word>) = apply { this.complementWords.add(word) }
        fun build() = statementWord?.let { Sentence(subjectWords, it, complementWords) }
            ?: throw IllegalStateException("Sentence cannot be without statement.")
    }
}