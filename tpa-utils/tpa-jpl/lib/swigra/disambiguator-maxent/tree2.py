# -*- encoding: utf-8 -*-
__author__ = 'nika'

from disNode import DisNode
from conNode import ConNode


class Tree(object):
    def __init__(self, path_):
        self.path = path_
        self.root = None
        self.disNodes = {} # słownik id:node
        self.conNodes = [] # lista node'ów
        self.conNodesByIndex = {}
        self.chosen_nodes = [] # tu tylko ids
        self.disamb_nodes = [] # tu tylko ids
        self.terminals = []
        self.amisTree = None

    def show(self):
        for node in self.disNodes:
            self.disNodes[node].show()

    def getAmisTree(self):
        if not self.amisTree:
            self.amisTree = self.root.showAmisTree()
        return self.amisTree

    def getAmisFeatures(self):
        if not self.amisTree:
            self.amisTree = self.root.showAmisTree()
        features = []
        for feature in set(self.amisTree.split(" ")):
            if feature and feature[0] == "f":
                features.append(feature)
        return set(features)

    def getAmisChosen(self):
        chosen =  []
        for node in self.conNodes:
            if node.chosen:
                for feature in node.GetFeatures():
                    chosen.append(feature)
        chosen_encoded = "1"
        for feature in set(chosen):
            chosen_encoded += " " + feature
        return chosen

    def disamb(self, coef):
        self.root.getScore(coef)
        self.root.markDisamb()
        for node in self.disNodes:
            if self.disNodes[node].disamb:
                self.disamb_nodes.append(node)

    def getStats(self):
        # (#(chosen^disamb), #chosen, #disamb)self.no_of_nonterminals(list(set(self.chosen_nodes) & set(self.disamb_nodes))), \
        #print self.no_of_nonterminals(list(set(self.chosen_nodes) & set(self.disamb_nodes))), self.no_of_nonterminals(self.chosen_nodes), self.no_of_nonterminals(self.disamb_nodes)
        return self.no_of_nonterminals(list(set(self.chosen_nodes) & set(self.disamb_nodes))), \
               self.no_of_nonterminals(self.chosen_nodes), self.no_of_nonterminals(self.disamb_nodes)

    def hasRoot(self):
        if self.root:
            return True
        else:
            return False

    def getRoot(self):
        return self.root

    def addDisNode(self, _args):
        node = DisNode(_args)
        if not self.hasRoot():
            self.root = node
        self.disNodes[node.getId()] = node
        return node

    def addConNode(self, _args):
        node = ConNode(_args)
        self.conNodes.append(node)
        self.conNodesByIndex[node.nid] = node
        return node

    def addTerminal(self, terminal):
        self.terminals.append(terminal)

    def getTerminals(self):
        return self.terminals

    def updateDisNodes(self):
        for node in self.conNodes:
            node.addAllDisNodes(self.disNodes)

    def getDisNodes(self):
        return self.disNodes

    def getConNodes(self):
        return self.conNodes

    def no_of_nonterminals(self, tree):
        count = 0
        for ii in tree:
            #print self.disNodes[ii].isTerminal(), ii
            if not self.disNodes[ii].isTerminal():
                count += 1
        return count

    def getEvaluationStats(self):
        by_span = []
        agreed = 0
        for node1 in self.chosen_nodes:
            agreed_tmp = agreed
            for node2 in self.disamb_nodes:
                if self.disNodes[node1].equals_from_to_cat(self.disNodes[node2]) and not self.disNodes[node1].isTerminal():
                    agreed += 1
                    by_span.append((self.disNodes[node1].to - self.disNodes[node1].fro, 1))
                    break
            if (agreed == agreed_tmp):
               by_span.append((self.disNodes[node1].to - self.disNodes[node1].fro, 0))
        self.agreed_count = agreed
        agreed = 0
        by_span_strict = []
        for node1 in self.chosen_nodes:
            agreed_tmp = agreed
            for node2 in self.disamb_nodes:
                if self.disNodes[node1].equals(self.disNodes[node2]) and not self.disNodes[node1].isTerminal():
                    agreed += 1
                    by_span_strict.append((self.disNodes[node1].to - self.disNodes[node1].fro, 1))
                    break
            if (agreed == agreed_tmp):
               by_span_strict.append((self.disNodes[node1].to - self.disNodes[node1].fro, 0))
        self.agreed_strict_count = agreed
        self.chosen_nodes_count = self.no_of_nonterminals(self.chosen_nodes)
        self.disamb_nodes_count = self.no_of_nonterminals(self.disamb_nodes)
        
        try:
            self.chosen_dep_nodes = self.get_dep_tree(self.chosen_nodes)
            self.disamb_dep_nodes = self.get_dep_tree(self.disamb_nodes)
            #print "***********", self.chosen_dep_nodes, self.disamb_dep_nodes
            dep_intersection = len(list(set(self.chosen_dep_nodes) & set(self.disamb_dep_nodes)))
        except:
            self.disamb_dep_nodes = []
            dep_intersection = 0
            print "error in", self.path
        return self.agreed_count, self.agreed_strict_count, self.chosen_nodes_count, self.disamb_nodes_count, len(self.disamb_dep_nodes), dep_intersection, len(self.terminals), by_span, by_span_strict


    def childIsChosen(self, child, tree):
        is_chosen = True
        #print child.disNodesIndexes
        for nid in child.disNodesIndexes:
            if nid[0] not in tree:
                is_chosen = False
        return is_chosen

    def get_centres(self, tree_from, chosen_tree_centres, deps, node_id):
        node = self.disNodes[node_id]
        if node.nid in tree_from:
            if node.getTo() - node.getFrom() == 1:
		        chosen_tree_centres[node_id] = node.getTo()
            for child in node.conNodes:
                    if self.childIsChosen(child, tree_from):
                        self.get_centres(tree_from, chosen_tree_centres, deps, child.getHeadId())
                        chosen_tree_centres[node_id] = chosen_tree_centres[child.getHeadId()]
                        for nid in child.disNodesIndexes:
                            if nid[0] != child.getHeadId():
                                self.get_centres(tree_from, chosen_tree_centres, deps, nid[0])
                                deps.append((nid[0], node_id))

    def get_dep_tree(self, tree_from):
        chosen_tree_centres = {'sID':0}                    # tu będzie nid:najbl.centrum
        deps = [(self.root.getID(),'sID')]
        self.get_centres(tree_from, chosen_tree_centres, deps, self.root.getID())
        return map(lambda x: (chosen_tree_centres[x[0]], chosen_tree_centres[x[1]]), deps)

    def getDisambNodes(self):
        return self.disamb_nodes
