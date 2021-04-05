from selenium import webdriver
from selenium.webdriver import Chrome
import numpy
from objects import Button, Window, Objects


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
    objectxpath = driver.find_element_by_xpath(xpath)
    objectTitle = driver.find_element_by_xpath(XpathText)
    OBJECT.setLabel(objectTitle.text)
    OBJECT.setXY(list(objectxpath.location.items()))
    OBJECT.setDimensions(list(objectxpath.size.items()))
    print(OBJECT.getLabel())
    print(f"x: {OBJECT.getX()}")
    print(f"y: {OBJECT.getY()}")
    print(f"w: {OBJECT.getW()}")
    print(f"h: {OBJECT.getH()}")
    return OBJECT


driver = webdriver.Safari()
driver.get("https://discord.com/login")
driver.maximize_window()


USERNAME = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/div/div[2]/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/h5')
PASSWORD = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/h5')
FORGOTPASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[1]/div')
LOGIN = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[2]')
REGISTER = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[3]')
QR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[3]')
