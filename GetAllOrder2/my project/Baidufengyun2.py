import urllib.request
from bs4 import BeautifulSoup
import re
import string
from selenium import webdriver
import time
#from selenium.webdriver.common.keys import Keys
#from selenium.webdriver.common.action_chains import ActionChains

class Baidu():
	browser = webdriver.Firefox()
	'''
	browser.get("http://top.baidu.com/buzz?b=17&fr=topindex")
	time.sleep(3)
	f1='F:\\txt\\top50male.txt'
	fp=open(f1,'w',encoding='utf-8')
	fp.write(time.ctime()+'\n')
	'''
	def searchIndex():
		Baidu.browser.get("http://top.baidu.com/buzz?b=17&fr=topindex")
		time.sleep(2)
		baiduindex=[11111]*50
		numbers=Baidu.browser.find_elements_by_xpath("//td[@class='last']/span")
		i=0
		while(i<50):
			baiduindex[i]=numbers[i].text
			print(baiduindex[i])
			i=i+1
		return baiduindex
	
	
	
	
	def topname():
		nameli=[]
		nameli.append(Baidu.topmale())
		nameli.append(Baidu.topmovie())
		nameli.append(Baidu.toptvserial())
		nameli.append(Baidu.toptvshow())
		print(nameli)
		Baidu.browser.close()
		return nameli
		
	def topmale():
		maleli=[]
		male=[(['1111'] * 2) for i in range(50)]
		#male=[['11111']*2]*50
		#namemale=['aaa']*50
		#indexmale=['11111']*50
		Baidu.browser.get("http://top.baidu.com/buzz?b=17&fr=topindex")
		time.sleep(2)
		'''
		f1='F:\\txt\\top50male.txt'
		fp=open(f1,'w',encoding='utf-8')
		fp.write(time.ctime()+'\n')
		'''
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		numbers=Baidu.browser.find_elements_by_xpath("//td[@class='last']/span")
		i=0
		while(i<50):
			male[i][0]=top50[i].text
			male[i][1]=numbers[i].text
			maleli.append(male[i])
			#namemale[i]=top50[i].text
			#indexmale[i]=numbers[i].text
			#print(maleli[i])
			#print(indexmale[i])
			i=i+1
			'''
			name=man.text
			namemale[]
			#print(name)
			'''
			#print('\n')
			#fp.writelines(name)
			#fp.write('\n')
		#print(maleli)
		return maleli
	def topfemale():
		femaleli=[]
		female=[(['1111'] * 2) for i in range(50)]
		#namefemale=['aaa']*50
		Baidu.browser.get("http://top.baidu.com/buzz?b=18&c=9&fr=topbuzz_b17")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		numbers=Baidu.browser.find_elements_by_xpath("//td[@class='last']/span")
		i=0
		while(i<50):
			female[i][0]=top50[i].text
			female[i][1]=numbers[i].text
			femaleli.append(female[i])
			#namefemale[i]=top50[i].text
			#print(femaleli[i])
			i=i+1
		return femaleli
	def topmovie():
		movieli=[]
		movie=[(['1111'] * 2) for i in range(50)]
		#namemovie=['aaa']*50
		Baidu.browser.get("http://top.baidu.com/buzz?b=26&c=1&fr=topcategory_c1")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		numbers=Baidu.browser.find_elements_by_xpath("//td[@class='last']/span")
		i=0
		while(i<50):
			movie[i][0]=top50[i].text
			movie[i][1]=numbers[i].text
			movieli.append(movie[i])	
			#namemovie[i]=top50[i].text
			#print(movieli[i])
			i=i+1
		return movieli
			
	def toptvserial():
		tvserialli=[]
		tvserial=[(['1111'] * 2) for i in range(50)]
		#nametvserial=['aaa']*50
		Baidu.browser.get("http://top.baidu.com/buzz?b=4&c=2&fr=topcategory_c2")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		numbers=Baidu.browser.find_elements_by_xpath("//td[@class='last']/span")
		i=0
		while(i<50):	
			tvserial[i][0]=top50[i].text
			tvserial[i][1]=numbers[i].text
			tvserialli.append(tvserial[i])
			#print(tvserialli[i])
			i=i+1
		return tvserialli
	def toptvshow():
		tvshowli=[]
		tvshow=[(['1111'] * 2) for i in range(50)]
		#nametvshow=['aaa']*50
		Baidu.browser.get("http://top.baidu.com/buzz?b=19&c=3&fr=topcategory_c3")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		numbers=Baidu.browser.find_elements_by_xpath("//td[@class='last']/span")
		i=0
		while(i<50):
			tvshow[i][0]=top50[i].text
			tvshow[i][1]=numbers[i].text
			tvshowli.append(tvshow[i])
			#print(tvshowli[i])
			i=i+1
		return tvshowli
		'''
		f1='F:\\txt\\top50female.txt'
		fp=open(f1,'w',encoding='utf-8')
		fp.write(time.ctime()+'\n')
		
		top50=browser.find_elements_by_class_name("list-title")
		for man in top50:
			name=man.text
			print(name)
			#print('\n')
			fp.writelines(name)
			fp.write('\n')
		'''

#测试代码

Baidu.topname()
	#fp.close()

