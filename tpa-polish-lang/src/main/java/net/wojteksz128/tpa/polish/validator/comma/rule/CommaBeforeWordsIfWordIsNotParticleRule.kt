package net.wojteksz128.tpa.polish.validator.comma.rule

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.polish.validator.isTypeOf
import net.wojteksz128.tpa.text.PossibleChange
import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech

// TODO: 27.12.2020 Przygotuj testy
class CommaBeforeWordsIfWordIsNotParticleRule(ruleExpectedText: String) : CommaBeforeWordsRule(ruleExpectedText) {

    override fun check(analyseData: TextAnalyseData): Iterable<PossibleChange> {
        val possibleChanges = mutableListOf<PossibleChange>()

        val foundPatternsWithAndWithoutCommas = findExpectedPatternInData(analyseData)
            .filter { !it.first().base.isTypeOf(PartOfSpeech.PARTICLE) } // TODO: 01.01.2021 To może nie być do końca poprawne
            .groupBy { hasCommaBeforeWord(it) }

        possibleChanges += convertFoundsWithoutCommaIntoPossibleChange(foundPatternsWithAndWithoutCommas[false])
        possibleChanges += findFoundsWithInvalidCommaAndSpaceOrder(foundPatternsWithAndWithoutCommas[true])

        return possibleChanges.toList()
    }
}