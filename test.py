from flask import Flask, request, url_for, redirect, render_template

app = Flask(__name__)

@app.route("/")
def home():
    return render_template("home.html")

@app.route("/start")
def start():
    return render_template('design.html')

@app.route("/login")
def login():
    return render_template('login.html')

@app.route("/register")
def register():
    return render_template('register.html')

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