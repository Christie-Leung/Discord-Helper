from selenium import webdriver
import numpy
# download selenium and chrome driver


class Button:
    def __init__(self, X, Y, label):
        self.X = X
        self.Y = Y
        self.LABEL = label

    def getX(self):
        return self.X
    def getY(self):
        return self.Y

    def getLabel(self):
        return self.LABEL




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
    # I am using Chrome Developer Tool to get the Xpath, you might want to use your own code.
    buttonDownload = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a')
    elementDownload = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a')
    labelDownload = elementDownload.text
    position = buttonDownload.location
    coor = list(position.items())
    Xdown,Ydown =getPosition(coor)
    BUTTONDownloaded = Button(Xdown, Ydown, labelDownload)
    print(BUTTONDownloaded.getLabel())
    print(BUTTONDownloaded.getX())
    print(BUTTONDownloaded.getY())


    #button open discord in your browser
    buttonBrowser = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button')
    elementBrowser =  driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button')
    labelBrowser = elementBrowser.text
    positionBrowser = buttonBrowser.location
    coorBrowser = list(positionBrowser.items())
    Xbrow, Ybrow = getPosition(coorBrowser)
    BUTTONOFBROWSER = Button(Xbrow, Ybrow, labelBrowser)
    print(BUTTONOFBROWSER.getLabel())
    print(BUTTONOFBROWSER.getX())
    print(BUTTONOFBROWSER.getY())

    #login button
    buttonLogin = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[1]/nav/div/a')
    elementLogin = driver.find_element_by_xpath('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[1]/nav/div/a')
    labelLogin = elementLogin.text
    positionLogin = buttonLogin.location
    coorLogin = list(positionLogin.items())
    Xlog, Ylog = getPosition(coorLogin)
    BUTTONOFLOGIN = Button(Xlog, Ylog, labelLogin)
    print(BUTTONOFLOGIN.getLabel())
    print(BUTTONOFLOGIN.getX())
    print(BUTTONOFLOGIN.getY())