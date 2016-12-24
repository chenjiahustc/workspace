#-*- coding: utf-8 -*-
import wordDivision
import codecs
import os

configs = { "dictpaths":{"posdict":"/sentimentDictionary/posdict.txt",
                         "negdict":"/sentimentDictionary/negdict.txt",
                         "insufficientlyAdvdict":"/sentimentDictionary/insufficientlyAdvdict.txt",
                         "inverseAdvdict":"/sentimentDictionary/inverseAdvdict.txt",
                         "ishAdvdict": "/sentimentDictionary/ishAdvdict.txt",
                         "moreAdvdict": "/sentimentDictionary/moreAdvdict.txt",
                         "mostAdvdict": "/sentimentDictionary/mostAdvdict.txt",
                         "ordinaryAdvdict": "/sentimentDictionary/ordinaryAdvdict.txt",
                         "overAdvdict": "/sentimentDictionary/overAdvdict.txt",
                         "veryAdvdict": "/sentimentDictionary/veryAdvdict.txt",
                         },
            "sentimentweight":{"posworddict":6.0, "negworddict":-6.0},
            "advweigth":{
                         "insufficientlyAdvdict":1.1,
                         "inverseAdvdict":-1.0,
                         "ishAdvdict": 1.2,
                         "moreAdvdict": 1.3,
                         "mostAdvdict": 1.6,
                         "ordinaryAdvdict": 1.2,
                         "overAdvdict": 1.2,
                         "veryAdvdict": 1.4
                        }

            }

class DivisionWord:
    def __init__(self):
        self.posdict = self.get_data(configs["dictpaths"]["posdict"])
        self.negdict = self.get_data(configs["dictpaths"]["negdict"])
        self.insufficientlyAdvdict = self.get_data(configs["dictpaths"]["insufficientlyAdvdict"])
        self.inverseAdvdict = self.get_data(configs["dictpaths"]["inverseAdvdict"])
        self.ishAdvdict = self.get_data(configs["dictpaths"]["ishAdvdict"])
        self.moreAdvdict = self.get_data(configs["dictpaths"]["moreAdvdict"])
        self.mostAdvdict = self.get_data(configs["dictpaths"]["mostAdvdict"])
        self.ordinaryAdvdict = self.get_data(configs["dictpaths"]["ordinaryAdvdict"])
        self.overAdvdict = self.get_data(configs["dictpaths"]["overAdvdict"])
        self.veryAdvdict = self.get_data(configs["dictpaths"]["veryAdvdict"])

    def divContent(self, sent):
        words = list(wordDivision.cut(sent))

        wordslen  = len(words)
        i = 0
        sentimentwords = {}
        sentimentwords["poswords"] = []
        sentimentwords["negwords"] = []
        sentimentwords["insufficientlyAdvdict"] = []
        sentimentwords["inverseAdvdict"] = []
        sentimentwords["ishAdvdict"] = []
        sentimentwords["moreAdvdict"] = []
        sentimentwords["mostAdvdict"] = []
        sentimentwords["ordinaryAdvdict"] = []
        sentimentwords["overAdvdict"] = []
        sentimentwords["veryAdvdict"] = []
        sentimentwords["allwords"] = words

        for i in range(0, wordslen):
            if words[i] in self.posdict:
                sentimentwords["poswords"].append(words[i])
            elif words[i] in self.negdict:
                sentimentwords["negwords"].append(words[i])
            elif words[i] in self.insufficientlyAdvdict:
                sentimentwords["insufficientlyAdvdict"].append(words[i])
            elif words[i] in self.inverseAdvdict:
                sentimentwords["inverseAdvdict"].append(words[i])
            elif words[i] in self.ishAdvdict:
                sentimentwords["ishAdvdict"].append(words[i])
            elif words[i] in self.moreAdvdict:
                sentimentwords["moreAdvdict"].append(words[i])
            elif words[i] in self.mostAdvdict:
                sentimentwords["mostAdvdict"].append(words[i])
            elif words[i] in self.ordinaryAdvdict:
                sentimentwords["ordinaryAdvdict"].append(words[i])
            elif words[i] in self.overAdvdict:
                sentimentwords["overAdvdict"].append(words[i])
            elif words[i] in self.veryAdvdict:
                sentimentwords["veryAdvdict"].append(words[i])
            else:
                pass

        return sentimentwords

    def get_data(self, filepath):
        path = os.path.dirname(os.path.abspath(__file__))
        filepath = path + filepath

        fileHandler = open(filepath)
        data = fileHandler.read()
        if data[:3] == codecs.BOM_UTF8:
            data = data[3:]
        if data[-1] == '\n':
            data = data[:-1]
        _data = data.decode('utf-8').split('\n')
        data = []
        for word in _data:
            if word != u'':
                data.append(word)
        return data