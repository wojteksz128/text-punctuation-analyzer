#! /usr/bin/python
# -*- encoding: utf-8 -*-

__author__ = 'nika'

from xml.sax import make_parser
from treeparser2 import TreeParser
import glob
#from multiprocessing import Pool
import os
import sys
import xml.dom.minidom
import codecs
import pickle
from conNode import ConNode


try:
    f = sys.argv[1]
except IndexError:
    print("ERROR: no filename given")
    exit()

# parse xml file for future processing
dom = xml.dom.minidom.parse(sys.argv[1])
nodes = dom.getElementsByTagName("node")

if nodes: # if there is anything to disambiguate
    # load grammar
    model = pickle.load(open("models/default.pkl"))
    #model = pickle.load(open("models/coeffs-170323.pkl"))
    #
    # the same set of features as used for training get activated:
    ConNode.SelectFeatures(model["features"])
    # print(model["features"])
    #
    # make parser, parse tree
    parser = make_parser()
    handler = TreeParser(f)
    parser.setContentHandler(handler)
    parser.parse(f)
    tree = handler.getTree()
    # disambiguation
    tree.disamb(model["coeffs"])
    disamb_nodes = tree.getDisambNodes()

# update chosen nodes (if any)
for node in nodes:
    if node.attributes["nid"].value in disamb_nodes:
        node.attributes["chosen"] = "true"
        children_all = node.getElementsByTagName("children")
        for children in children_all:
            chosen = True
            for child in children.getElementsByTagName("child"):
                if child.attributes["nid"].value not in disamb_nodes:
                    chosen = False
            if chosen:
                children.attributes["chosen"] = "true"
    else:
        node.attributes["chosen"] = "false"

new_f = sys.argv[1].rsplit(".", 1)[0] + "-disamb.xml"
#print "saving in :", new_f
open(new_f, 'w').write(codecs.encode(dom.toxml(), 'utf-8'))

