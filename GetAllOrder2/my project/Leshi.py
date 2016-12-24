import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
from MyString import MyString

class Leshi(object):
    '''
    华数TV排行榜获取
    '''
    url=["http://top.le.com/filmhp.html","http://top.le.com/tvhp.html"]

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
            new_browser.find_element_by_css_selector("body > div.charts-box.clearfix > div.charts-content > div > div > a:nth-child(2)").click()
            time.sleep(1)
            i=2
            temp=[]
            while(i<=60):
                one=new_browser.find_element_by_css_selector("body > div.charts-box.clearfix > div.charts-content > div > ol.chart-list.j-for.selected > li:nth-child(%d)"%(i))
                if i%6==1:
                    i+=1
                    continue
                name=new_browser.find_element_by_css_selector("body > div.charts-box.clearfix > div.charts-content > div > ol.chart-list.j-for.selected > li:nth-child(%d) > span.t-2 > a"%(i)).text
                count=MyString.string_to_integer(new_browser.find_element_by_css_selector("body > div.charts-box.clearfix > div.charts-content > div > ol.chart-list.j-for.selected > li:nth-child(%d) > span.t-5"%(i)).text)
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
my=Leshi()
my.get_data(None,True)
'''