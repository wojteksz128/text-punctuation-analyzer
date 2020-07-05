#! /usr/bin/python
# -*- encoding: utf-8 -*-
__author__ = 'nika'

from xml.sax import make_parser
from treeparser2 import TreeParser
import glob
from multiprocessing import Pool
import os
#from sklearn.cross_validation import KFold
import sys
import pickle

import argparse
import conNode

argparser = argparse.ArgumentParser(description='Trains maxent model on Składnica')
argparser.add_argument('-f', '--features',
                       help='selected feature sets: ' + conNode.feature_help +
                       'all – all defined features',
                       type=lambda s: [str(item) for item in s.split(',')],
                       default=['all'])
argparser.add_argument('-c','--cores',
                       help='number of CPU cores used (30)',
                       type=int,
                       default=30)
argparser.add_argument('--amis',
                       help='path to amis executable (./amis)',
                       default='./amis')
argparser.add_argument('corpuspath', help="root of the directory tree of Składnica")
args = argparser.parse_args()

args.features = conNode.ConNode.SelectFeatures(args.features)

print("Training model on {} using features {}"
      .format(args.corpuspath, args.features))


def makeTree(f):
    parser = make_parser()
    handler = TreeParser(f)
    parser.setContentHandler(handler)
    parser.parse(f)
    tree = handler.getTree()
    return tree


def makeTrees(allFiles):
    pool = Pool(args.cores)
    trees = pool.map(makeTree, allFiles)
    #trees = map(lambda x: makeTree(x), allFiles)
    return trees


def score(input):
    file, coeffs = input
    tree = makeTree(file)
    tree.disamb(coeffs)
    stats = tree.getEvaluationStats()
    return stats

def prepareAmis(file):
	tree = makeTree(file)
	ret = tree.path, tree.getAmisChosen(), tree.getAmisTree(), tree.getAmisFeatures()
	del tree
	return ret


def Train(train):
    f_init = open("Init.txt", "w")
    f_events = open("Events.txt", "w")

    print "\nPreparing Amis training data (events file)...\n"
    features = set([])
    pool = Pool(args.cores)
    amis_list = pool.map(prepareAmis, train)
    #amis_list = map(lambda x: prepareAmis(x), train)
    for amis in amis_list:
        path, amis_chosen, amis_tree, amis_features = amis
        f_events.write(path + "\n")
        f_events.write("1")
        for feature in amis_chosen:
            f_events.write(" " + str(feature.__repr__()[2:-1]))
        f_events.write("\n")
        f_events.write(amis_tree.__repr__()[2:-1] + "\n")
        f_events.write("\n")
        features.update(amis_features)
    print "\nPreparing Amis features (init file)...\n"
    for feature in sorted(features):
        f_init.write(feature.__repr__()[2:-1] + "    1.0\n")

    f_init.close()
    f_events.close()

    print "\nCalculating coefficients...\n"
    os.system(args.amis + " skladnica.config")

    f = open("Skladnica_params.output")
    coeffs = {}
    for line in f.readlines():
        l = line.split()
        coeffs[l[0]] = float(l[1])
    model = {"features": args.features, "coeffs": coeffs}
    pickle.dump(model, open('models/coeffs-new.pkl', 'w'))
    

############################# main ###################################


all_files = []
for f in glob.iglob(os.path.join(args.corpuspath,"*/*/*.xml")):
    all_files.append(f)
#all_files = all_files[100:200]
print("Number of files: {}".format(len(all_files)))

Train(all_files)
