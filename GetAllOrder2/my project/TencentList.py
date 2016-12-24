#from selenium import webdriver
import time
#from 其他 import MyString
import urllib.request
from bs4 import BeautifulSoup

class Movie(object):

    def getList(item):
        res_data={}

        #排名
        res_data['rate']=item.find('span').get_text("|", strip=True)
        #电影名称
        res_data['name']=item.find('span',class_='mod_rankbox_con_item_title').get_text("|", strip=True)
        #看点
        res_data['point']=item.find('span', class_="mod_rankbox_con_item_actor").get_text("|", strip=True)
        #主演
        res_data['actor']=item.find('span',class_='mod_rankbox_con_item_impor').get_text("|", strip=True)
        #播放量
        res_data['times']=item.find('span',class_='mod_rankbox_con_list_click').get_text("|", strip=True)

        print('排名：%s 名称：%s  看点：%s  主演：%s 播放量：%s'%(res_data['rate'],res_data['name'],res_data['point'],res_data['actor'],res_data['times']))
        #return res_data
        return [res_data["name"],res_data["times"]]

    def getalllist():
        "获取所有列表"
        total=[]
        urlList=['http://v.qq.com/rank/detail/1_-1_-1_-1_3_-1.html',\
                 'http://v.qq.com/rank/detail/2_-1_-1_-1_3_-1.html',\
                 'http://v.qq.com/rank/detail/10_-1_-1_-1_3_-1.html']
        count=0
        while(count<3):
            temp=[]
            data=urllib.request.urlopen(urlList[count]).read()
            soup=BeautifulSoup(data,"html.parser")
            content=soup.find(class_='rank_content')#获取排行列表
            lists=content.find('ul',class_="mod_rankbox_con_list",id="mod_list")
            items=lists.find_all('li')
            for item in items:
                temp.append(Movie.getList(item))
                #res_data=getList(item)
            print('-----------------------------------------------------------------')
            total.append(temp)
            count=count+1
        return total

#测试代码
'''
#movie=Movie()
print(Movie.getalllist())
'''