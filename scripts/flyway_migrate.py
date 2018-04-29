
import os
import pymysql

def create_db():
    db=pymysql.connect(host='localhost',user="root",passwd="123456")
    cursor=db.cursor()
    cursor.execute('show databases')
    cursor.execute("drop database if exists ziwu_db")
    cursor.execute("create database if not exists ziwu_db")
    cursor.close()
    os.system("mvn flyway:migrate")
create_db()

# /Library/Frameworks/Python.framework/Versions/3.7/bin/python3.7 ./scripts/flyway_migrate.py
