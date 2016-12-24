import sys
sys.path.append("E:\\my project\\")
import Get_Youku_weekrank_and_num
from TencentList import Movie
from Baidufengyun2 import Baidu
from MyString import MyString
import time
import os
import shutil

def get_all_in_10(list1,list2):
    "综合出前10个"
    result=[]
    i=0
    for each1 in list1:
        if(i>=10):
            break
        for each2 in list2:
            temp=[]
            if(each2[0]==each1[0]):
                num=str(MyString.string_to_integer(each1[1])+MyString.string_to_integer(each2[1]))
                temp.append(each1[1])
                temp.append(num)
                result.append(temp)
                i+=1
                break
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
