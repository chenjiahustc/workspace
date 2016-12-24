import sys
sys.path.append("E:\\new project\\")
import Get_Youku_weekrank_and_num
from Youku import Youku
from Tenxun import Tenxun
from Sohu import Sohu
from Leshi import Leshi
from Iqiyi import Iqiyi
from HuashuTV import HuashuTV
#from Baidufengyun2 import Baidu
from MyString import MyString
import time
import os
import shutil

def get_all_in_10(list1,list2,list3,list4,list5,list6):
    '''
    综合出电影和电视剧前10名
    :param list1～list6:优酷等的电影和电视剧排名信息，内容为[[[电影1，播放次数]...],[[电视剧1，播放次数]...]]，电影和电视剧数量均为50
    :return:[[[电影1，播放次数]...],[[电视剧1，播放次数]...]]，电影和电视剧数量为10
    '''




    return result

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
    myyouku=Get_Youku_weekrank_and_num.get_Youku_weekrank_and_num()
    mytencent=Movie.getalllist()
    for x in range(2):
        fp.writelines("%s\n********************\n"%(classes[i]))
        i+=1
        k=0
        for y in range(10):
            fp.writelines("%s:搜索次数:%s\n"%(allname[x][y][0],allname[x][y][1]))
        fp.writelines("********************\n")
    for x in range(3):
        fp.writelines("%s\n********************\n"%(classes[i]))
        i+=1
        temp=get_all_in_10(myyouku[x],mytencent[x])
        for y in range(10):
            fp.writelines("%s:搜索次数:%s\n"%(temp[y][0],temp[y][1]))
        fp.writelines("********************\n")
    fp.close()
print("更新完成")
