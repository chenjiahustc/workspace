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
	
	
	
	
	
	
	def topname():
		nameli=[]
		nameli.append(Baidu.topmale())
		nameli.append(Baidu.topfemale())
		nameli.append(Baidu.topmovie())
		nameli.append(Baidu.toptvserial())
		nameli.append(Baidu.toptvshow())
		print(nameli)
		Baidu.browser.close()
		return nameli
		
	def topmale():
		namemale=['aaa']*10
		Baidu.browser.get("http://top.baidu.com/buzz?b=17&fr=topindex")
		time.sleep(2)
		'''
		f1='F:\\txt\\top50male.txt'
		fp=open(f1,'w',encoding='utf-8')
		fp.write(time.ctime()+'\n')
		'''
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		i=0
		while(i<10):
			namemale[i]=top50[i].text
			print(namemale[i])
			i=i+1
			'''
			name=man.text
			namemale[]
			#print(name)
			'''
			#print('\n')
			#fp.writelines(name)
			#fp.write('\n')
		return namemale
	def topfemale():
		namefemale=['aaa']*10
		Baidu.browser.get("http://top.baidu.com/buzz?b=18&c=9&fr=topbuzz_b17")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		i=0
		while(i<10):
			namefemale[i]=top50[i].text
			print(namefemale[i])
			i=i+1
		return namefemale
	def topmovie():
		namemovie=['aaa']*10
		Baidu.browser.get("http://top.baidu.com/buzz?b=26&c=1&fr=topcategory_c1")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		i=0
		while(i<10):
			namemovie[i]=top50[i].text
			print(namemovie[i])
			i=i+1
		return namemovie
			
	def toptvserial():
		nametvserial=['aaa']*10
		Baidu.browser.get("http://top.baidu.com/buzz?b=4&c=2&fr=topcategory_c2")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		i=0
		while(i<10):
			nametvserial[i]=top50[i].text
			print(nametvserial[i])
			i=i+1
		return nametvserial
	def toptvshow():
		nametvshow=['aaa']*10
		Baidu.browser.get("http://top.baidu.com/buzz?b=19&c=3&fr=topcategory_c3")
		time.sleep(2)
		top50=Baidu.browser.find_elements_by_class_name("list-title")
		i=0
		while(i<10):
			nametvshow[i]=top50[i].text
			print(nametvshow[i])
			i=i+1
		return nametvshow
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

Baidu.topname()
	#fp.close()