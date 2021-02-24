package net.wojteksz128.tpa.polish.validator.comma

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.comma.rule.Rule
import net.wojteksz128.tpa.polish.validator.isTypeOf
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.text.TextValidator
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

// TODO: 31.01.2021 change to tpa-core rule objects
object CommaAsSentencesSeparatorValidator : TextValidator() {
    private val commaRules: Collection<Rule> = listOf(
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("aby").exclude("tak aby")
            .phraseIsNot { it.first().base.isTypeOf(PartOfSpeech.PARTICLE) }
            .build(),// TODO: 09.01.2021 To może nie być do końca poprawne
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("aczkolwiek").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("aż").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("ażeby").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("bo").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("bowiem").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("by").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("chociaż").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("choć").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("chyba że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("co").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("czy").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("dlaczego").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("dlatego").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("dlatego że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("dokąd").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("dopóki").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("gdy").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("gdyby").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("gdyż").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("gdzie").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("ile").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("iż").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jak").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jakby").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jak gdyby").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jaki").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jakkolwiek").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jako").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jako że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jaki").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jeśli").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("jeżeli").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("kiedy").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("kim").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("komu").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("kogo").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("kto").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("którędy").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("który").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("którego").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("mimo iż").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("mimo że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("na co").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("niech").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("nim").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("odkąd").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("o ile").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("po co").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("po czym").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("podczas gdy").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("pomimo iż").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("pomimo że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("ponieważ").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("póki").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("przy czym").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("skąd").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("skoro").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("tak jak").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("tylko że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("tym bardziej że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("w razie gdyby").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("za co").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("zanim").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("zwłaszcza").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("że").build(),
        Rule.Builder().forPunctuationMark(",").markBeforePhrase("żeby").build()
    )

    override fun validate(analyseData: TextAnalyseData): List<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        possibleChanges += findSubordinateSentencesByKeyWords(analyseData)

        return possibleChanges
    }

    // TODO: 29.11.2020 Istnieją zasady stosowania poszczególnych słów kluczowych - trzeba to zaimplementować
    private fun findSubordinateSentencesByKeyWords(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        return commaRules.flatMap { rule -> rule.check(analyseData) }
    }
}