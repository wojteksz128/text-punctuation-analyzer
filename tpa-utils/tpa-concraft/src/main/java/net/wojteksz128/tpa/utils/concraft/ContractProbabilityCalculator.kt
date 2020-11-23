package net.wojteksz128.tpa.utils.concraft

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.utils.concraft.TextPartInterpretationModifier.mergeCalculatedIntoExisted
import net.wojteksz128.tpa.utils.concraft.TextPartInterpretationModifier.orderByMostProbablyInterpretation
import net.wojteksz128.tpa.utils.concraft.TextPartInterpretationModifier.splitMergedTags
import net.wojteksz128.tpa.utils.concraft.api.ParseServiceParamConverter.convertResponseToList
import net.wojteksz128.tpa.utils.concraft.api.ParseServiceParamConverter.prepareDagParam

// TODO: 15.11.2020 Prepare test
// TODO: 15.11.2020 solve problem after error response
object ContractProbabilityCalculator {
    fun calculate(result: TextAnalyseResult) {
        result.textParts.forEach { splitMergedTags(it) }
        val preparedToInterpretation = result.textParts.flatMap { it.possibleCategories }
        val dagParam = prepareDagParam(preparedToInterpretation)
        val parseCall = ConcraftApi.parseService.parse(dagParam)
        val interpretedDag = convertResponseToList(parseCall.execute().body())
        mergeCalculatedIntoExisted(preparedToInterpretation, interpretedDag)
        result.textParts.forEach { orderByMostProbablyInterpretation(it) }
    }
}
