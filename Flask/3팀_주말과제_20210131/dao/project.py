import json
import pymysql


def getConnection():
    return pymysql.connect(host="127.0.0.1", port=3306, user='root', password='22gkrsus',
                           use_unicode=True, db='project', autocommit=True)


def getUser():  # user 테이블 select
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("user_select")
    if cur.rowcount:
        result = cur.fetchall()
    else:
        result = 0
    cur.close()
    conn.close()
    return result


def getProduct():  # product 테이블 select
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("product_select")
    if cur.rowcount:
        result = cur.fetchall()
    else:
        result = 0
    cur.close()
    conn.close()
    return result


def getUserSum():
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("select_sum")
    if cur.rowcount:
        result = cur.fetchall()
    else:
        result = 0
    cur.close()
    conn.close()
    return result


def prodSum():
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("project_prod_sum")
    if cur.rowcount:
        result = cur.fetchall()
    else:
        result = 0
    cur.close()
    conn.close()
    return result


def seoulSum():
    conn = getConnection()
    cur = conn.cursor()
    cur.callproc("seoul_sum")
    if cur.rowcount:
        result = cur.fetchall()
    else:
        result = 0
    cur.close()
    conn.close()
    return result
