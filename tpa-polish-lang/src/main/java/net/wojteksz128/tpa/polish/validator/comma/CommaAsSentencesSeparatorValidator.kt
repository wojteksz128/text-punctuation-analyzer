package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.comma.rule.CommaBeforeWordsRule
import net.wojteksz128.tpa.polish.validator.comma.rule.CommaRule
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator

object CommaAsSentencesSeparatorValidator : TextValidator {
    // TODO: 10.12.2020 Zamień na wczytywanie jsona z konfiguracją
    private val rules: Collection<CommaRule> = listOf(
        CommaBeforeWordsRule("aby"),
        CommaBeforeWordsRule("aczkolwiek"),
        CommaBeforeWordsRule("aż"),
        CommaBeforeWordsRule("ażeby"),
        CommaBeforeWordsRule("bo"),
        CommaBeforeWordsRule("bowiem"),
        CommaBeforeWordsRule("by"),
        CommaBeforeWordsRule("chociaż"),
        CommaBeforeWordsRule("choć"),
        CommaBeforeWordsRule("chyba że"),
        CommaBeforeWordsRule("co"),
        CommaBeforeWordsRule("czy"),
        CommaBeforeWordsRule("dlaczego"),
        CommaBeforeWordsRule("dlatego"),
        CommaBeforeWordsRule("dlatego że"),
        CommaBeforeWordsRule("dokąd"),
        CommaBeforeWordsRule("dopóki"),
        CommaBeforeWordsRule("gdy"),
        CommaBeforeWordsRule("gdyby"),
        CommaBeforeWordsRule("gdyż"),
        CommaBeforeWordsRule("gdzie"),
        CommaBeforeWordsRule("ile"),
        CommaBeforeWordsRule("iż"),
        CommaBeforeWordsRule("jak"),
        CommaBeforeWordsRule("jakby"),
        CommaBeforeWordsRule("jak gdyby"),
        CommaBeforeWordsRule("jaki"),
        CommaBeforeWordsRule("jakkolwiek"),
        CommaBeforeWordsRule("jako"),
        CommaBeforeWordsRule("jako że"),
        CommaBeforeWordsRule("jaki"),
        CommaBeforeWordsRule("jeśli"),
        CommaBeforeWordsRule("jeżeli"),
        CommaBeforeWordsRule("kiedy"),
        CommaBeforeWordsRule("kim"),
        CommaBeforeWordsRule("komu"),
        CommaBeforeWordsRule("kogo"),
        CommaBeforeWordsRule("kto"),
        CommaBeforeWordsRule("którędy"),
        CommaBeforeWordsRule("który"),
        CommaBeforeWordsRule("mimo iż"),
        CommaBeforeWordsRule("mimo że"),
        CommaBeforeWordsRule("na co"),
        CommaBeforeWordsRule("niech"),
        CommaBeforeWordsRule("nim"),
        CommaBeforeWordsRule("odkąd"),
        CommaBeforeWordsRule("o ile"),
        CommaBeforeWordsRule("po co"),
        CommaBeforeWordsRule("po czym"),
        CommaBeforeWordsRule("podczas gdy"),
        CommaBeforeWordsRule("pomimo iż"),
        CommaBeforeWordsRule("pomimo że"),
        CommaBeforeWordsRule("ponieważ"),
        CommaBeforeWordsRule("póki"),
        CommaBeforeWordsRule("przy czym"),
        CommaBeforeWordsRule("skąd"),
        CommaBeforeWordsRule("skoro"),
        CommaBeforeWordsRule("tak jak"),
        CommaBeforeWordsRule("tylko że"),
        CommaBeforeWordsRule("tym bardziej że"),
        CommaBeforeWordsRule("w razie gdyby"),
        CommaBeforeWordsRule("za co"),
        CommaBeforeWordsRule("zanim"),
        CommaBeforeWordsRule("zwłaszcza"),
        CommaBeforeWordsRule("że"),
        CommaBeforeWordsRule("żeby")
    )

    override fun validate(analyseData: TextAnalyseData): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSubordinateSentencesByKeyWords(analyseData)

        return possibleChanges
    }

    // TODO: 29.11.2020 Istnieją zasady stosowania poszczególnych słów kluczowych - trzeba to zaimplementować
    private fun findSubordinateSentencesByKeyWords(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        return rules.flatMap { rule -> rule.check(analyseData) }
    }
}