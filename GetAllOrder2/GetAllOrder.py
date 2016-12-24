import sys
sys.path.append("E:\\my project\\")
from Youku import Youku
from Tencent import Tencent
from Baidufengyun import Baidu
import time
import os
import shutil
from selenium import webdriver

path="E:\\txt\\"
filename="name_and_data.txt"
backupfilename="backup_name_and_data.txt"
fp=open(path+filename,'w+',encoding='gbk')
tm=time.localtime()
update=False
if(os.path.exists(path+filename)==True):
    line=fp.readline()
    if(line!=""):
        for k in range(3):
            i=line.find(":")
            j=line.find(":",i+1)
            if(int(line[i:j])!=tm[k]):
                update=True
                break
    else:
        update=True
if(update or os.path.exists(path+filename)!=True):
    if(os.path.exists(path+backupfilename)==True):
        os.remove(path+backupfilename)
    if(os.path.exists(path+filename)==True):
        shutil.copy(path+filename,path+backupfilename)
    classes=["男明星","女明星","电影","电视剧","娱乐节目"]
    fp.writelines("更新日期:%d:%d:%d:%d:%d:%d:\n********************\n"%(tm[0],tm[1],tm[2],tm[3],tm[4],tm[5]))
    i=0
    allname=Baidu.topname()
    browser=webdriver.Firefox()
    myyouku=Youku()
    mytencent=Tencent()
    for each in allname:
        fp.writelines("%s\n********************\n"%(classes[i]))
        if(i<2):
            for j in range(10):
                fp.writelines("%s:->百度周搜索次数:%s\n"%(allname[i][j][0],allname[i][j][1]))
            fp.writelines("********************\n")
            i+=1
        else:
            i+=1
            k=0
            for one in each:
                if(k>9):
                    break
                youkudata=myyouku.get_search_and_play_time(myyouku.get_url_from_name(one[0],browser,True),browser,True)
                tencentdata=mytencent.get_play_time_and_order(mytencent.get_url_from_name(one[0],browser,True),browser,True)
                fp.writelines("%s:百度周搜索次数:%s->优酷腾讯周播放总次数:%d\n"%(one[0],one[1],youkudata[1]+tencentdata[1]))
                k+=1
            fp.writelines("********************\n")
    browser.close()
    fp.close()
print("更新完成")
