import sys
#sys.path.append("E:\\my project\\")
from selenium import webdriver
import time
#from MyString import MyString

def get_Youku_weekrank_and_num():
    total=[]
    browser=webdriver.Firefox()
    urllist=["http://movie.youku.com/top",\
             "http://tv.youku.com/top",\
             "http://zy.youku.com/top"]
    urlnum = 3
    i=0
    while (i<urlnum):
        temp=[]
        browser.get(urllist[i])
        if(i==2):
            target=browser.find_element_by_xpath("//*[@id=\"tab_41731_2\"]/a")
        elif(i==0):
            target=browser.find_element_by_xpath("//*[@id=\"tab_41719_2\"]/a")
        elif(i==1):
            target=browser.find_element_by_xpath("//*[@id=\"tab_41712_2\"]/a")
        time.sleep(3)
        target.click()
        time.sleep(3)
        k=1
        while (k<=50):
            target=browser.find_element_by_xpath("//*[@class=\"sRank_W\"]/table/tbody/tr[%d]"%(k))        
            title=target.find_elements_by_class_name("show_title")
            titlename=target.find_element_by_tag_name("a")
            title_text=titlename.get_attribute("title")
            print(title_text)
            playtime=target.find_element_by_class_name("num")
            playtime_text=playtime.text
            print(playtime_text+'\n')
            temp.append([title_text,playtime_text])
            k+=1
        i+=1
        print("%d finished"%i)
        time.sleep(1)
        #return [title_text,playtime_text]
    total.append(temp)
    print("all done")
    browser.close()
    print(total)
    return total
    
#测试代码
'''
get_Youku_weekrank_and_num()
'''

