from selenium import webdriver
import numpy
# download selenium and chrome driver


class Button:
    def __init__(self, X, Y, label, W, H):
        self.X = X
        self.Y = Y
        self.LABEL = label
        self.W = W
        self.H = H

    def getX(self):
        return self.X
    def getY(self):
        return self.Y

    def getLabel(self):
        return self.LABEL

    def getW(self):
        return self.W

    def getH(self):
        return self.H




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

    # I am using Chrome Developer Tool to get the Xpath, you might want to use your own code.
    buttonDownload = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a')
    elementDownload = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a')
    labelDownload = elementDownload.text
    position = buttonDownload.location
    dimensions = buttonDownload.size
    coor = list(position.items())
    size = list(dimensions.items())
    Xdown,Ydown =getPosition(coor)
    Width, Height = getPosition(size)
    BUTTONDownloaded = Button(Xdown, Ydown, labelDownload, Width, Height)
    print(BUTTONDownloaded.getLabel())
    print(BUTTONDownloaded.getX())
    print(BUTTONDownloaded.getY())
    print(BUTTONDownloaded.getW())
    print(BUTTONDownloaded.getH())



    #button open discord in your browser
    buttonBrowser = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button')
    elementBrowser =  driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button')
    labelBrowser = elementBrowser.text
    positionBrowser = buttonBrowser.location
    coorBrowser = list(positionBrowser.items())
    dimensionsBrowser = buttonBrowser.size
    sizeBrowser = list(dimensionsBrowser.items())
    WidthBrow, HeightBrow = getPosition(sizeBrowser)
    Xbrow, Ybrow = getPosition(coorBrowser)
    BUTTONOFBROWSER = Button(Xbrow, Ybrow, labelBrowser, WidthBrow, HeightBrow)
    print(BUTTONOFBROWSER.getLabel())
    print(BUTTONOFBROWSER.getX())
    print(BUTTONOFBROWSER.getY())
    print(BUTTONOFBROWSER.getW())
    print(BUTTONOFBROWSER.getH())

    #login button
    buttonLogin = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a')
    elementLogin = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a')
    labelLogin = elementLogin.text
    positionLogin = buttonLogin.location
    coorLogin = list(positionLogin.items())
    Xlog, Ylog = getPosition(coorLogin)
    dimensionsLogin = buttonLogin.size
    sizeLogin = list(dimensionsLogin.items())
    WidthLog, HeightLog = getPosition(sizeLogin)
    BUTTONOFLOGIN = Button(Xlog, Ylog, labelLogin, WidthLog, HeightLog)
    print(BUTTONOFLOGIN.getLabel())
    print(BUTTONOFLOGIN.getX())
    print(BUTTONOFLOGIN.getY())
    print(BUTTONOFLOGIN.getW())
    print(BUTTONOFLOGIN.getH())

    #set username
    """
    username = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/form')
    usernamebox = driver.find_element_by_xpath('// *[ @ id = "app-mount"] / div / div / div[1] / div[2] / div / div[2] / form / input')
    labelUsername = usernamebox.text
    positionUsername = username.location
    coorUsername = list(positionUsername.items())
    XUse, YUse = getPosition(coorUsername)
    dimensionsUsername = username.size
    sizeUsername = list(dimensionsUsername.items())
    WidthUse, HeightUse = getPosition(sizeUsername)
    BUTTONOFUSERNAME = Button(XUse, YUse, labelUsername, WidthUse, HeightUse)
    print(BUTTONOFUSERNAME.getLabel())
    print(BUTTONOFUSERNAME.getX())
    print(BUTTONOFUSERNAME.getY())
    print(BUTTONOFUSERNAME.getW())
    print(BUTTONOFUSERNAME.getH())
    """


