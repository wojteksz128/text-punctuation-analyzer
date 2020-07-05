# -*- encoding: utf-8 -*-

__author__ = 'nika'

from node import Node
#from numpy import exp
#import numpy as np

class DisNode(Node):
    def __init__(self, _args):
        # nid="11" from="3" to="5" subtrees="1" chosen="false"
        super(DisNode, self).__init__(_args)
        self.nid = _args["nid"]
        self.fro = int(_args["from"])
        self.to = int(_args["to"])
        self.subtress = int(_args["subtrees"])
        self.terminal = False
        self.nonterminal = False
        self.arguments = {}
        self.category = u'terminal' # defaults to be a terminal
        self.conNodes = [] # list of conjunctive nodes
        self.conNodesIndexes = [] # list of conjunctive nodes (indexes)
        self.parents = []
        self.amisTree = None

    def show(self):
        print "disNode", self.nid
        for node in self.conNodes:
            print "    conNode", node.getFeatures(),
            #for node1 in node.getConNodes(): # dis nodes?
            #    print node1[0].getId(),
            #print
        print

    def showAmisTree(self):
        #print "dis", len(self.conNodes)
        if self.amisTree:
            return "$d" + self.nid
        else:
            return self.GetAmisTree()

    def GetAmisTree(self):
        if self.isTerminal():
            self.amisTree = ""
        else:
            self.amisTree = "{ d" + self.nid + " "
            for conNode in self.conNodes:
                self.amisTree += conNode.showAmisTree() + " "
            self.amisTree += "}"
        return self.amisTree

    def calculateScore(self, coefficients):
        if self.isTerminal():
            self.score = 1.0
        else:
            self.score = max(map(lambda x: x.getScore(coefficients), self.conNodes))
        return self.score

    def markDisamb(self):
        self.disamb = True
        disamb = 0
        for con_node in self.conNodes:
            if con_node.score == self.score:
                if disamb == 0:
                    con_node.markDisamb()
                    disamb += 1
                else:
                    print "too many disamb with highest score", con_node.score
            #else:
            #    print "both scores", con_node.score, self.score


    def getId(self):
        return self.nid

    def setTerminal(self):
        self.terminal = True

    def isTerminal(self):
        return self.terminal

    def setNonterminal(self):
        self.nonterminal = True

    def setCategory(self, _category):
        self.category = _category

    def getCategory(self):
        return self.category

    def getCategoryTFW(self):
        cat = unicode(self.category)
        if self.category == "fw" or self.category == u"ξ":
            cat += '(' + unicode(self.arguments['tfw'].replace(",", ".").replace(" ", "_")) + ')'
        return cat

    def getCategoryDetailed(self):
        cat = unicode(self.category)
        if self.category == "fw":
            cat += '(' + unicode(self.arguments['tfw'].replace(",", ".").replace(" ", "_")) + ')'
        elif self.category == "zdanie" or self.category == "ff":
            cat += '(' + unicode(self.arguments[u'wyróżnik'].replace(":","")) \
                   + '.' + unicode(self.arguments[u'tryb'].replace(":","")) + ')'
        elif self.category == "fpm":
            cat += '(' + unicode(self.arguments[u'przyim'].replace(" ", "_")) \
                   + '.' + unicode(self.arguments[u'przypadek']) + ')'
        return cat

    def addArgument(self, argName, argVal):
        self.arguments[argName] = argVal

    def getArgVal(self, argName):
        return self.arguments[argName]

    def getArguments(self):
        return self.arguments

    def hasArgument(self, arg):
        return arg in self.arguments.keys()

    def addParent(self, parent):
        self.parents.append(parent)

    def getParents(self):
        return self.parents

    def addConNode(self, node):    # tutaj dodajemy obiekty, nie indeksy (bo wystarczy przy parsowaniu)
        self.conNodes.append(node)
        node.setParent(self)

    def getConNodes(self):
        return self.conNodes

    def getFrom(self):
        return self.fro

    def getTo(self):
        return self.to

    def equals(self, node):
        equal = True
        #print self.arguments, node.arguments
        for arg in self.arguments.keys():
            if arg in node.arguments.keys():
                if not self.arguments[arg] == node.arguments[arg]:
                    equal = False
                    break
            else:
                equal = False
                break
        return equal and self.equals_from_to_cat(node)

    def equals_from_to_cat(self, node):
        return self.getFrom() == node.getFrom() and self.getTo() == node.getTo() and self.getCategory() == node.getCategory()
