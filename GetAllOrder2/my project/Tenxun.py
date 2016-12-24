import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
from MyString import MyString

class Tenxun(object):
    '''
    华数TV排行榜获取
    '''
    url=["http://v.qq.com/rank/detail/1_-1_-1_-1_3_-1.html","http://v.qq.com/rank/detail/2_-1_-1_-1_2_-1.html"]

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
            new_browser.find_element_by_xpath("/html/body/div[3]/div[2]/div[2]/div/ul[1]/li[2]").click()
            time.sleep(1)
            i=1
            temp=[]
            while(i<=50):
                one=new_browser.find_element_by_xpath("//*[@id=\"mod_list\"]/li[%d]"%(i))
                name=one.find_element_by_class_name("mod_rankbox_con_item_title").find_element_by_tag_name("a").get_attribute("title")
                count=MyString.string_to_integer(one.find_element_by_class_name("mod_rankbox_con_list_click").find_element_by_tag_name("strong").text)
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
my=Tenxun()
my.get_data(None,True)
'''