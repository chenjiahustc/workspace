import sys
sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
from MyString import MyString

browser=webdriver.Firefox()
browser.get("http://v.qq.com/rank/detail/1_-1_-1_-1_2_-1.html")
target=browser.find_element_by_xpath("//*[@id=\"mod_list\"]/li[1]")
name=target.find_element_by_tag_name("a")
kandian=target.find_element_by_class_name("mod_rankbox_con_item_actor")
playtime=target.find_element_by_class_name("mod_rankbox_con_list_click")
print(name.text)
print(name.get_attribute("title"))
print(kandian.text)
print(playtime.text)
#browser.close()

'''
browser=webdriver.Firefox()
browser.get("http://weibo.com/login.php")
t=browser.find_element_by_xpath("//*[@id=\"pl_login_form\"]/div[2]/div[1]/div/a[2]")
t.click()
un=browser.find_element_by_xpath("//*[@id=\"pl_login_form"]/div[2]/div[3]/div[1]/div/input")
#browser.get("http://weibo.com/u/2400917504?is_search=0&visible=0&is_hot=1&is_tag=0&profile_ftype=1&page=2#feedtop")
target=browser.find_element_by_xpath("//*[@id=\"Pl_Official_MyProfileFeed__25\"]/div/div[2]/div[1]/div[3]/div[3]")
time.sleep(2)
print(target.text)
#target.click()
#time.sleep(1)
#target=browser.find_element_by_xpath("//*[@class=\"sRank_W\"]/table/tbody/tr[1]")
#title=target.find_elements_by_class_name("show_title")
#titlename=target.find_element_by_tag_name("a")
#print(titlename.get_attribute("title"))
#playtime=target.find_element_by_class_name("num")
#print(playtime.text)
print("finished")
'''
