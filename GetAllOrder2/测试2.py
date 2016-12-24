#收集数据模块
import operator
import os
from urllib import request
from urllib import parse
from bs4 import BeautifulSoup
from selenium import webdriver
import socket
import time
from PIL import Image
import sys
from pyocr import pyocr
import pyocr.builders

class Youku(object):
    '从优酷爬数据的Youku类'
    urllist=["http://index.youku.com/vr_keyword/id_55Sf5YyW5Y2x5py6MQ%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_55Sf5YyW5Y2x5py6Mg%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_55Sf5YyW5Y2x5py6Mw%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_55Sf5YyW5Y2x5py6NA%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_55Sf5YyW5Y2x5py6NQ%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_57uI57uT6ICFMQ%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_57uI57uT6ICFMg%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_57uI57uT6ICFMw%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_57uI57uT6ICFNA%253d%253d?type=alldata",\
             "http://index.youku.com/vr_keyword/id_57uI57uT6ICFNQ%253d%253d?type=alldata",]
    urllistnum=10

    xpathlist=["/html/body/div[1]/div/div[1]/div/ul[1]/li[1]/a",\
               "/html/body/div[1]/div/div[1]/div/ul[1]/li[2]/a",\
               "/html/body/div[1]/div/div[1]/div/ul[1]/li[3]/a",\
               "/html/body/div[1]/div/div[1]/div/ul[2]/li[3]/a",\
               "/html/body/div[1]/div/div[1]/div/ul[2]/li[2]/a",\
               "//*[@id=\"helpurl\"]/a"]
    xpathlistnum=6

    def geturl(name,browser):
        '获取name对应的url'
        #browser = webdriver.Firefox()
        #browser.get(url)
        browser.find_element_by_xpath("//*[@id=\"queryWord\"]").send_keys("%s"%(name))
        browser.find_element_by_xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div/div[2]/div/button").click()
        time.sleep(1)
        url=browser.current_url
        #browser.close()
        return str(url)

    #get(url,f1)
    def getdata(url,f1):
        "从指定的url爬取数据，将含有所需数据的标签字符写入f1"
        data=request.urlopen(url).read()
        #page_data=data.decode('GBK')
        soup=BeautifulSoup(data)
        #fp=open(f1,'a+')/home/liuyuan458
        for link in soup.find_all("script"):
            alllines=str(link)
            i=alllines.find('allnetData')
            if(i!=-1):
                Youku.translate(alllines,f1)
        #fp.close()

    #translate(f1,f2)
    def translate(alllines,f2):
        "将alllines转换成只含数据的txt文档f2"
        fp2=open(f2,'a+',encoding="gbk")
        #alllines=fp1.readlines()
        #print(alllines)
        i=-1
        j=-1
        k=0
        l=-1
        #alllines=''
        i=alllines.find('allnetData')
        l=alllines.find('vv',i+1)
        temp=''
        j=alllines.find('\"',i,l)
        i=alllines.find('\"',j+1,l)
        while (i!=-1)and(j!=-1)and(k<5):
            temp+=alllines[j+1:i]
            temp+=','
            k+=1
            j=alllines.find('\"',i+1,l)
            i=alllines.find('\"',j+1,l)
        fp2.writelines(temp)
        fp2.writelines('\n')
        print('finished!'),
        while(i!=-1)and(j!=-1):
            temp=''
            k=0
            print ("(%d),(%d)"%(j,i)),
            while (i!=-1)and(j!=-1)and(k<10):
                temp+=alllines[j+1:i]
                temp+=','
                k+=1
                j=alllines.find('\"',i+1,l)
                i=alllines.find('\"',j+1,l)
            if (temp!=''):
                fp2.writelines(temp)
                fp2.writelines('\n')
        print('done!'),
        fp2.close()

class Mingxing(object):
    '爬取mingxing.com的Mingxing类'

    def save(st,f1):
        "将st里面的明星姓名写入f1"
        #st='alt="黎明"dsds'
        fp=open(f1,'a+')
        i=-1
        j=-1
        k=-1
        l=0
        i=st.find('alt')
        if i!=-1:
            j=st.find('\"',i)
        if j!=-1:
            k=st.find('\"',j+1)
        print("%d,(%d,%d)"%(i,j,k)),
        while(i!=-1):
            st2=''
            while(j+1<k)and(l<10):
                st2+=st[j+1:k]
                st2+=','
                i=st.find('alt',k)
                if i!=-1:
                    j=st.find('\"',i)
                    if j!=-1:
                        k=st.find('\"',j+1)
                else:
                    break
                print("%d,(%d,%d)"%(i,j,k)),
                l+=1
            if(st2!=''):
                fp.writelines(st2)
                fp.writelines('\n')
                print('finished!'),
            l=0
        print('done!'),
        fp.close()

class iqiyi(object):
    '获取爱奇艺里面数据'
    def save(st,fp,k):
        '保存数据到文件'
        #fp=open(f1,"a+")
        #st=''
        i=-1
        j=-1
        j=st.find('alt')
        if (j==-1):
            return 1
        i=st.find('\"',j)
        j=st.find('\"',i+1)
        #print(st[i+1:j]),
        if (i!=-1)and(j!=-1)and(i+1<=j):
            #print('123,')
            #if(st[i+1:i+4]=='情感冲'):
            #    return
            s=st.find("&",i)
            if(s==-1):
                fp.writelines(st[i+1:j])
                fp.writelines(',')
            else:
                #fp.writelines(st[i+1:s])
                pass
        if (k[0]==9):
            k[0]=-1
            #print('\n')
            fp.writelines('\n')
        print('%d,%d'%(i,j)),
        return 0

    def getallmovie(url,f1):
        '获取电影名字'
        #url=
        data=request.urlopen(url).read()
        soup=BeautifulSoup(data)
        fp=open(f1,"a+",encoding='gbk')
        temp=''
        k=[0]
        all=soup.find_all(attrs={'class':'site-piclist_pic_link'})
        if not all:
            print('无数据'),
            return 1
        for line in all:
            temp=str(line)
            #print(temp),
            iqiyi.save(temp,fp,k)
            k[0]+=1
        fp.close()
        print('done!'),
        return 0

class optxt(object):
    '操作txt文件'
    def merge(f1,mylist,name,postfix):
        '将f1路径下的mylist[i].txt合并成name.txt'
        f3=f1+name+'.txt'
        f2=''
        fpout=open(f3,'a+',encoding='gbk')
        for each in mylist:
            f2=f1+each+postfix+'.txt'
            if(os.path.exists(f2)):
                print('开始复制:'+each),
                fpin=open(f2,'r',encoding='gbk')
                fpout.writelines(fpin)
                fpin.close()
        fpout.close()
        print('合并成功')

class Tencent(object):
    '收集腾讯的数据'
    urllist=["http://v.qq.com/datacenter/3o56brnhunm5bwx.html","http://v.qq.com/datacenter/c2xpl7t4eppkq7n.html",\
               "http://v.qq.com/datacenter/vj4pvtejerml1my.html","http://v.qq.com/datacenter/baybmkztmbrhnv3.html",\
               "http://v.qq.com/datacenter/13qs3pdpqd727wu.html","http://v.qq.com/datacenter/8f3kgwayyjsn2ur.html",\
               "http://v.qq.com/datacenter/2u7xwh2x4d949w0.html","http://v.qq.com/datacenter/x3ex2mlrbx3ku2b.html"]
    '''8个网址'''
    urllistnum=8
    xpathlist=["//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[1]/li[1]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[1]/li[2]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[1]/li[3]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[2]/li[1]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[2]/li[2]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[2]/li[3]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[3]/li[1]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[3]/li[2]/a",\
                 "//*[@id=\"head_v3\"]/div[1]/div[2]/div/div[1]/ul[3]/li[3]/a"]
    '''9个xpath'''
    xpathlistnum=9

    def geturl(name,browser):
        '获取name对应的url'
        target=browser.find_element_by_xpath('/html/body/div[2]/div[1]/div/div/form/input[1]')
        target.clear()
        target.send_keys("%s"%(name))
        #target.send_keys(Keys.ENTER)
        time.sleep(1)
        url=''
        style=browser.find_element_by_xpath("/html/body/div[2]/div[1]/div/div/div ").get_attribute("style")
        id=target.get_attribute("data-id")
        #webdriver.ActionChains(browser).move_to_element(target).click().perform()
        #webdriver.ActionChains(broswer).click(target).send_keys_to_element(target,name).perform()
        #browser.find_element_by_xpath("/html/body/div[2]/div[1]/div/div/form/input[2]").click()
        if(str(style)=="display: block;"):
            url="http://v.qq.com/datacenter/"+str(id)+".html"
        return url

    def getdata(url,f1):
        '从url获取数据'
        if(url==''):
            return
        req=request.urlopen(url)
        data=req.read()
        soup=BeautifulSoup(data)
        req.close()
        for each in soup.find_all('script',attrs={'type':'text/javascript'}):
            line=str(each)
            x=line.find('gdata_coverinfo ')
            if(x!=-1):
                #print(line)
                Tencent.savedata(line,f1)

    def savedata(line,f1):
        '保存line:str里需要的数据到路径f1:str'
        i=-1
        j=-1
        k=-1
        l=-1
        print('%d,%d,%d,%d'%(i,j,k,l))
        fp=open(f1,'w+',encoding='gbk')
        i=line.find('title')
        l=i
        k=line.find('}',i)
        print('处理title')
        print('%d,%d,%d,%d'%(i,j,k,l))
        j=line.find('\"',i,k)
        fp.writelines(StrHandle.OnlyQuote(line,',',i-1,k))
        i=line.find(':',j+2,k)
        fp.writelines(line[i+1:k])
        fp.writelines('\n')
        print('处理播放数据')
        j=line.find('gdata_coverinfo')
        k=line.find('}',j,l)
        i=line.find('allnumc',j,k)
        while(k!=-1)and(i!=-1):
            print('%d,%d,%d,%d'%(i,j,k,l))
            fp.writelines(StrHandle.OnlyQuote(line,',',i-1,k))
            fp.writelines('\n')
            i=line.find('allnumc',k,l)
            if(i==-1):
                break
            k=line.find('}',i,l)
        print('处理观看时间')
        fp.writelines('-\n')
        j=line.find('gdata_timepoint',l)
        l=line.find('total',j)
        k=line.find('}',j,l)
        i=line.find('per_cnt',j,k)
        while(k!=-1)and(i!=-1):
            print('%d,%d,%d,%d'%(i,j,k,l))
            fp.writelines(StrHandle.OnlyQuote(line,',',i-1,k))
            fp.writelines('\n')
            i=line.find('per_cnt',k,l)
            if(i==-1):
                break
            k=line.find('}',i,l)
        print('处理其他数据')
        fp.writelines('-\n')
        j=line.find('gdata_profile_arr',l)
        l=line.find('total',j)
        k=line.find('}',j,l)
        i=line.find('per_cnt',j,k)
        while(k!=-1)and(i!=-1):
            print('%d,%d,%d,%d'%(i,j,k,l))
            fp.writelines(StrHandle.OnlyQuote(line,',',i-1,k))
            fp.writelines('\n')
            i=line.find('per_cnt',k+1,l)
            if(i==-1):
                break
            k=line.find('}',i,l)
        fp.close()
        print('done!')

class Baidu(object):
    '''
    获取百度指数
    '''
    xpathlogin=["//*[@id=\"userbar\"]/ul/li[4]/a",\
        "//*[@id=\"TANGRAM_12__userName\"]",\
        "//*[@id=\"TANGRAM_12__password\"]",\
        "//*[@id=\"TANGRAM_12__submit\"]"]

    xpathsearch=["//*[@id=\"schword\"]",\
        "//*[@id=\"searchWords\"]"]

    #xpathcategorys[0]趋势研究，xpathcategorys[1]需求图谱，xpathcategorys[2]舆情洞察，xpathcategorys[3]人群画像              
    xpathcategorys=["//*[@id=\"subNav\"]/tbody/tr/td[1]/a",\
        "//*[@id=\"subNav\"]/tbody/tr/td[2]/a",\
        "//*[@id=\"subNav\"]/tbody/tr/td[3]/a",\
        "//*[@id=\"subNav\"]/tbody/tr/td[4]/a",]

    xpathgettime="//*[@id=\"compOthtime\"]/div/div[1]/span/input"
    
    xpathsettime=["//*[@id=\"compOthtime\"]/div/div[1]/span//*[@id=\"auto_gsid_16\"]",\
        "//*[@id=\"auto_gsid_16\"]/div/a[3]"]                                                                                                                                     

    xpathgetpoint=["//*[@id=\"trend\"]/svg/path[13]",\
        "//*[@id=\"trend\"]/svg/circle"]

    xpathgetlegend="//*[@id=\"trendYimg\"]"

    xpathsearchtime={"timespan":"//*[@id=\"compOthtime\"]/div/div[1]/span",\
                     "custom":"//*[@id=\"compOthtime\"]/div/div[1]/span/div/a[3]",\
                     "startyear":"//*[@id=\"auto_gsid_17\"]/div[1]/span[2]/span[1]",\
                     "choosestartyear":"//*[@id=\"auto_gsid_17\"]/div[1]/span[2]/span[1]/div/a",\
                     "startmonth":"//*[@id=\"auto_gsid_17\"]/div[1]/span[2]/span[2]",\
                     "choosestartmonth":"//*[@id=\"auto_gsid_19\"]/ul/li[1]/a",\
                     "endyear":"//*[@id=\"auto_gsid_17\"]/div[2]/span[2]/span[1]",\
                     "chooseendyear":"//*[@id=\"auto_gsid_20\"]/div/a",\
                     "endmonth":"//*[@id=\"auto_gsid_17\"]/div[2]/span[2]/span[2]",\
                     "chooseendmonth":"//*[@id=\"auto_gsid_21\"]/ul/li[1]/a[1]",\
                     "confirmbutton":"//*[@id=\"auto_gsid_17\"]/div[3]/input[1]"}

    def loginfromindex(browser,usernm,passwd):
        '''
        从百度指数首页登陆
        '''
        target1=browser.find_element_by_xpath(Baidu.xpathlogin[0])
        target1.click()
        time.sleep(1)
        target2=browser.find_element_by_xpath(Baidu.xpathlogin[1])
        target3=browser.find_element_by_xpath(Baidu.xpathlogin[2])
        target4=browser.find_element_by_xpath(Baidu.xpathlogin[3])
        target2.send_keys(usernm)
        time.sleep(1)
        target3.send_keys(passwd)
        time.sleep(1)
        target4.click()
        time.sleep(1)
        print("登陆成功!")
        return 0

    def searchfromindex(browser,name):
        '''
        用name搜索百度指数
        '''
        target1=browser.find_element_by_xpath(Baidu.xpathsearch[0])
        target2=browser.find_element_by_xpath(Baidu.xpathsearch[1])
        target1.send_keys(name)
        time.sleep(1)
        target2.click()
        time.sleep(1)
        print("搜索成功!")
        return 0

    def setsearchtime(browser,count):
        '''
        设置搜索时间
        '''
        target1=browser.find_element_by_xpath("//*[@id=\"compOthtime\"]/div/div[1]/span")
        target1.click()
        time.sleep(1)
        target2=browser.find_element_by_xpath("//*[@id=\"compOthtime\"]/div/div[1]/span/div/a[3]")
        target2.click()
        time.sleep(1)
        target3=browser.find_element_by_xpath("//*[@id=\"auto_gsid_17\"]/div[1]/span[2]/span[1]")
        target3.click()
        time.sleep(1)
        target4=browser.find_element_by_xpath("//*[@id=\"auto_gsid_17\"]/div[1]/span[2]/span[1]/div/a"+"["+str(count)+"]")
        target4.click()
        time.sleep(1)
        target5=browser.find_element_by_xpath("//*[@id=\"auto_gsid_17\"]/div[1]/span[2]/span[2]")
        target5.click()
        time.sleep(1)
        target6=browser.find_element_by_xpath("//*[@id=\"auto_gsid_19\"]/ul/li[1]/a[1]")
        target6.click()
        time.sleep(1)
        target7=browser.find_element_by_xpath("//*[@id=\"auto_gsid_17\"]/div[2]/span[2]/span[1]")
        target7.click()
        time.sleep(1)
        target8=browser.find_element_by_xpath("//*[@id=\"auto_gsid_20\"]/div/a"+"["+str(count)+"]")
        target8.click()
        time.sleep(1)
        target9=browser.find_element_by_xpath("//*[@id=\"auto_gsid_17\"]/div[2]/span[2]/span[2]")
        target9.click()
        time.sleep(1)
        month=6
        monthpath="//*[@id=\"auto_gsid_21\"]/ul/li[2]/a"
        if((2010+count)==int(time.localtime()[0])):
            localmonth=int(time.localtime()[1])
            month_a=localmonth/6
            if(month_a<=1):
                monthpath="//*[@id=\"auto_gsid_21\"]/ul/li[1]/a"
                month=localmonth
            else:
                month=localmonth-6
        target10=browser.find_element_by_xpath(monthpath+"["+str(month)+"]")
        target10.click()
        time.sleep(1)
        target11=browser.find_element_by_xpath("//*[@id=\"auto_gsid_17\"]/div[3]/input[1]")
        target11.click()
        time.sleep(1)
        print("设置搜索时间成功")
        return 0

    def getlegend(imgpath):
        '''
        获取图例
        '''
        im=Image.open(imgpath)
        size=im.size
        new_size=(int(size[0]*2),int(size[1]*2))
        new_im=im.resize(new_size)
        topleftpoint=[2866,1164]
        boxwith=180
        boxheight=30
        box_distance=60
        result=[0,0]
        reverse=False
        for i in range(2):
            im_cut = new_im.crop((topleftpoint[0],topleftpoint[1]+i*box_distance,topleftpoint[0]+boxwith,topleftpoint[1]+boxheight+i*box_distance))
            #im_cut.save(imgpath+"截取"+str(i)+".png")
            #num=OcrHandle.to_number(imgpath+"截取"+str(i)+".png")
            num=OcrHandle.to_number(im_cut,False)
            #print(num)
            if(num!=0):
                result[i]=num
            else:
                result=[0,0]
                reverse=True
                break
        if(not reverse):
            dis=result[0]-result[1]
            result[1]=result[0]-7*dis
        else:
            for i in range(2):
                im_cut = new_im.crop((topleftpoint[0],topleftpoint[1]+(i+5)*box_distance,topleftpoint[0]+boxwith,topleftpoint[1]+boxheight+(i+5)*box_distance))
                num=OcrHandle.to_number(im_cut,False)
                if(num!=0):
                    result[i]=num
                else:
                    result=[0,0]
                    break
            dis=result[0]-result[1]
            result[1]=result[1]-dis
            result[0]=result[1]+7*dis
        print(result)
        return result

    def getallpoints(browser,result):
        '''
        获取页面所有点
        '''
        target=browser.find_elements_by_xpath("//*[@id=\"trend\"]/*[name()=\"svg\"]/*[name()=\"path\"]")
        ctarget=target[5]
        alllines=ctarget.get_attribute("d")
        print(alllines)
        i=-1
        j=alllines.find("C")
        k=0
        point=0.0
        realpoint=0.0
        while(j!=-1):
            i=alllines.rfind(",",k,j)
            if(i!=-1):
                point=float(alllines[i+1:j])
            print("在图中的Y值:%f"%(point))
            realpoint=result[0]-(point-130.0)*(result[0]-result[1])/(337.66666666666663-130.0)
            print("真实值是%f"%(realpoint))
            k=j+1
            j=alllines.find("C",k)
        j=len(alllines)
        i=alllines.rfind(",",k,j)
        if(i!=-1):
            point=float(alllines[i+1:j])
            print("在图中的Y值:%f"%(point))
            realpoint=result[0]-((point-130.0)*(result[0]-result[1])/(337.66666666666663-130.0))
            print("真实值是%f"%(realpoint))

class GetData(object):
    "获取数据，处理异常"

    def goget(urllist,urllistnum,xpathlist,xpathlistnum,ffrom,fto,prefix,geturl,getdata):
        '''
        爬取函数，urllist为爬取网址清单（一段时间替换网址防止被检测），xpathlist为网址上的元素xpath
        (防检测会点击这些元素)，urllistnum为urllist里面元素的数量，xpathlistnum为xpathlist里面元素
        数量ffrom为爬取名字来源文件，fto为爬取输出文件路径，prefix为输出文件前缀
        '''
        myurllist=urllist#Tencent.myurllist
        myxpathlist=xpathlist#Tencent.myxpathlist
        urlnum=0
        xpathnum=0
        timeout = 60
        socket.setdefaulttimeout(timeout)
        browser = webdriver.Firefox()
        browser.get(myurllist[urlnum])
        prenum=urlnum
        urlnum=(urlnum+1)%urllistnum
        #current_handle=browser.current_window_handle
        inittime=time.time()
        #time.sleep(0.5)
        f1=ffrom#'F:\\txt\\iqiyi数据\\名字\\电视剧\\iqiyi全部电视剧.txt'
        fp=open(f1,'r',encoding='gbk')
        allname=fp.readlines()
        for alllines in allname:
            line=str(alllines)
            i=0
            j=-1
            j=line.find(',',i)
            name=''
            while(j!=-1):
                name=line[i:j]
                print(name),
                f2=fto+prefix
                f2+=name
                f2+='.txt'
                #f2+='.txt'#'F:\\txt\\腾讯数据\\电视剧\\tencent-'+name+'.txt'
                curtime=time.time()
                if((curtime-inittime)>180):
                    print("3分钟时间到，等待30秒钟")
                    inittime=curtime
                    time.sleep(10)
                    currenturl=myurllist[prenum]
                    nexturl=myurllist[urlnum]
                    prenum=urlnum
                    urlnum=(urlnum+1)%urllistnum
                    xpath=myxpathlist[xpathnum]
                    xpathnum=(xpathnum+1)%xpathlistnum
                    browser.get(currenturl)
                    GetData.handlerrorbyclickxpath(browser,xpath,currenturl,nexturl)
                    time.sleep(10)
                if(os.path.exists(f2)==True):
                    i=j+1
                    j=line.find(',',i)
                    continue
                while(True):
                    try:
                        go=geturl(name,browser)#Tencent.geturl(name,browser)
                        getdata(go,f2)#Tencent.getdata(go,f2)
                        break
                    except ConnectionResetError as e:
                        print('ConnectionResetError，等待30秒钟')
                        time.sleep(10)
                        currenturl=myurllist[prenum]
                        nexturl=myurllist[urlnum]
                        prenum=urlnum
                        urlnum=(urlnum+1)%urllistnum
                        xpath=myxpathlist[xpathnum]
                        xpathnum=(xpathnum+1)%xpathlistnum
                        browser.get(currenturl)
                        GetData.handlerrorbyclickxpath(browser,xpath,currenturl,nexturl)
                        time.sleep(10)
                        continue
                    except socket.timeout as f:
                        print('python socket.timeout:timed out，等待30秒钟')
                        time.sleep(10)
                        currenturl=myurllist[prenum]
                        nexturl=myurllist[urlnum]
                        prenum=urlnum
                        urlnum=(urlnum+1)%urllistnum
                        xpath=myxpathlist[xpathnum]
                        xpathnum=(xpathnum+1)%xpathlistnum
                        browser.get(currenturl)
                        GetData.handlerrorbyclickxpath(browser,xpath,currenturl,nexturl)
                        time.sleep(10)
                        continue
                    except socket.gaierror as g:
                        print('socket.gaierror: [Errno 11001] getaddrinfo failed，等待30秒钟')
                        time.sleep(15)
                        browser.refresh()
                        time.sleep(15)
                        continue
                i=j+1
                j=line.find(',',i)
        fp.close()
        browser.quit()

    def handlerrorbyclickxpath(browser,xpath,currenturl,nexturl):
        "点击当前网页里面的xpath元素，再关闭打开窗口，进入nexturl"
        target=browser.find_element_by_xpath(xpath)
        target.click()
        time.sleep(5)
        all_handles=browser.window_handles
        for each in all_handles:
            browser.switch_to_window(each)
            if(browser.current_url!=currenturl):
                for i in range(5):
                    browser.execute_script("window.scrollBy(0,200)","")
                    time.sleep(1)
                browser.close()
        all_handles=browser.window_handles
        browser.switch_to_window(all_handles[0])
        browser.get(nexturl)

class StrHandle(object):
    '处理字符串'

    def OnlyQuote(line,divide,start,end):
        '获取line[start:end]里面""里面的字符，用divide分开'
        temp=''
        i=line.find('\"',start,end)
        if(i!=-1):
            j=line.find('\"',i+1,end)
            while(j!=-1):
                temp+=line[i+1:j]
                temp+=divide
                i=line.find('\"',j+1,end)
                if(i==-1):
                    break
                j=line.find('\"',i+1,end)
        return temp

class OcrHandle(object):
    '''
    ocr相关操作
    '''
    def to_number(imgpath,ispath=True):
        "将imgpath处的图片转换成数字"
        tools = pyocr.get_available_tools()[:]
        if len(tools) == 0:
            print("No OCR tool found")
            sys.exit(1)
        print("Using \'%s\'" % (tools[0].get_name()))
        langs = tools[0].get_available_languages()
        print("Available languages: %s" % ", ".join(langs))
        #lang = langs[0]
        print("Will use lang 'eng'")
        if(ispath):
            im=Image.open(imgpath)
        else:
            im=imgpath
        imgtxt=tools[0].image_to_string(im, lang="eng",builder=pyocr.builders.TextBuilder())
        print(imgtxt)
        num=0
        if(imgtxt==''):
            return num
        else:
            for i in range(len(imgtxt)):
                temp=imgtxt[i:i+1]
                if(operator.lt(temp,'0') or operator.gt(temp,'9')):
                    if(temp==',' or temp=='.' or temp==' '):
                        pass
                    else:
                        num=0
                        break
                else:
                    num*=10
                    num+=int(imgtxt[i:i+1])
        return num

#测试类与函数
def test1():
    f1='F:\\txt\\全部明星.txt'
    head="http://www.mingxing.com/ziliao/index"
    middle=''
    tail=".html"
    url=head+middle+tail
    Mingxing.getall(url,f1)
    num=2
    while(num<=6):
        middle="_"+str(num)
        url=head+middle+tail
        Mingxing.getall(url,f1)
        num+=1

def test2():
    '测试'
    browser = webdriver.Firefox()
    #browser.get("http://start.firefoxchina.cn/")
    f1='F:\\txt\\iqiyi数据\\名字\\电影\\iqiyi全部电影.txt'
    fp=open(f1,'r',encoding='gbk')
    allname=fp.readlines()
    for alllines in allname:
        line=str(alllines)
        i=0
        j=-1
        j=line.find(',',i)
        name=''
        while(j!=-1):
            name=line[i:j]
            print(name),
            f2='F:\\txt\\优酷数据\\电影\\'+name+'.txt'
            if(os.path.exists(f2)==True):
                i=j+1
                j=line.find(',',i)
                continue
            go=Youku.geturl(name,browser)
            Youku.getdata(go,f2)
            i=j+1
            j=line.find(',',i)
    fp.close()
    browser.quit()
#执行

def test3():
    'iqiyi电影'
    #mylist=['搞笑','热血','冒险','校园','运动','科幻','少女','悬疑','恋爱','魔幻','机战','竞技','益智','剧情','历史','推理','原创','LOLI','真人','神话','亲子','教育','励志','战争']
    #mylist=['喜剧','动作','爱情','惊悚','犯罪','冒险','科幻','悬疑','剧情','动画','武侠','战争','歌舞','奇幻','传记','警匪','历史','运动','伦理','灾难','西部','魔幻','枪战','恐怖','记录']
    #mylist=['访谈','情感','选秀','旅游','美食','真人秀','脱口秀','曲艺','搞笑','游戏','歌舞','生活','音乐','时尚','益智','职场','少儿','纪实','盛会']
    mylist=["喜剧","偶像","家庭","古装","警匪","言情","军事","武侠","悬疑","历史","农村","都市","神话","科幻","儿童","搞笑","谍战","战争","年代","犯罪","恐怖","惊悚","爱情","剧情","奇幻"]
    for each in mylist:
        print(each),
        head='http://www.iqiyi.com/lib/dianshiju/'+parse.quote(each)+'%2C%2C_11_'
        middle=''
        tail='.html'
        f1='F:\\txt\\iqiyi数据\\名字2\\电视剧\\iqiyi'+each+'电视剧.txt'
        if(os.path.exists(f1)==True):
            print("文件已经存在")
            continue
        l=1
        while (l<=100):
            #if (l==76):
            print('第%d页'%(l)),
            middle=str(l)
            url=head+middle+tail
            result=iqiyi.getallmovie(url,f1)
            if(result>0):
                break
            l+=1
        print('下一个类型'),

def test4():
    '测试爬取mtime'
    browser = webdriver.Firefox()
    browser.get("http://movie.mtime.com/people/search/section/#constellation=1&bloodType=100&filmographyId=0")
    time.sleep(0.5)
    data=''
    k=1
    while(k<=10):
        data=browser.find_element_by_xpath('//html/body/div/div[@class=\'c_out\']/div/div/div[1]/div[1]/div[4]/ul/li[%d]/div[1]/div/div[1]/a'%(k)).get_attribute('title')
        print(data+',')
        data=browser.find_element_by_xpath('//html/body/div/div[@class=\'c_out\']/div/div/div[1]/div[1]/div[4]/ul/li[%d]/div[2]/div/div[1]/a'%(k)).get_attribute('title')
        print(data+','),
        k+=1
    browser.close()

def test5():
    '测试'
    mylist=['访谈','情感','选秀','旅游','美食','真人秀','脱口秀','曲艺','搞笑','游戏','歌舞','生活','音乐','时尚','益智','职场','少儿','纪实','盛会']
    f1='F:\\txt\\iqiyi数据\\名字\\综艺\\iqiyi'
    name='iqiyi全部综艺'
    optxt.merge(f1,mylist,name,'综艺')

def test6():
    "获取优酷指数"
    urllist=Tencent.urllist
    urllistnum=Tencent.urllistnum
    xpathlist=Tencent.xpathlist
    xpathlistnum=Tencent.xpathlistnum
    ffrom="F:\\txt\\iqiyi数据\\名字\\电影\\iqiyi全部电影.txt"
    fto="F:\\txt\\腾讯数据\\电影\\"
    prefix="tencent-"
    geturl=Tencent.geturl
    getdata=Tencent.getdata
    GetData.goget(urllist,urllistnum,xpathlist,xpathlistnum,ffrom,fto,prefix,geturl,getdata)

def test7():
    "测试百度"
    url="http://index.baidu.com"
    usernm="liuyuan624"
    passwd="ly4719743"
    name="李晨"
    browserProfile = webdriver.FirefoxProfile()
    #browserProfile.set_preference("layout.css.devPixelsPerPx","1.5")
    browserProfile.set_preference("browser.download.folderList",0)
    #browserProfile.set_preference("browser.download.dir","/home/liuyuan458/Documents/txt/百度")
    browserProfile.set_preference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream")
    browser = webdriver.Firefox(firefox_profile=browserProfile)
    browser.maximize_window() 
    browser.get(url)
    time.sleep(2)
    Baidu.loginfromindex(browser,usernm,passwd)
    time.sleep(4)
    Baidu.searchfromindex(browser,name)
    #for i in range(6):
    #Baidu.setsearchtime(browser,1)
    browser.execute_script("window.scrollBy(0,200)","")
    imgpath="/home/liuyuan458/Documents/txt/百度/测试4.png"
    browser.get_screenshot_as_file(imgpath)
    Baidu.getallpoints(browser,Baidu.getlegend(imgpath))
    browser.close()
    print("完成")

def test8(imgpath):
    "测试ocr"
    tools = pyocr.get_available_tools()[:]
    if len(tools) == 0:
        print("No OCR tool found")
        sys.exit(1)
    print("Using \'%s\'" % (tools[0].get_name()))
    langs = tools[0].get_available_languages()
    print("Available languages: %s" % ", ".join(langs))
    #lang = langs[0]
    print("Will use lang 'eng'")
    imgtxt=tools[0].image_to_string(Image.open(imgpath), lang="eng",builder=pyocr.builders.TextBuilder())
    print(imgtxt)
    return imgtxt

def test9():
    "测试百度指数图例图片下载"
    browserProfile = webdriver.FirefoxProfile()
    browserProfile.set_preference("browser.download.folderList",2)
    browserProfile.set_preference("browser.download.dir","/home/liuyuan458/Documents/txt/百度")
    browserProfile.set_preference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream")
    browser = webdriver.Firefox(firefox_profile=browserProfile)

#执行
test6()
#print(7/6)
