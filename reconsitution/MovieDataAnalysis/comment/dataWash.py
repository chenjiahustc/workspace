# -*- coding: utf-8 -*-
from Comment import Comment
class DataWash:
    def __init__(self, cm):
        self.keys = []
        # #actors
        # for (name, nicknames) in cm.actors.items():
        #     keys.append(name)
        #     for nickname in nicknames:
        #         keys.append(nickname)
        # movie
        # moviedimension
        for (dimen, nickdimens) in cm.classfications["movieDimension"].items():
            self.keys.append(dimen)
            for nickdimen in nickdimens:
                self.keys.append(nickdimen)
        # actordimension
        for (dimen, nickdimens) in cm.classfications["actorDimension"].items():
            self.keys.append(dimen)
            for nickdimen in nickdimens:
                self.keys.append(nickdimen)


    def judge(self, comment):
        for word in self.keys:
            if comment.find(word) != -1:
                return True

        return False