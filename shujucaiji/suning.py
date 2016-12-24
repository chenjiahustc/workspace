from selenium import webdriver
from time import sleep
url = "http://search.suning.com/"
suning_locator ={
                 'searchContent' : '//*[@id="sTxt"]',
                 'searchOk' : '//*[@id="sBtn"]', 
                 }

def get_data():
        browser = webdriver.Chrome()
        browser.maximize_window()
        browser.get(url)
        browser.find_element_by_xpath(suning_locator['searchContent']).send_keys('new balance')
        browser.find_element_by_xpath(suning_locator['searchOk']).click()
        sleep(5)
        browser.find_element_by_xpath('//*[@id="filter-results"]/ul/li[4]').click()
        sleep(2)
        browser.switch_to_window(browser.window_handles[1])
        sleep(15)
        name = browser.find_element_by_xpath('//*[@id="productDisplayName"]').text
        print name
        sleep(1)
        price = browser.find_element_by_xpath('//*[@id="promoPrice"]').text
        print price[1:]
        sleep(1)
        cumuEvaluation = browser.find_element_by_xpath('//*[@id="hasPrice"]/div/dl[3]/a/div/span[2]').text
        print cumuEvaluation
        sleep(1)
        recentSales = browser.find_element_by_xpath('//*[@id="hasPrice"]/div/dl[3]/div/span[2]').text
        print recentSales
        sleep(1)
        numLabel = browser.find_element_by_xpath('//*[@id="partNumberLable"]').text
        print numLabel
        browser.find_element_by_xpath('//*[@id="hasPrice"]/div/dl[3]/a/div/span[2]').click()
        sleep(10)
        p = browser.find_element_by_xpath('//*[@id="rv-main"]/div/div[5]/div/div[1]/div[1]/div[2]/div[1]/div[2]/p').text
        print p
        p = browser.find_element_by_xpath('//*[@id="rv-main"]/div/div[5]/div/div[2]/div[1]/div[2]/div[1]/div[2]/p').text
        print p
        p = browser.find_element_by_xpath('//*[@id="rv-main"]/div/div[5]/div/div[3]/div[1]/div[2]/div[1]/div[2]/p').text        
        print p
        p = browser.find_element_by_xpath('//*[@id="rv-main"]/div/div[5]/div/div[4]/div[1]/div[2]/div[1]/div[2]/p').text        
        print p
        sleep(500)
        
get_data()
