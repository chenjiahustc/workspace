import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time
from MyString import MyString

class Youku(object):
    '''
    华数TV排行榜获取
    '''
    url=["http://movie.youku.com/top","http://tv.youku.com/top"]
    xpath=["//*[@id=\"m13070668981\"]","//*[@id=\"m13070287001\"]"]
    xpath2=["//*[@id=\"m13070668983\"]","//*[@id=\"m13070287003\"]"]

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
            time.sleep(5)
            target=new_browser.find_element_by_xpath(self.xpath[x]+"/div/div/ul/li[2]")
            ActionChains(new_browser).move_to_element_with_offset(target,4,4).perform()
            ActionChains(new_browser).click().perform()
            time.sleep(5)
            i=1
            temp=[]
            while(i<=50):
                one=new_browser.find_element_by_xpath(self.xpath2[x]+"/div/div/table/tbody/tr[%d]"%(i))
                name=one.find_element_by_class_name("show_title").find_element_by_tag_name("a").get_attribute("title")
                count=MyString.string_to_integer(one.find_element_by_class_name("show_stat").text)
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
my=YoukuList()
my.get_data(None,True)
#'''