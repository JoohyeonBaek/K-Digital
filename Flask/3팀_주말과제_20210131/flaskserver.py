from flask import Flask, request, render_template, redirect
import os

from dao import project
from dao import sungjuk

from flask import session  # 요청이 이루어진 개인

app = Flask(__name__)
app.secret_key = "abc12340909"


@app.route("/")  # 경로배정 : 웹페이지의 루트가 /
def index():
    return render_template("index.html")  # 모델링 + 컬러 ; static 호출


@app.route("/user")
def user_call():
    result = project.getUser()
    result2 = project.getProduct()
    return render_template("user.html", object_list=result, object_list2=result2)


@app.route("/user_sum")
def user_sum():
    result = project.getUserSum()
    return render_template("user_sum.html", object_list=result)


@app.route("/product_sum")
def product_sum():
    result = project.prodSum()
    return render_template("product_sum.html", object_list=result)


@app.route("/seoul_sum")
def seoul_sum():
    result = project.seoulSum()
    return render_template("seoul_sum.html", object_list=result)


@app.route("/sungjukAct", methods=["GET", "POST", "PUT", "DELETE"])  # 성적
def sungjukAct():
    if request.method == 'GET':
        return sungjuk.getSungjuk()

    elif request.method == "POST":
        name = request.form['name1']
        kor = request.form['kor1']
        mat = request.form['mat1']
        eng = request.form['eng1']
        sungdata = {'name1': name, 'kor1': kor, 'mat1': mat, 'eng1': eng}
        return sungjuk.setSungjuk(sungdata)

    elif request.method == "PUT":
        id5 = request.form['id5']
        name = request.form['name1']
        kor = request.form['kor1']
        mat = request.form['mat1']
        eng = request.form['eng1']
        sungData = {'id5': id5, 'name1': name, 'kor1': kor, 'mat1': mat, 'eng1': eng}
        print(sungData)
        return sungjuk.putSungjuk(sungData)

    elif request.method == 'DELETE':
        id = request.form['id']
        print(id)
        return sungjuk.delSungjuk(id)


@app.route("/sungjuk")
def sungjuk_call():
    result = sungjuk.getSungjuk()
    result2 = sungjuk.sumSungjuk()
    return render_template("sungjuk.html", object_list=result, object_list2=result2)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
