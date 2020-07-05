# -*- encoding: utf-8 -*-
#from numpy import exp
import sys

__author__ = 'nika & marcin'

from node import Node
#import numpy as np

########################################################################
# Buchalteria featur
# byłoby fajniej mieć to wewnątrz klasy, ale nie umiem zrobić z dekoratora metody klasowej ☹

feature_sets = {} # available feature generating functions with tags
                  # used in script options {tag:function,…}
feature_help = "" # string for --help

def feature(tag):
    """dekorator dla metod generujących featury"""
#    print "Register "+tag
    def _decorator(method):
        global feature_sets # :-(
        global feature_help
        feature_sets[tag] = method
        feature_help += tag + ' – ' + method.__doc__+'; '
        return method
    return _decorator
########################################################################

def labelWithHead(disNode):
    if disNode[1]: # is head
        return "@" + disNode[0].getCategory()
    else:
        return disNode[0].getCategory()

def labelWithHeadTFW(disNode):
    if disNode[1]: # is head
        return "@" + disNode[0].getCategoryTFW() 
    else:
        return disNode[0].getCategoryTFW()

def labelWithHeadDetailed(disNode):
    if disNode[1]: # is head
        return "@" + disNode[0].getCategoryDetailed()
    else:
        return disNode[0].getCategoryDetailed()

def label(disNode):
    return disNode[0].getCategory()

def labelTFW(disNode):
    return disNode[0].getCategoryTFW()

def isHead(disNode):
    return disNode[1]

class ConNode(Node):
    features_used = [] # feature generators used in this run of the program

    @classmethod
    def SelectFeatures(cls, tags):
        global feature_sets
        if 'all' in tags:
            cls.features_used=feature_sets.values()
            return feature_sets.keys()
        else:
            try:
                cls.features_used=[feature_sets[tag] for tag in tags]
            except KeyError:
                print("ERROR: wrong features "+str(tags))
                exit(1)
            return tags

    def __init__(self, _args):
        # nid="11" from="3" to="5" subtrees="1" chosen="false"
        super(ConNode, self).__init__(_args)
        self.rule = _args["rule"]
        self.disNodes = [] # list of disjunctive nodes
        self.disNodesIndexes = [] # list of disjunctive nodes (indexes) - tuple: (id, isHead)
        self.parent = None
        self.hash = None
        self.amisTree = None

    def show(self):
        print self.getHash()

    def showAmisTree(self):
        return self.GetAmisTree()

    def GetAmisTree(self):
        self.amisTree = "( _ " + " ".join(self.GetFeatures()) + " " # label of form f-S-NP_VP
        for disNode in self.disNodes:
            self.amisTree += (disNode[0].showAmisTree() + " ")
        self.amisTree += ")"
        return self.amisTree

    @feature('con')
    def FeatureProductionWithHead(self):
        """complete rule as in PCFG"""
        return ["fcon_" + self.parent.getCategory() + "->" + ".".join(map(lambda x: labelWithHead(x), self.disNodes))]

    @feature('contfw')
    def FeatureProductionWithHeadTFW(self):
        """complete rule with required phrase types"""
        return ["ftfw_" + self.parent.getCategoryTFW() + "->" + ".".join(map(lambda x: labelTFW(x), self.disNodes))]

    @feature('conset')
    def FeatureLooseOrder(self):
        """complete rule ignoring order of elements """
        return ["fset_" + self.parent.getCategory() + "->" + ";".join(sorted(map(lambda x: labelWithHead(x), self.disNodes)))]

    @feature('consetlen')
    def FeatureProductionSetWithHeadAndCount(self):
        """rule with RHS uniqued and with len(RHS)"""
        return ["fse2_" + self.parent.getCategory() + "->" + ";".join(sorted(list(set(map(lambda x: labelWithHead(x), self.disNodes))))) + "=" + str(len(self.disNodes))]

    @feature('rhslen')
    def FeatureLeftHandSideAndRightHandSideCount(self):
        """rule LHS + len(RHS)"""
        return ["flen_" + self.parent.getCategory() + "=" + str(len(self.disNodes))]

    @feature('svo')
    def FeatureSVO(self):
        """subject/verb/object combinations for zdanie with OO compression"""
        if self.parent.getCategory() == "zdanie":
            feature_name = u'fsvo_'
            for node in self.disNodes:
                if labelTFW(node).startswith("fw(subj"):
                    feature_name += "S"
                elif labelTFW(node).startswith("fw") and feature_name[-1] != "O":
                    feature_name += "O"
                elif labelTFW(node).startswith("ff") and feature_name[-1] != "V":
                    feature_name += "V"
                else:
                    pass
            return [feature_name]
        return []

    @feature('svoo')
    def FeatureSVOO(self):
        """subject/verb/object combinations for zdanie"""
        if self.parent.getCategory() == "zdanie":
            feature_name = u'fsv2_'
            for node in self.disNodes:
                if labelTFW(node).startswith("fw(subj"):
                    feature_name += "S"
                elif labelTFW(node).startswith("fw"):
                    feature_name += "O"
                elif labelTFW(node).startswith("ff"):
                    feature_name += "V"
                else:
                    pass
            return [feature_name]
        return []

    @feature('svoop')
    def FeatureSVOO(self):
        """subject/verb/object/się/posiłk/ξ combinations for zdanie"""
        if self.parent.getCategory() == "zdanie":
            feature_name = u'fsv3_'
            for node in self.disNodes:
                if labelTFW(node).startswith("fw(subj"):
                    feature_name += "S"
                elif labelTFW(node).startswith("fw(sie"):
                    feature_name += "s"
                elif labelTFW(node).startswith(u"ξ"):
                    feature_name += "X"
                elif labelTFW(node).startswith(u"posiłk"):
                    feature_name += "p"
                elif labelTFW(node).startswith("fw"):
                    feature_name += "O"
                elif labelTFW(node).startswith("ff"):
                    feature_name += "V"
                else:
                    pass
            return [feature_name]
        return []

    @feature('lexfl')
    def FeatureLexFL(self):
        """lexical heads for fl"""
        if self.parent.getCategory() == "fl":
            for node in self.disNodes:
                if isHead(node) and node[0].hasArgument('lex'):
                    return ["flxl_" + label(node) + "[" + node[0].getArgVal('lex').replace(' ', '_') + "]"]
        return []

    @feature('lexxp')
    def FeatureLexXP(self):
        """lexical heads for xp"""
        if self.parent.getCategory() == "fw" and self.parent.getArgVal('tfw').startswith('xp'):
            for node in self.disNodes:
                if isHead(node) and node[0].hasArgument('lex'):
                    return ["flxx_" + self.parent.getArgVal('tfw') + ">" + label(node) +
                            "[" + node[0].getArgVal('lex').replace(' ', '_') + "]"]
        return []

    @feature('head')
    def FeatureHead(self):
        """rule LHS + head(RHS)"""
        for dn in self.disNodes:
            if isHead(dn):
                return [ "fhd__" + self.parent.getCategoryTFW() + "->" + labelTFW(dn) ]
        return []

    @feature('headlen')
    def FeatureHead(self):
        """rule LHS + head(RHS) + len(RHS)"""
        for dn in self.disNodes:
            if isHead(dn):
                return [ "fhd2_" + self.parent.getCategoryTFW() + "->" + labelTFW(dn) + "=" + str(len(self.disNodes)) ]
        return [ "fhd2_" + self.parent.getCategoryTFW() + "->=" + str(len(self.disNodes)) ]

    @feature('dep')
    def FeatureDependants(self):
        """rule LHS + one of dependants + head(RHS)"""
        hdpos=0
        for dn in self.disNodes:
            if isHead(dn):
                break
            hdpos += 1
        lhs = "fdep_" + self.parent.getCategoryTFW() + "->"
        if hdpos < len(self.disNodes): # isHead(self.disNodes[hdpos]):
            head = labelWithHeadTFW(self.disNodes[hdpos])
            return map(lambda dn: lhs + labelTFW(dn) + ".." + head, self.disNodes[:hdpos]) + map(lambda dn: lhs + head + ".." + labelTFW(dn), self.disNodes[hdpos+1:])
        else:
            return map(lambda dn: lhs + labelTFW(dn) + "@", self.disNodes)

    @feature('2gram')
    def FeatureBigram(self):
        """bigrams from RHS: cat+Tfw"""
        prev = labelWithHeadTFW(self.disNodes[0])
        feats = []
        for n in self.disNodes[1:]:
            curr = labelWithHeadTFW(n)
            feats.append("f2gt_"+prev+"."+curr)
            prev = curr
        return feats

    @feature('3gram')
    def FeatureBigram(self):
        """trigrams from RHS: cat+Tfw"""
        if len(self.disNodes) < 3:
            return []
        prev1 = labelWithHeadTFW(self.disNodes[0])
        prev2 = labelWithHeadTFW(self.disNodes[1])
        feats = []
        for n in self.disNodes[2:]:
            curr = labelWithHeadTFW(n)
            feats.append("f3gt_"+prev1+"."+prev2+"."+curr)
            prev1 = prev2
            prev2 = curr            
        return feats

    @feature('2grdet')
    def FeatureBigram(self):
        """bigrams from RHS: detailed"""
        prev = labelWithHeadDetailed(self.disNodes[0])
        feats = []
        for n in self.disNodes[1:]:
            curr = labelWithHeadDetailed(n)
            feats.append("f2gd_"+prev+"."+curr)
            prev = curr
        return feats

    def GetFeatures(self):
        ret = []
        for feature_function in self.features_used:
            ret += feature_function(self)
        return ret

    def calculateScore(self, coefficients):
        self.score = 1.0
        for feature in self.GetFeatures():
            if feature in coefficients.keys():
                self.score *= coefficients[feature]
        self.score *= reduce(lambda x, y: x * y, map(lambda x: x[0].getScore(coefficients), self.disNodes))
        return self.score

    def markDisamb(self):
        self.disamb = True
        for node in self.disNodes:
            node[0].markDisamb()

    def addDisNode(self, node, isHead):
        self.disNodes.append( (node, isHead) )
        
    def getHeadId(self):
        for node in self.disNodes:
        	if node[1]: return node[0].nid

    def setParent(self, _parent):
        self.parent = _parent

    def getDisNodes(self):
        return self.disNodes

    def addAllDisNodes(self, nodesDict):
        for nodeIndex, isHead in self.disNodesIndexes:
            self.addDisNode( nodesDict[nodeIndex], isHead )
            nodesDict[nodeIndex].addParent(self)

    def addDisNodeIndex(self, nodeIndex, isHead):
        self.disNodesIndexes.append( (nodeIndex, isHead) )
