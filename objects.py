from selenium import webdriver
from selenium.webdriver import Chrome
from selenium.webdriver.chrome.options import Options
import numpy
import requests


# download selenium and chrome driver

class Objects:
    def __init__(self):
        self.X = None
        self.Y = None

    def getX(self):
        return self.X

    def getY(self):
        return self.Y

    def setXY(self,list):
        for i in list:
            self.X = list[0][1]
            self.Y = list[1][1]
            return self.X, self.Y



class Button(Objects):
    def __init__(self):
        super().__init__()
        self.LABEL = None
        self.W = None
        self.H = None
        self.TEXT = None


    def getLabel(self):
        return self.LABEL

    def setLabel(self,label):
        self.LABEL = label

    def getText(self):
        return self.TEXT

    def getW(self):
        return self.W

    def getH(self):
        return self.H


    def setDimensions(self,list):
        for i in list:
            self.H = list[0][1]
            self.W = list[1][1]
            return self.W, self.H


    def setText(self,STEPNUM):
        requestText = requests.get(f'http://localhost:8080/api/step/{STEPNUM}/{self.LABEL}')
        self.TEXT = str(requestText.text)
        return self.TEXT


class Window(Objects):
    def __init__(self):
        super().__init__()

class WebScraper():
    def __init__(self, URL):
        self.URL = URL
        self.DRIVER = None

    def setDriver(self, DRIVER):
        self.DRIVER = DRIVER

    def getDriverURL(self):
        return self.DRIVER.get(self.URL)

    def getDriver(self):
        return self.DRIVER

    def quitDriver(self):
        return self.DRIVER.quit()

    def screenshotDriver(self,NAME):
        self.DRIVER.save_screenshot(f"static/images/{NAME}")





if __name__ == "__main__":
    stepNum = 1
    buttonName = "login"
    request = requests.get(f'http://localhost:8080/api/step/{stepNum}/{buttonName}')
    print(request.text)











