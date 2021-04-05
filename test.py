from selenium import webdriver
from objects import Button, Window, Objects,WebScraper
from selenium.webdriver import Chrome
import numpy
from flask import Flask, request, url_for, redirect, render_template


def getInformation(xpath, driver):
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


def getInformationTextbox(xpath, XpathText, driver):
    OBJECT = Button()
    OBJECTXPATH = driver.find_element_by_xpath(xpath)
    OBJECT.setXY(list(OBJECTXPATH.location.items()))
    OBJECT.setDimensions(list(OBJECTXPATH.size.items()))
    objectTitle = driver.find_element_by_xpath(XpathText)
    OBJECT.setLabel(objectTitle.text)
    print(OBJECT.getLabel())
    print(f"x: {OBJECT.getX()}")
    print(f"y: {OBJECT.getY()}")
    print(f"w: {OBJECT.getW()}")
    print(f"h: {OBJECT.getH()}")
    return OBJECT

app = Flask(__name__)



@app.route("/")
def home():
    WEB = WebScraper("http://discord.com")
    WEB.setDriver(Chrome())
    WEB.getDriverURL()
    WEB.maximizeDriver()

    WINDOW = Window()
    WINDOW.setXY(list(WEB.getDriver().get_window_size().items()))
    print(f"x: {WINDOW.getX()}")
    print(f"y: {WINDOW.getY()}")
    WEB.quitDriver()
    return render_template("home.html", winX = WINDOW.getX(), winY = WINDOW.getY())


@app.route("/start")
def start():
    WEB_HOME = WebScraper("http://discord.com")
    WEB_HOME.setDriver(Chrome())
    WEB_HOME.getDriverURL()
    WEB_HOME.maximizeDriver()

    WINDOW = Window()
    WINDOW.setXY(list(WEB_HOME.getDriver().get_window_size().items()))
    print(f"x: {WINDOW.getX()}")
    print(f"y: {WINDOW.getY()}")

    DOWNLOADBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a', WEB_HOME.getDriver())
    BROWSERBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button', WEB_HOME.getDriver())
    LOGINBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a',WEB_HOME.getDriver())
    WEB_HOME.quitDriver()
    return render_template('design.html', downX = DOWNLOADBUTTON.getX(), downY = DOWNLOADBUTTON.getY(), downW = DOWNLOADBUTTON.getW(), downH = DOWNLOADBUTTON.getH(), browX = BROWSERBUTTON.getX(), browY = BROWSERBUTTON.getY(), browW = BROWSERBUTTON.getW(), browH = BROWSERBUTTON.getH(),logX = LOGINBUTTON.getX(), logY = LOGINBUTTON.getY(), logW = LOGINBUTTON.getW(), logH = LOGINBUTTON.getH())

@app.route("/login")
def login():
    WEB_LOGIN = WebScraper("https://discord.com/login")
    WEB_LOGIN.setDriver(Chrome())
    WEB_LOGIN.getDriverURL()
    WEB_LOGIN.maximizeDriver()

    USERNAME = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/div/div[2]/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/h5', WEB_LOGIN.getDriver())
    PASSWORD = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/h5', WEB_LOGIN.getDriver())
    FORGOTPASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[1]/div',WEB_LOGIN.getDriver())
    LOGIN = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[2]',WEB_LOGIN.getDriver())
    REGISTER = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[3]',WEB_LOGIN.getDriver())
    QR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[3]', WEB_LOGIN.getDriver())
    WEB_LOGIN.quitDriver()
    return render_template('login.html', userX = USERNAME.getX(), userY = USERNAME.getY(), userW = USERNAME.getW(), userH = USERNAME.getH(), passX = PASSWORD.getX(), passY = PASSWORD.getY(), passW = PASSWORD.getW(), passH = PASSWORD.getH(), forgotX = FORGOTPASSWORD.getX(), forgotY = FORGOTPASSWORD.getY(), forgotW = FORGOTPASSWORD.getW(), forgotH = FORGOTPASSWORD.getH(), loginX = LOGIN.getX(), loginY = LOGIN.getY(), loginW = LOGIN.getW(), loginH = LOGIN.getH(), regX = REGISTER.getX(), regY = REGISTER.getY(), regW = REGISTER.getW(), regH = REGISTER.getH(), QRX = QR.getX(), QRY = QR.getY(), QRW = QR.getW(), QRH = QR.getH())

@app.route("/register")
def register():
    WEB_REGISTER = WebScraper("https://discord.com/register")
    WEB_REGISTER.setDriver(webdriver.Chrome())
    WEB_REGISTER.getDriverURL()
    WEB_REGISTER.maximizeDriver()

    EMAIL = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/h5',WEB_REGISTER.getDriver())
    USERNAME = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[2]', WEB_REGISTER.getDriver())
    PASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[3]',WEB_REGISTER.getDriver())
    BIRTHDAY = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/h5',WEB_REGISTER.getDriver())
    MONTH = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[1]',WEB_REGISTER.getDriver())
    DAY = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[2]',WEB_REGISTER.getDriver())
    YEAR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[3]',WEB_REGISTER.getDriver())
    CONTINUE = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[5]/button',WEB_REGISTER.getDriver())
    WEB_REGISTER.quitDriver()
    return render_template('register.html', emailX = EMAIL.getX(), emailY = EMAIL.getY(), emailW = EMAIL.getW(), emailH = EMAIL.getH(), userX = USERNAME.getX(), userY = USERNAME.getY(), userW = USERNAME.getW(), userH = USERNAME.getH(), passX = PASSWORD.getX(), passY = PASSWORD.getY(), passW = PASSWORD.getW(), passH = PASSWORD.getH(), monthX = MONTH.getX(), monthY = MONTH.getY(), monthW = MONTH.getW(), monthH = MONTH.getH(), dayX = DAY.getX(), dayY = DAY.getY(), dayW = DAY.getW(), dayH = DAY.getH(), yearX = YEAR.getX(), yearY = YEAR.getY(), yearW = YEAR.getW(), yearH = YEAR.getH(), contX = CONTINUE.getX(), contY = CONTINUE.getY(), contW = CONTINUE.getW(), contH = CONTINUE.getH())

@app.route("/join")
def join():
    return render_template('join.html')

@app.route("/joinServer")
def joinServer():
    return render_template('joinServer.html')

@app.route("/server")
def server():
    return render_template('server.html')

@app.route("/verification")
def verification():
    return render_template('verification.html')

@app.route("/confirmation")
def confirmation():
    return render_template('confirmation.html')

@app.route("/returningLogin")
def returningLogin():
    return render_template('returningLogin.html')

@app.route("/discord")
def discord():
    return render_template('discord.html')


@app.route("/joinServerOld")
def joinServerOld():
    return render_template('joinServer2.html')

@app.route("/link")
def link():
    return render_template('link.html')

@app.route("/discordServer")
def discordServer():
    return render_template('discordServer.html')


if __name__ == "__main__":
    app.run(debug = True)