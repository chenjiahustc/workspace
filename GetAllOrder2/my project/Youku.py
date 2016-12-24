import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import selenium
import time
from MyString import MyString

class Youku(object):
    '采集优酷指数模块'
    url_homepage="http://index.youku.com"

    def get_url_from_name(self,name,browser=None,DEBUG=False):
        "获取搜索内容为name的优酷视频指数地址"
        if browser is None:
            new_browser = webdriver.Firefox()
        else:
            new_browser=browser
        new_browser.get(self.url_homepage)
        time.sleep(1)
        new_browser.find_element_by_xpath("//*[@id=\"indexQuery\"]").send_keys("%s"%(name))
        new_browser.find_element_by_xpath("/html/body/div[1]/div/div[2]/div/div/div/div[3]/div/button").click()
        time.sleep(1)
        url=new_browser.current_url
        if browser is None:
            new_browser.close()
        if DEBUG:
            print(url)
        return str(url)

    def get_search_and_play_time(self,url,browser=None,DEBUG=False):
        "获取当日搜索次数和播放次数"
        if browser is None:
            new_browser = webdriver.Firefox()
        else:
            new_browser=browser
        if(new_browser.current_url!=url):
            new_browser.get(url)
        time.sleep(1)
        target=new_browser.find_element_by_xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div/div[1]/div")
        if(target.get_attribute("class")=="input_shows"):
            target1=new_browser.find_element_by_xpath("//*[@id=\"allnet\"]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/span")
            temp1=str(target1.text)
            search_time=MyString.string_to_integer(temp1)
            target2=new_browser.find_element_by_xpath("//*[@id=\"allnet\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/span")
            temp2=str(target2.text)
            play_time=MyString.string_to_integer(temp2)
            if browser is None:
                new_browser.close()
            if(DEBUG):
                print("搜索次数:%d;播放次数:%d"%(search_time,play_time))
            return [search_time,play_time]
        return [-1,-1]

#调试代码
'''
browser=webdriver.Firefox()
my=Youku()
my.get_search_and_play_time(my.get_url_from_name("杨幂",browser,True),browser,True)
'''


