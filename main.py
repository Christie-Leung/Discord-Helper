from selenium import webdriver
from objects import Button, Window, Objects,WebScraper
from selenium.webdriver.chrome.options import Options
from selenium.webdriver import Chrome
import numpy
from flask import request
from flask import Flask, request, url_for, redirect, render_template
import requests
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.common.exceptions import TimeoutException

#callable function to create button objects
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

# callable function to create button objects from textboxes
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



@app.route("/", methods=['GET', 'POST'])
# Main home page of web application
def home():
    chrome_options = Options()
    chrome_options.add_argument("--window-size=1440,823")
    chrome_options.add_argument("--headless")
    WEB = WebScraper("http://discord.com")
    WEB.setDriver(webdriver.Chrome(options=chrome_options, executable_path = PATH))
    WEB.getDriverURL()

    WINDOW = Window()
    WINDOW.setXY(list(WEB.getDriver().get_window_size().items()))
    print(f"x: {WINDOW.getX()}")
    print(f"y: {WINDOW.getY()}")
    WEB.quitDriver()
    return render_template("home.html", winX = WINDOW.getX(), winY = WINDOW.getY())

#Tutorial for new users
# tutorial for Discord website home page
@app.route("/start")
def start():
    chrome_options = Options()
    chrome_options.add_argument("--window-size=1440,823")
    chrome_options.add_argument("--headless")
    WEB_HOME = WebScraper("http://discord.com")
    WEB_HOME.setDriver(webdriver.Chrome(options=chrome_options, executable_path = PATH))
    WEB_HOME.getDriverURL()

    WINDOW = Window()
    WINDOW.setXY(list(WEB_HOME.getDriver().get_window_size().items()))
    print(f"x: {WINDOW.getX()}")
    print(f"y: {WINDOW.getY()}")

    DOWNLOADBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/a', WEB_HOME.getDriver())
    BROWSERBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[2]/div/div[2]/button', WEB_HOME.getDriver())
    LOGINBUTTON = getInformation('//*[@id="app-mount"]/div/div/div[1]/div[1]/header[2]/nav/div[2]/a',WEB_HOME.getDriver())
    WEB_HOME.screenshotDriver("home1.png")
    WEB_HOME.quitDriver()

    return render_template('start.html', downX = DOWNLOADBUTTON.getX(), downY = DOWNLOADBUTTON.getY(), downW = DOWNLOADBUTTON.getW(), downH = DOWNLOADBUTTON.getH(), browX = BROWSERBUTTON.getX(), browY = BROWSERBUTTON.getY(), browW = BROWSERBUTTON.getW(), browH = BROWSERBUTTON.getH(),logX = LOGINBUTTON.getX(), logY = LOGINBUTTON.getY(), logW = LOGINBUTTON.getW(), logH = LOGINBUTTON.getH(), TEXT = DOWNLOADBUTTON.setText(1), BROWTEXT = BROWSERBUTTON.setText(1), LOGINTEXT = LOGINBUTTON.setText(1))

# tutorial for login page
@app.route("/login")
def login():
    chrome_options = Options()
    chrome_options.add_argument("--window-size=1440,823")
    chrome_options.add_argument("--headless")
    WEB_LOGIN = WebScraper("https://discord.com/login")
    WEB_LOGIN.setDriver(webdriver.Chrome(options=chrome_options, executable_path = PATH))
    WEB_LOGIN.getDriverURL()

    USERNAME = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/div/div[2]/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/h5', WEB_LOGIN.getDriver())
    PASSWORD = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/h5', WEB_LOGIN.getDriver())
    FORGOTPASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[1]/div',WEB_LOGIN.getDriver())
    LOGIN = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[2]',WEB_LOGIN.getDriver())
    REGISTER = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[3]',WEB_LOGIN.getDriver())
    QR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[3]', WEB_LOGIN.getDriver())
    WebDriverWait(WEB_LOGIN.getDriver(), 1).until(EC.presence_of_element_located((By.XPATH, '//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[3]')))
    WEB_LOGIN.screenshotDriver("login1.png")
    WEB_LOGIN.quitDriver()
    return render_template('login.html', userX = USERNAME.getX(), userY = USERNAME.getY(), userW = USERNAME.getW(), userH = USERNAME.getH(), passX = PASSWORD.getX(), passY = PASSWORD.getY(), passW = PASSWORD.getW(), passH = PASSWORD.getH(), forgotX = FORGOTPASSWORD.getX(), forgotY = FORGOTPASSWORD.getY(), forgotW = FORGOTPASSWORD.getW(), forgotH = FORGOTPASSWORD.getH(), loginX = LOGIN.getX(), loginY = LOGIN.getY(), loginW = LOGIN.getW(), loginH = LOGIN.getH(), regX = REGISTER.getX(), regY = REGISTER.getY(), regW = REGISTER.getW(), regH = REGISTER.getH(), QRX = QR.getX(), QRY = QR.getY(), QRW = QR.getW(), QRH = QR.getH(), USERTEXT = USERNAME.setText(2), PASSTEXT = PASSWORD.setText(2), FORGOTTEXT = FORGOTPASSWORD.setText(2), LOGINTEXT = LOGIN.setText(2), REGISTERTEXT = REGISTER.setText(2), QRTEXT = QR.setText(2))

# tutorial for registering for an account
@app.route("/register")
def register():
    chrome_options = Options()
    chrome_options.add_argument("--window-size=1440,823")
    chrome_options.add_argument("--headless")
    WEB_REGISTER = WebScraper("https://discord.com/register")
    WEB_REGISTER.setDriver(webdriver.Chrome(options=chrome_options, executable_path = PATH))
    WEB_REGISTER.getDriverURL()

    EMAIL = getInformationTextbox('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/div/input','//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[1]/h5',WEB_REGISTER.getDriver())
    USERNAME = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[2]', WEB_REGISTER.getDriver())
    PASSWORD = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[3]',WEB_REGISTER.getDriver())
    BIRTHDAY = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/h5',WEB_REGISTER.getDriver())
    MONTH = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[1]',WEB_REGISTER.getDriver())
    DAY = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[2]',WEB_REGISTER.getDriver())
    YEAR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[4]/div[1]/div[3]',WEB_REGISTER.getDriver())
    CONTINUE = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/form/div/div[2]/div[5]/button',WEB_REGISTER.getDriver())
    WEB_REGISTER.screenshotDriver("register1.png")
    WEB_REGISTER.quitDriver()
    return render_template('register.html', emailX = EMAIL.getX(), emailY = EMAIL.getY(), emailW = EMAIL.getW(), emailH = EMAIL.getH(), userX = USERNAME.getX(), userY = USERNAME.getY(), userW = USERNAME.getW(), userH = USERNAME.getH(), passX = PASSWORD.getX(), passY = PASSWORD.getY(), passW = PASSWORD.getW(), passH = PASSWORD.getH(), monthX = MONTH.getX(), monthY = MONTH.getY(), monthW = MONTH.getW(), monthH = MONTH.getH(), dayX = DAY.getX(), dayY = DAY.getY(), dayW = DAY.getW(), dayH = DAY.getH(), yearX = YEAR.getX(), yearY = YEAR.getY(), yearW = YEAR.getW(), yearH = YEAR.getH(), contX = CONTINUE.getX(), contY = CONTINUE.getY(), contW = CONTINUE.getW(), contH = CONTINUE.getH(), EMAILTEXT = EMAIL.setText(2), USERTEXT = USERNAME.setText(2), PASSTEXT = PASSWORD.setText(2), DAYTEXT = DAY.setText(2), MONTHTEXT = MONTH.setText(2), YEARTEXT = YEAR.setText(2), CONTINUETEXT = CONTINUE.setText(2))

# tutorial for joining server
@app.route("/join")
def join():
    return render_template('join.html')

# tutorial for joining server with discord bot from link
@app.route("/joinServer")
def joinServer():
    return render_template('joinServer.html')

# show sample discord server page
@app.route("/server")
def server():
    return render_template('server.html')

# tutorial for verifying account
@app.route("/verification")
def verification():
    return render_template('verification.html')

# confirmation that user verfiied account
@app.route("/confirmation")
def confirmation():
    return render_template('confirmation.html')

#Tutorial for returning users to join server

#tutorial for logging in for returning users
@app.route("/returningLogin")
def returningLogin():
    return render_template('returningLogin.html')

# show discord page
@app.route("/discord")
def discord():
    return render_template('discord.html')

#tutorial on how to join server
@app.route("/joinServerOld")
def joinServerOld():
    return render_template('joinServer2.html')

# tutorial on how to join server from link
@app.route("/link")
def link():
    return render_template('link.html')

#open sample page of server
@app.route("/discordServer")
def discordServer():
    return render_template('discordServer.html')


if __name__ == "__main__":
    PATH = '/Users/Chelsea/Downloads/chromedriver'
    app.run(debug = True)