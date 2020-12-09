package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.text.ChangeType
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator

object CommaAsSentencesSeparatorValidator : TextValidator {

    val split = "aby, aczkolwiek, aż, ażeby, bo, bowiem, by, chociaż, choć, chyba że, co," +
            " czy, dlaczego, dlatego, dlatego że, dokąd, dopóki, gdy, gdyby, gdyż, gdzie, ile, iż, jak, jakby, " +
            "jak gdyby, jaki, jakkolwiek, jako, jako że, jaki, jeśli, jeżeli, kiedy, kim, komu, kogo, kto, którędy, " +
            "który, mimo iż, mimo że, na co, niech, nim, odkąd, o ile, po co, po czym, podczas gdy, pomimo iż, " +
            "pomimo że, ponieważ, póki, przy czym, skąd, skoro, tak jak, tylko że, tym bardziej że, w razie gdyby, " +
            "za co, zanim, zwłaszcza, że, żeby".split(", ")
    val wordsInjectingSubordinateSentence = split.map { Regex(".* ($it) .*") }

    override fun validate(text: TextAnalyseResult): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSubordinateSentencesByKeyWords(text)

        return possibleChanges
    }

    // TODO: 29.11.2020 Istnieją zasady stosowania poszczególnych słów kluczowych - trzeba to zaimplementować
    private fun findSubordinateSentencesByKeyWords(text: TextAnalyseResult): Iterable<PossibleChange> {
        val findWordsInList = wordsInjectingSubordinateSentence
            .map { regex ->
                Pair(regex.pattern.replace("\\.\\* *".toRegex(), ""),
                    regex.findAll(text.text).toList().map { it.groups[1]!!.range.first })
            }

        return findWordsInList.flatMap { wordInList -> text.textParts.filter { wordInList.second.contains(it.startAt) } }
            .filter { word -> text.punctuationMarks.find { it.startAt == word.startAt - 2 } == null }/* spacja poprzedzająca przecinek */
            .map { PossibleChange(ChangeType.INSERT, it.startAt - 2, new = ",") }
    }
}