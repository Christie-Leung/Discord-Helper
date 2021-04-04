from selenium import webdriver
from objects import Button, Window, Objects
import numpy



driver = webdriver.Safari()
driver.get("https://discord.com/register")
driver.maximize_window()

def getInformation(xpath):
    OBJECT = Button()
    object = driver.find_element_by_xpath(xpath)
    OBJECT.setLabel(object.text)
    OBJECT.setXY(list(object.location.items()))
    OBJECT.setDimensions(list(object.size.items()))
    print(OBJECT.getLabel())
    print(f"x: {OBJECT.getX()}")
    print(f"y: {OBJECT.getY()}")
    print(f"w: {OBJECT.getW()}")
    print(f"h: {OBJECT.getH()}")
    return OBJECT

def getInformationTextbox(xpath, XpathText):
    OBJECT = Button()
    object = driver.find_element_by_xpath(xpath)
    objectTitle = driver.find_element_by_xpath(XpathText)
    OBJECT.setLabel(objectTitle.text)
    OBJECT.setXY(list(object.location.items()))
    OBJECT.setDimensions(list(object.size.items()))
    print(OBJECT.getLabel())
    print(f"x: {OBJECT.getX()}")
    print(f"y: {OBJECT.getY()}")
    print(f"w: {OBJECT.getW()}")
    print(f"h: {OBJECT.getH()}")
    return OBJECT


EMAIL = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/h5')
USERNAME = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[2]')
PASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[3]')
BIRTHDAY = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/h5')
MONTH = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[1]')
DATE = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[2]')
YEAR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[3]')
CONTINUE = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[5]/button')
