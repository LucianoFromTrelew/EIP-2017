from flask import Flask, render_template
app = Flask(__name__)
@app.route("/")
def index():
    return render_template("index.html")

app.run(
    debug=True, 
    port=5000,
    # Si no ponemos nada, solo escucha en 127.0.0.1
    host='0'
)
