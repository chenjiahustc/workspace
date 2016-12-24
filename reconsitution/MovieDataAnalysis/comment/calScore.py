#-*- coding: utf-8 -*-
import codecs
import os
from DivisionWord import DivisionWord
from DivisionWord import configs

class CalScore:
    def __init__(self):
        self.dw = DivisionWord()
    #简单模型
    def sModelcalScore(self, sent_d):
        sentimentwords = self.dw.divContent(sent_d)
        posScore = 0
        negScore = 0
        poswordslen = len(sentimentwords["poswords"])
        negwordslen = len(sentimentwords["negwords"])

        keyword = None
        if poswordslen != 0:
            posScore = configs["sentimentweight"]["posworddict"]
            keyword = sentimentwords["poswords"][0]
            allwords = sentimentwords["allwords"]
            index = allwords.index(keyword)

            for word in sentimentwords["allwords"][0:index]:
                for (k, words) in sentimentwords.items():
                    if k != "allwords" and k != "poswords" and k != "negwords":
                        if word in words:
                            posScore = posScore * configs["advweigth"][k]
            return posScore
        elif negwordslen != 0 :
            negScore = configs["sentimentweight"]["negworddict"]
            keyword = sentimentwords["negwords"][0]
            index = sentimentwords["allwords"].index(keyword)

            for word in sentimentwords["allwords"][0:index]:
                for (k, words) in sentimentwords.items():
                    if k != "allwords" and k != "poswords" and k != "negwords":
                        if word in words:
                            negScore = negScore * configs["advweigth"][k]
            return negScore
        else:
            return 0.0

    #复杂模型
    def cModelcalScore(self,sent_d):
        return None


    def getScore(self, sentDetailList):
        movie = {}
        actors = {}
        for sentDetail in sentDetailList:
            scores = {}
            lscores = []
            for sentTuple in sentDetail.sentencesDict:
                score = self.sModelcalScore(sentTuple[1])
                lscores.append(score)
                scores[sentTuple[0]] = lscores

            averageScores = {}
            for (k, s) in scores.items():
                averageScores[k] = sum(s) * 1.0 / len(s)

            if sentDetail.firstWord == u"电影":
                for (k, v) in averageScores.items():
                    movie[k] = v
            else:
                actors[sentDetail.firstWord] = averageScores

        return self.adaptScore(movie, actors)

    def adaptScore(self, movie, actors):
        for (k, v) in movie.items():
            if movie[k] != 0.0:
                movie[k] = (movie[k] + 10) / 2.0
        for (k1, v1) in actors.items():
            for (k2, v2) in actors[k1].items():
                if actors[k1][k2] != 0.0:
                    actors[k1][k2] = (actors[k1][k2] + 10) / 2.0

        return (movie, actors)

