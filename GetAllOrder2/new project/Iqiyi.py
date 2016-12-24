import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
from MyString import MyString

class Iqiyi(object):
    '''
    华数TV排行榜获取
    '''
    url=["http://top.iqiyi.com/dianying.html","http://top.iqiyi.com/dianshiju.html"]

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
            #new_browser.find_element_by_xpath("/html/body/div[3]/div/div[3]/ul[1]/li[2]").click()
            #time.sleep(1)
            i=1
            temp=[]
            while(i<=50):
                #one=new_browser.find_element_by_xpath("//*[@id=\"tab_top50\"]/div[1]/ul/li[%d]"%(i))
                name=new_browser.find_element_by_xpath("//*[@id=\"tab_top50\"]/div[1]/ul/li[%d]/a[1]"%(i)).text
                count=MyString.string_to_integer(new_browser.find_element_by_xpath("//*[@id=\"tab_top50\"]/div[1]/ul/li[%d]/a[3]"%(i)).text)
                temp.append([name,count])
                i+=1
            if DEBUG:
                print(temp)
            result.append(temp)
        if browser is None:
            new_browser.close()
        return result

#'''
#测试代码
my=Iqiyi()
my.get_data(None,True)
#'''