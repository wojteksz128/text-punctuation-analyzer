# -*- encoding: utf-8 -*-

__author__ = 'nika'

from tree2 import Tree
from node import Node
import sys, pickle, os
from xml.sax import make_parser, handler

class TreeParser(handler.ContentHandler):

    def __init__(self, path):
        self.tree = Tree(path)
        self.currentDisNode = None
        self.currentConNode = None
        self.inTerminal = False
        self.currentTag = None
        self.currentArg  = None
        self.terminals = []
        self.content = ""

    def getTree(self):
            return self.tree

    def startElement(self, name, attrs):
        self.currentTag = name
        if name == "node":
            attr_dict = {}
            for name in attrs.getNames():
                attr_dict[name] = attrs.getValue(name)
            self.currentDisNode = self.tree.addDisNode(attr_dict)
            #print "*********", attr_dict
            if "chosen" in attr_dict.keys() and attr_dict["chosen"] == "true":
                self.tree.chosen_nodes.append(attr_dict["nid"])
        elif name == "children":
            attr_dict = {}
            for name in attrs.getNames():
                attr_dict[name] = attrs.getValue(name)
            self.currentConNode = self.tree.addConNode(attr_dict)
            self.currentDisNode.addConNode(self.currentConNode)
        elif name == "child":
            nid = attrs.getValue("nid")
            if attrs.getValue("head") == "true":
                self.currentConNode.addDisNodeIndex(nid, True)
            else:
                self.currentConNode.addDisNodeIndex(nid, False)
        elif name == "terminal":
            self.currentDisNode.setTerminal()
            self.tree.addTerminal(self.currentDisNode)
            self.inTerminal = True
        elif name == "nonterminal":
            self.currentDisNode.setNonterminal()
        elif name == "f":
            self.currentArg = attrs.getValue("type")

    def endElement(self, name):                         # zlicza w zależności od węzła
        if name == "terminal":
            self.inTerminal = False
        elif name == "category":
            #print self.currentDisNode.nid, content
            self.currentDisNode.setCategory( self.content )
        elif name == "f":
            self.currentDisNode.addArgument(self.currentArg, self.content)
        elif name == "orth" and self.inTerminal:
            self.currentDisNode.addArgument("orth", self.content)
        elif name == "base" and self.inTerminal:
            self.currentDisNode.addArgument("base", self.content)
        self.content = ""


    def characters(self, content):
        if content.strip():
            self.content += content
            
    def endDocument(self):
        self.tree.updateDisNodes()
