import json
import pymysql


def getConnection():
    return pymysql.connect(host="127.0.0.1", port=3306, user='root', password='22gkrsus',
                           use_unicode=True, db='sungjuk_test', autocommit=True)


def getSungjuk():
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("student_select")
    if cur.rowcount:
        result = cur.fetchall()
    # print(result)
    else:
        result = 0
    cur.close()
    conn.close()
    return result


def setSungjuk(sungData):
    conn = getConnection()
    cur = conn.cursor()
    print(sungData)
    args = (sungData['name1'], sungData['kor1'], sungData['mat1'], sungData['eng1'], 'IC00000001', 0)
    cur.callproc("student_insert", args)
    result = cur.rowcount
    cur.close()
    conn.close()
    return json.dumps({'rows': result})


def putSungjuk(sungData):
    conn = getConnection()
    cur = conn.cursor()
    args = (sungData['id5'], sungData['name1'], sungData['kor1'], sungData['mat1'], sungData['eng1'], 0)
    cur.callproc('student_update', args)
    cur.execute("select @_student_update_5")
    result = cur.fetchone()
    cur.close()
    conn.close()
    return json.dumps({'rows': result})


def delSungjuk(in_name):
    conn = getConnection()
    cur = conn.cursor()
    args = (in_name, 0)
    print(args)
    cur.callproc("student_delete", args)
    cur.execute("select @_student_delete_1")
    result = cur.fetchone()
    cur.close()
    conn.close()
    return json.dumps({'rows': result})


def sumSungjuk():
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("student_sum")
    if cur.rowcount:
        result = cur.fetchall()
    # print(result)
    else:
        result = 0
    cur.close()
    conn.close()
    return result
