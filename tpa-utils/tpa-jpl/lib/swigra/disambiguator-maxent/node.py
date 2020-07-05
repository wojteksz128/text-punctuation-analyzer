__author__ = 'nika'


class Node(object):
    def __init__(self, _args):
        # nid="11" from="3" to="5" subtrees="1" chosen="false"
        if ("chosen" in _args and _args["chosen"] == "true"):
            self.chosen = True
        else:
            self.chosen = False
        if "nid" in _args:
            self.nid = _args["nid"]
        else:
            self.nid = "00"
        self.disamb = False
        self.inside = None
        self.outside = None
        self.f = None
        self.features = []
        self.probability = None
        self.score = None

    def isChosen(self):
        return self.chosen

    def isDisamb(self):
        return self.disamb

    def setDisamb(self):
        self.disamb = True

    def getID(self):
        return self.nid

    def setProbability(self, _probability):
        self.probability = _probability

    def getProbability(self):
        return self.probability

    def getFeatures(self):
        if self.features:
            return self.features
        return self.calcFeatures()

    def getScore(self, coefficients):
        if self.score:
            return self.score
        else:
            return self.calculateScore(coefficients)