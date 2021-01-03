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
)