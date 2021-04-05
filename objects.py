from selenium import webdriver
from selenium.webdriver import Chrome
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


    def setText(BUTTONAME, STEPNUM):
        if self.LABEL == BUTTONNAME:
            request = requests.get(f'http://192.168.1.79:8080/api/step/{STEPNUM}/{BUTTONNAME}')
            self.TEXT = request.text


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

    def maximizeDriver(self):
        return self.DRIVER.maximize_window()

    def quitDriver(self):
        return self.DRIVER.quit()






if __name__ == "__main__":
    def getInformation(xpath,driver):
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


    def getInformationTextbox(xpath, XpathText,driver):
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



    WEB_HOME = WebScraper("http://discord.com")
    WEB_HOME.setDriver(webdriver.Safari())
    WEB_HOME.getDriverURL()
    WEB_HOME.maximizeDriver()


    WINDOW= Window()
    WINDOW.setXY(list(WEB_HOME.getDriver().get_window_size().items()))
    print(f"x: {WINDOW.getX()}")
    print(f"y: {WINDOW.getY()}")


    DOWNLOADBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a', WEB_HOME.getDriver())
    BROWSERBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button',WEB_HOME.getDriver())
    LOGINBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a',WEB_HOME.getDriver())
    WEB_HOME.quitDriver()

    WEB_LOGIN = WebScraper("https://discord.com/login")
    WEB_LOGIN.setDriver(webdriver.Safari())
    WEB_LOGIN.getDriverURL()
    WEB_LOGIN.maximizeDriver()

    USERNAME = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/div/div[2]','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/h5',WEB_LOGIN.getDriver())
    PASSWORD = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/h5',WEB_LOGIN.getDriver())
    FORGOTPASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[1]/div',WEB_LOGIN.getDriver())
    LOGIN = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[2]',WEB_LOGIN.getDriver())
    REGISTER = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[3]',WEB_LOGIN.getDriver())
    QR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[3]',WEB_LOGIN.getDriver())
    WEB_LOGIN.quitDriver()

    WEB_REGISTER = WebScraper("https://discord.com/register")
    WEB_REGISTER.setDriver(webdriver.Safari())
    WEB_REGISTER.getDriverURL()
    WEB_REGISTER.maximizeDriver()


    EMAIL = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/h5',WEB_REGISTER.getDriver())
    USERNAME = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[2]',WEB_REGISTER.getDriver())
    PASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[3]',WEB_REGISTER.getDriver())
    BIRTHDAY = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/h5',WEB_REGISTER.getDriver())
    MONTH = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[1]',WEB_REGISTER.getDriver())
    DATE = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[2]',WEB_REGISTER.getDriver())
    YEAR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[3]',WEB_REGISTER.getDriver())
    CONTINUE = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[5]/button',WEB_REGISTER.getDriver())
    WEB_REGISTER.quitDriver()


    """
    stepNum = 1
    buttonName = "download"
    request = requests.get(f'http://192.168.1.79:8080/api/step/{stepNum}/{buttonName}')
    print(request.text)
    """










