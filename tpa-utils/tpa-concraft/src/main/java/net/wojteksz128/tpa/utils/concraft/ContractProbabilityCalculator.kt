package net.wojteksz128.tpa.utils.concraft

import net.wojteksz128.tpa.TextAnalyseResult
import net.wojteksz128.tpa.utils.concraft.api.ParseServiceParamConverter.convertResponseToList
import net.wojteksz128.tpa.utils.concraft.api.ParseServiceParamConverter.prepareDagParam
import net.wojteksz128.tpa.utils.dag.TextPartInterpretation

// TODO: 15.11.2020 Prepare test
// TODO: 15.11.2020 solve problem after error response
object ContractProbabilityCalculator {
    fun calculate(result: TextAnalyseResult) {
        val preparedToInterpretation = result.textParts.flatMap { it.possibleCategories }
        val dagParam = prepareDagParam(preparedToInterpretation)
        val parseCall = ConcraftApi.parseService.parse(dagParam)
        val interpretedDag = convertResponseToList(parseCall.execute().body())
        mergeCalculatedIntoExisted(preparedToInterpretation, interpretedDag)
    }

    private fun mergeCalculatedIntoExisted(preparedToInterpretation: List<TextPartInterpretation>, interpretedDag: List<TextPartInterpretation>?) {
        interpretedDag?.forEach { interpreted ->
            preparedToInterpretation.find { it similar interpreted }
                    ?.apply {
                        this.textPartSpecification.probability = interpreted.textPartSpecification.probability
                        this.textPartSpecification.endOfSentence = interpreted.textPartSpecification.endOfSentence
                    }
        }
    }
}

private infix fun TextPartInterpretation.similar(other: TextPartInterpretation) = this.nodeInfo.startNode == other.nodeInfo.startNode
        && this.nodeInfo.endNode == other.nodeInfo.endNode
        && this.textPartSpecification.orth == other.textPartSpecification.orth
        && this.textPartSpecification.lemma == other.textPartSpecification.lemma
        && this.textPartSpecification.tag == other.textPartSpecification.tag
        && this.textPartSpecification.name == other.textPartSpecification.name
