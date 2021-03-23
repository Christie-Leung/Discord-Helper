from selenium import webdriver
import numpy
from objects import Button


driver = webdriver.Safari()
driver.get("https://discord.com/channels/@me")
driver.maximize_window()

def getPosition(list):
    X = 0
    Y = 0
    for i in list:
        X = list[0][1]
        Y = list[1][1]
        return X, Y

def getInformation(xpath):
    object = driver.find_element_by_xpath(xpath)
    objectLabel = object.text
    objectPosition = object.location
    coorofObject = list(objectPosition.items())
    X, Y = getPosition(coorofObject)
    objectDimension = object.size
    sizeofObject = list(objectDimension.items())
    W, H = getPosition(sizeofObject)
    OBJECT = Button(X, Y, objectLabel, W, H)
    print(OBJECT.getLabel())
    print(OBJECT.getX())
    print(OBJECT.getY())
    print(OBJECT.getW())
    print(OBJECT.getH())
    return OBJECT

def getInformationTextbox(xpath, XpathText):
    object = driver.find_element_by_xpath(xpath)
    objectTitle = driver.find_element_by_xpath(XpathText)
    objectLabel = objectTitle.text
    objectPosition = object.location
    coorofObject = list(objectPosition.items())
    X, Y = getPosition(coorofObject)
    objectDimension = object.size
    sizeofObject = list(objectDimension.items())
    W, H = getPosition(sizeofObject)
    OBJECT = Button(X, Y, objectLabel, W, H)
    print(OBJECT.getLabel())
    print(OBJECT.getX())
    print(OBJECT.getY())
    print(OBJECT.getW())
    print(OBJECT.getH())
    return OBJECT

CREATESERVER = getInformation('//*[@id="app-mount"]/div[6]/div[2]/div/div/div[2]/div[1]')
JOINSERVER = getInformation('//*[@id="app-mount"]/div[6]/div[2]/div/div/div[2]/div[2]')
