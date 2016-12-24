#-*- coding: utf-8 -*-
import DivisionWord
import MySQLdb
from Comment import Comment
from handleDB import HandleDB
from dataWash import DataWash
import time

debug = True

def connectDB(ahost = '219.219.220.119', auser = 'root', apasswd='', aport = 3306, acharset='utf8'):
    try:
        conn = MySQLdb.connect(host = ahost, user = auser, passwd = apasswd, port = aport, charset = acharset)
        return conn
    except Exception, e:
        print str(e)

def init():
    db = HandleDB()
    #clear table actors
    comm = "delete from actors where 1"
    db.clearTable(comm)
    # clear table briefreview
    comm = "delete from briefreview where 1"
    db.clearTable(comm)
    # clear table moviescore
    comm = "delete from moviescore where 1"
    db.clearTable(comm)
    # # clear table explicitreview
    # comm = "delete from explicitreview where 1"
    # db.clearTable(comm)
    # # clear table implicitreview
    # comm = "delete from implicitreview where 1"
    # db.clearTable(comm)

def main():
    remark = u"周冬雨和马思纯演得挺好，不过我是冲着导演去的。两个女生角色的塑造其实就是大多数青春小说里常见的人设，坏女孩和乖女孩啊。剧情有点老套而且太俗了吧，讲两个女生的故事为什么每次都是为了男人撕逼啊，少女哪吒也是……看得我不爽。最后结局真的太好猜，我希望的百合场景果然没有(._.)"
    id = 1
    cm = Comment()
    db = HandleDB()
    comm = "select * from explicitreview"
    info = db.getDataFromDB()

    # for i in  range(0, len(info)):
    for i in  range(0, 1000):
        remark = info[i][3]

        cm.calScore(remark)
        #review
        comm = "insert into briefreview VALUES (%d, '%s', %f)" % (id, remark, cm.totalScore)
        db.setDataToDB(comm)
        #actors
        if cm.movieScore.actorsScore:
            for (k, v) in cm.movieScore.actorsScore.items():
                if v:
                    dialogue = 0.0
                    acting = 0.0
                    facescore = 0.0
                    for (k1, v1) in v.items():
                        if k1 == u"演技":
                            acting = v1
                        elif k1 == u"台词":
                            dialogue = v1
                        elif k1 == u"颜值":
                            facescore = v1
                        else:
                            pass

                    comm = "insert into actors VALUES ('%s', %d, %f, %f, %f)" % (k, id, dialogue, acting, facescore)
                    db.setDataToDB(comm)
        #movies
        if cm.movieScore.movieScore:
            plot = 0.0
            director = 0.0
            photograph = 0.0
            clothing = 0.0
            specialeffects = 0.0
            music = 0.0
            for (k, v) in cm.movieScore.movieScore.items():
                if k == u"剧情":
                    plot = v
                elif k == u"导演":
                    director = v
                elif k == u"摄影":
                    photograph = v
                elif k == u"服装":
                    clothing = v
                elif k == u"特效":
                    specialeffects = v
                elif k == u"音乐":
                    music = v
                else:
                    pass
            comm = "insert into moviescore VALUES (%d, %f, %f, %f, %f, %f, %f)" % (id, plot, director, photograph, clothing, specialeffects, music)
            db.setDataToDB(comm)

        id = id + 1


#Comment对象
def dataextraction(cm):
    #新建一个DataWash实例
    dw = DataWash(cm)

    db = HandleDB()
    info = db.getDataFromDB()

    for i in  range(0, len(info)):
        remark = info[i][3]
        if dw.judge(remark):
            try:
                comm = "insert into explicitreview VALUES ('%s')" % (remark)
                db.setDataToDB(comm)
            except:
                pass
        else:
            try:
                comm = "insert into implicitreview VALUES ('%s')" % (remark)
                db.setDataToDB(comm)
            except:
                pass

if __name__ == "__main__":
    init()
    cm = Comment()
    # dataextraction(cm)

    start = time.clock()
    main()
    end = time.clock()

    print "all time : %f s" % (end - start)
