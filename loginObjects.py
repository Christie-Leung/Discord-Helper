from selenium import webdriver
import numpy
from objects import Button

def getPosition(list):
    X = 0
    Y = 0
    for i in list:
        X = list[0][1]
        Y = list[1][1]
        return X, Y


driver = webdriver.Safari()
driver.get("https://discord.com/login")
driver.maximize_window()

# Login username
setusername = driver.find_element_by_xpath('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/div/div[2]/input')
usernameTitle = driver.find_element_by_xpath('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[1]/h5')
usernameLabel = usernameTitle.text
positionofUsername = setusername.location
coorofUsername = list(positionofUsername.items())
XUser, YUser = getPosition(coorofUsername)
dimensionsofUsername = setusername.size
sizeofUsername = list(dimensionsofUsername.items())
WidthUser, HeightUser = getPosition(sizeofUsername)
BUTTONSETUSER = Button(XUser, YUser, usernameLabel, WidthUser, HeightUser)
print(BUTTONSETUSER.getLabel())
print(BUTTONSETUSER.getX())
print(BUTTONSETUSER.getY())
print(BUTTONSETUSER.getW())
print(BUTTONSETUSER.getH())

#Password
enterPass = driver.find_element_by_xpath('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/div/input')
passTitle = driver.find_element_by_xpath('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[2]/h5')
passLabel = passTitle.text
positionofPass = enterPass.location
coorofPass = list(positionofPass.items())
XPass, YPass = getPosition(coorofPass)
dimensionsofPass = enterPass.size
sizeofPass = list(dimensionsofPass.items())
WidthPass, HeightPass = getPosition(sizeofPass)
BUTTONPASS = Button(XPass, YPass, passLabel, WidthPass, HeightPass)
print(BUTTONPASS.getLabel())
print(BUTTONPASS.getX())
print(BUTTONPASS.getY())
print(BUTTONPASS.getW())
print(BUTTONPASS.getH())

#forgot Password
forgotPass = driver.find_element_by_xpath('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[1]/div')
forgotPassLabel = forgotPass.text
positionofForgotPass = forgotPass.location
coorofForgotPass = list(positionofForgotPass.items())
XForgotPass, YForgotPass = getPosition(coorofForgotPass)
dimensionsofForgotPass = forgotPass.size
sizeofForgotPass = list(dimensionsofForgotPass.items())
WidthForgotPass, HeightForgotPass = getPosition(sizeofForgotPass)
BUTTONFORGOTPASS = Button(XForgotPass, YForgotPass, forgotPassLabel, WidthForgotPass, HeightForgotPass)
print(BUTTONFORGOTPASS.getLabel())
print(BUTTONFORGOTPASS.getX())
print(BUTTONFORGOTPASS.getY())
print(BUTTONFORGOTPASS.getW())
print(BUTTONFORGOTPASS.getH())

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

LOGIN = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/button[2]')
REGISTER = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[1]/div[3]/div[3]')
QR = getInformation('//*[@id="app-mount"]/div[2]/div/div[2]/div/div/form/div/div/div[3]')
