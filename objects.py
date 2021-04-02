from selenium import webdriver
import numpy
import requests


# download selenium and chrome driver


class Button:
    def __init__(self, X, Y, label, W, H):
        self.X = X
        self.Y = Y
        self.LABEL = label
        self.W = W
        self.H = H
        self.TEXT = none

    def getX(self):
        return self.X
    def getY(self):
        return self.Y

    def getLabel(self):
        return self.LABEL

    def getText(self):
        return self.TEXT

    def getW(self):
        return self.W

    def getH(self):
        return self.H

    def setText(BUTTONAME, STEPNUM):
        if self.LABEL == BUTTONNAME:
            request = requests.get(f'http://192.168.1.79:8080/api/step/{STEPNUM}/{BUTTONNAME}')
            self.TEXT = request.text



if __name__ == "__main__":

    def getPosition(list):
        X = 0
        Y = 0
        for i in list:
                X = list[0][1]
                Y = list[1][1]
                return X,Y



    driver = webdriver.Safari()
    driver.get("http://discord.com")
    driver.maximize_window()


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



    DOWNLOADBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a')
    BROWSERBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button')
    LOGINBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a')

    """
    stepNum = 1
    buttonName = "download"
    request = requests.get(f'http://192.168.1.79:8080/api/step/{stepNum}/{buttonName}')
    print(request.text)
    """










