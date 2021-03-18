from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def page():
    return render_template("design.html")

if __name__ == "__main__":
    #urlStep = input("Please input url: ")
    #if urlStep == "https://discord.com":
        #app.run()
    app.run()