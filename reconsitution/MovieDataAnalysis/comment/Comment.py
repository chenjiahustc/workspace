# -*- coding: utf-8 -*-
import re  # 模块re：包含正则表达式的所有方法
import os
import codecs
from calScore import CalScore


#整条评论的分句
class Sentence:
    def __init__(self, firstWord = u"电影", sentencesDict = None):
        self.firstWord = firstWord
        self.sentencesDict = sentencesDict


#整条评分的结构体
class RemarksScore:
    '''
    movieDimension:{u"剧情":5, u"导演":4}
    actorsName:{u"吴亦凡":{u"演技":4, u"颜值":5},
            u"":{}
            }
    '''
    def __init__(self, movieScore = {}, actorsScore = {}):
        self.movieScore = movieScore
        self.actorsScore = actorsScore

configs = { "synonymPath":{ "actorsName":"\synonym\\actorsName",
                            "actorDimension":"\synonym\\actorDimension",
                            "movieDimension":"\synonym\movieDimension"
                        },
          }

#完整评论
class Comment:
    '''
    content: 完整的一句评论
    actors: {u"吴亦凡":[u"凡凡", u"加拿大"]，}
    classfications: {"movieDimension":{u"导演":[], u"剧情":[u"编剧",u"故事",u"电影内容"], u"特效":[]},
                     "actorDimension":{u"演技":[], u"颜值":[]}}
    '''

    def __init__(self):
        self.actors = {}
        self.classfications = {}
        self.movieScore = {}
        self.totalScore = 0

        path = os.path.dirname(os.path.abspath(__file__))
        #构造actors
        dirpath = path + configs["synonymPath"]["actorsName"]
        files = os.listdir(dirpath)
        for file in files:
            filepath = dirpath + '\\' + file.decode("gbk")
            data = self.getdata(filepath)
            self.actors[data[0]] = data[1:]
        #构造classfications
        movieDimension = {}
        dirpath = path + configs["synonymPath"]["movieDimension"]
        files = os.listdir(dirpath)
        for file in files:
            filepath = dirpath + '\\' + file.decode("gbk")
            data = self.getdata(filepath)
            movieDimension[data[0]] = data[1:]

        self.classfications["movieDimension"] = movieDimension

        actorDimension = {}
        dirpath = path + configs["synonymPath"]["actorDimension"]
        files = os.listdir(dirpath)
        for file in files:
            filepath = dirpath + '\\' + file.decode("gbk")
            data = self.getdata(filepath)
            actorDimension[data[0]] = data[1:]

        self.classfications["actorDimension"] = actorDimension

    def getdata(self, filepath):
        fileHandler = codecs.open(filepath, "r", "utf-8")
        data = fileHandler.read()

        data = data.split('\n')
        _data = []
        for d in data:
            if d != u"\r" and d != u"":
                if d[-1] == u'\r':
                    d = d[0:-1]
                _data.append(d)

        if _data[0][:1] == u"\ufeff":
            _data[0] = _data[0][1:]

        return _data

    def calScore(self, content):
        line_break = re.compile(u'[\r\n]')
        delimiter_break = re.compile(u'[。？！；.?!;~～]')
        sentences_list = []

        #将完整的评论最小粒度为句号级别的子句放入sentences中
        for line in line_break.split(content):
            line = line.strip()
            if not line:
                continue
            else:
                for sent in delimiter_break.split(line):
                    sent = sent.strip()
                    if not sent:
                        continue
                    else:
                        sentences_list.append(sent)

        #讲评论解析成一个长句的List
        sentDetailList = []
        for sentence in sentences_list:
            sentDetail = self.getSentence(sentence)
            sentDetailList.extend(sentDetail)

        #对长句List计算平均分
        cs = CalScore()
        (movie, actors) = cs.getScore(sentDetailList)
        self.movieScore = RemarksScore(movie, actors)

        totalActorScore = 0.0
        totalMovieScore = 0.0
        i = 0
        for (k1, v1) in self.movieScore.actorsScore.items():
            for (k2, v2) in v1.items():
                if v2 != 0:
                    totalActorScore = totalActorScore + v2
                    i = i + 1
        if i != 0:
            totalActorScore = totalActorScore / i

        i = 0
        for (k1, v1) in self.movieScore.movieScore.items():
            if v1 != 0:
                totalMovieScore = totalMovieScore + v1
                i = i + 1
        if i != 0:
            totalMovieScore = totalMovieScore / i

        self.totalScore = (totalMovieScore + totalActorScore) / 2.0

    #解析长句
    def getSentence(self, sentence):
        sent_break = re.compile(u'[,， ]')
        sentencesList = []
        #将长句按逗号分成短句
        sents = sent_break.split(sentence)

        for actor in self.actors.keys():
            actornames = self.actors[actor]
            actornames.append(actor)
            for name in actornames:
                if sentence.find(name) != -1:
                    sentenceDict = []
                    for sent_d in sents:
                        sent_d = sent_d.strip()
                        if not sent_d:
                            continue
                        for (actorAtrribute, actorDims) in self.classfications["actorDimension"].items():
                            actorDims.append(actorAtrribute)
                            for dim in actorDims:
                                if sent_d.find(dim) != -1:
                                    sentenceDict.append((actorAtrribute, sent_d))
                                    break
                    flag = 1
                    for item in sentencesList:
                        if item.firstWord == actor:
                            flag = 0
                            break;
                    if flag == 1:
                        sentencesList.append(Sentence(actor, sentenceDict))
        sentenceDict = []
        for sent_d in sents:
            sent_d = sent_d.strip()
            if not sent_d:
                continue
            for (movieAttribute, movieDims) in self.classfications["movieDimension"].items():
                movieDims.append(movieAttribute)
                for attri in movieDims:
                    if sent_d.find(attri) != -1:
                        sentenceDict.append((movieAttribute, sent_d))
                        break
        if len(sentenceDict) != 0:
            sentencesList.append(Sentence(u"电影", sentenceDict))

        return sentencesList
















