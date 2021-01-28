from flask import Flask, request, render_template, redirect
import os
from dao import sungjuk

app = Flask(__name__)
app.secret_key = "22gkrsus"

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/image_map")
def image_map():
    return render_template("image_map.html")

@app.route("/table_img")
def table_img():
    return render_template("table_img.html")

@app.route("/js_for")
def js_for():
    return render_template("js_for.html")

@app.route("/sungjukAct", methods=["GET", "POST","PUT","DELETE"])
def sungjukAct():
    if request.method == 'GET':
        return sungjuk.getSungjuk()
    elif request.method == 'POST':
        name = request.form['name1']
        kor = request.form['kor1']
        mat = request.form['mat1']
        eng = request.form['eng1']
        sungdata = {'name1': name, 'kor1':kor, 'mat1':mat, 'eng1':eng}
        return sungjuk.setSungjuk(sungdata)
    elif request.method == 'PUT':
        id5=request.form['id5']
        name=request.form['name1']
        kor=request.form['kor1']
        mat=request.form['mat']
        eng=request.form['eng']
        sungData = {'id5':id5, 'name1':name, 'kor1':kor, 'mat1':mat, 'eng1':eng}
        return sungjuk.putSungjuk(sungData)
    elif request.method == 'DELETE':
        id = request.form['id']
        return sungjuk.delSungjuk(id)


@app.route("/sungjuk")
def sungjuk_call():
    result = sungjuk.getSungjuk()
    return render_template("sungjuk.html", object_list = result)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)