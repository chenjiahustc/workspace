import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
from MyString import MyString

class Sohu(object):
    '''
    搜狐排行榜获取
    '''
    url=["http://tv.sohu.com/hotmovie/","http://tv.sohu.com/hotdrama/"]

    def get_data(self,browser=None,DEBUG=False):
        '''
        获取电影和电视剧排行榜
        :param browser: webdriver.Firefox()，有则利用传入的浏览器
        :param DEBUG: 为True则进行调试信息控制台输出
        :return: 列表[[[电影名称，播放量]...][[电视剧名称，播放量]...]]
        '''
        if browser is None:
            new_browser = webdriver.Firefox()
        else:
            new_browser=browser
        result=[]
        for x in range(2):
            new_browser.get(self.url[x])
            time.sleep(1)
            new_browser.find_element_by_xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/ul/li[2]").click()
            time.sleep(1)
            i=2
            temp=[]
            while(i<=11):
                one=new_browser.find_element_by_xpath("//*[@id=\"content\"]/div[2]/div[2]/div[3]/ul[%d]"%(i))
                #for j in range(5):
                all=one.find_elements_by_tag_name("li")
                for item in all:
                    name=item.find_element_by_class_name("at").text
                    count=MyString.string_to_integer(item.find_element_by_class_name("vTotal").text)
                    temp.append([name,count])
                i+=1
            if DEBUG:
                print(temp)
            result.append(temp)
        if browser is None:
            new_browser.close()
        return result

'''
#测试代码
my=Sohu()
my.get_data(None,True)
'''