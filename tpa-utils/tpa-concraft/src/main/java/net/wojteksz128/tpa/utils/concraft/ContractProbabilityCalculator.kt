package net.wojteksz128.tpa.utils.concraft

import net.wojteksz128.tpa.TextAnalyseData
import net.wojteksz128.tpa.utils.concraft.TextPartInterpretationModifier.mergeCalculatedIntoExisted
import net.wojteksz128.tpa.utils.concraft.TextPartInterpretationModifier.orderByMostProbablyInterpretation
import net.wojteksz128.tpa.utils.concraft.TextPartInterpretationModifier.splitMergedTags
import net.wojteksz128.tpa.utils.concraft.api.ParseServiceParamConverter.convertResponseToList
import net.wojteksz128.tpa.utils.concraft.api.ParseServiceParamConverter.prepareDagParam

// TODO: 15.11.2020 Prepare test
// TODO: 15.11.2020 solve problem after error response
object ContractProbabilityCalculator {
    fun calculate(analyseData: TextAnalyseData) {
        analyseData.textParts.forEach { splitMergedTags(it) }
        val preparedToInterpretation = analyseData.textParts.flatMap { it.possibleCategories }
        val dagParam = prepareDagParam(preparedToInterpretation)
        val parseCall = ConcraftApi.parseService.parse(dagParam)
        val interpretedDag = convertResponseToList(parseCall.execute().body())
        mergeCalculatedIntoExisted(preparedToInterpretation, interpretedDag)
        analyseData.textParts.forEach { orderByMostProbablyInterpretation(it) }
    }
}
