import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
from MyString import MyString

class Tencent(object):
    "采集腾讯视频指数模块"
    url_homepage="http://v.qq.com/datacenter/xg95sxi4q7zc4uo.html"

    def get_url_from_name(self,name,browser=None,DEBUG=False):
        "获取搜索内容为name的腾讯视频指数地址"
        if browser is None:
            new_browser = webdriver.Firefox()
        else:
            new_browser=browser
        new_browser.get(self.url_homepage)
        time.sleep(1)
        target=new_browser.find_element_by_xpath('/html/body/div[2]/div[1]/div/div/form/input[1]')
        target.clear()
        target.send_keys("%s"%(name))
        time.sleep(1)
        url=''
        style=new_browser.find_element_by_xpath("/html/body/div[2]/div[1]/div/div/div ").get_attribute("style")
        id=target.get_attribute("data-id")
        if(str(style)=="display: block;"):
            url="http://v.qq.com/datacenter/"+str(id)+".html"
        if browser is None:
            new_browser.close()
        if DEBUG:
            print(url)
        return url

    def get_play_time_and_order(self,url,browser=None,DEBUG=False):
        "获取播放次数和排名"
        if(url==""):
            return [0,0,0]
        if browser is None:
            new_browser = webdriver.Firefox()
        else:
            new_browser=browser
        if(new_browser.current_url!=url):
            new_browser.get(url)
        time.sleep(1)
        target1=new_browser.find_element_by_xpath("/html/body/div[2]/div[3]/ul/li/ol/li[1]/span[1]")
        total_play_time=int(target1.get_attribute("n"))
        target2=new_browser.find_element_by_xpath("/html/body/div[2]/div[3]/ul/li/ol/li[2]/span[2]")
        week_play_time=MyString.string_to_integer(target2.text)
        target3=new_browser.find_element_by_xpath("/html/body/div[2]/div[3]/ul/li/ol/li[3]/span[2]")
        week_order=int(target3.text)
        if browser is None:
            new_browser.close()
        if(DEBUG):
            print("总播放量为:%d;周播放量为:%d;周排名:%d"%(total_play_time,week_play_time,week_order))
        return [total_play_time,week_play_time,week_order]

#调试代码
'''
my=Tencent()
browser=webdriver.Firefox()
my.get_play_time_and_order(my.get_url_from_name("卧虎藏龙",browser,True),browser,True)
browser.close()
'''