from flask import Flask, request, url_for, redirect, render_template

app = Flask(__name__)

@app.route("/")
def home():
    return render_template("home.html")

@app.route("/start", methods=['GET', 'POST'])
def start():
    if request.method == 'POST':
        return redirect(url_for('start'))


if __name__ == "__main__":
    app.run(debug = True)