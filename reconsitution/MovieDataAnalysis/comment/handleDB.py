#-*- coding: utf-8 -*-
import MySQLdb

configs =   {"host":"219.219.220.119",
             "user":"root",
             "password":"",
             "port":3306,
             "charset":"gbk"
            }

class HandleDB:
    def __init__(self):
        self.conn = None
        self.cur = None
        self.connectDB()

    def __del__(self):
        self.cur.close()
        self.conn.close()

    def connectDB(self):
        try:
            conn = MySQLdb.connect(host = configs["host"], user = configs["user"], passwd = configs["password"], port = configs["port"], charset = configs["charset"])
        except Exception, e:
            print str(e)

        self.conn = conn
        self.cur = self.conn.cursor()

    def clearTable(self, comm):
        self.conn.select_db("movies")
        self.cur.execute(comm)

    def getDataFromDB(self, comm = "select * from remarks"):
        self.conn.select_db("movies")
        count = self.cur.execute(comm)
        print "总记录： %s" % count
        info = self.cur.fetchall()

        return info

    def setDataToDB(self, comm = ""):
        self.conn.select_db("movies")
        self.cur.execute(comm)
        self.conn.commit()



