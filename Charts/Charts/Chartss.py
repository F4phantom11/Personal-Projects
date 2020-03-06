import pandas as pd
import matplotlib
import tkinter as tk
import numpy as np
import matplotlib.pyplot as plt
import mysql.connector as con
import datetime as da
def ActivtyHourChar(conn):
    cursor = conn.cursor()
    cursor.execute("Select * from activity")
    result = cursor.fetchall()
    hours = []
    Activity = []
    for x in result:
        if not Activity.__contains__(x[1]):
            hours.append(int(x[2]))
            Activity.append(x[1])
        else:
            hours[Activity.index(x[1])] += int(x[2])

    print(Activity)
    print(hours)
    x = np.arange(len(Activity))
    axs = plt.bar(x - .35 / 2, hours, .35, align='center', alpha=.5, label="TEst")
    plt.xticks(x, Activity)
    plt.show()

def AddToDB(conn):
    cursor = conn.cursor()
    val = ("Horrible", 30,"2","14","2020")
    cursor.execute("Insert into activity(activityName,hours,days,months,years) values(%s,%s,%s,%s,%s)",val)
    conn.commit()
def AddToDB(conn,act,hour,day,month,year):
    cursor = conn.cursor()
    val = (act, int(hour),day,month,year)
    cursor.execute("Insert into activity(activityName,hours,days,months,years) values(%s,%s,%s,%s,%s)",val)
    conn.commit()

def GetText():
    activity = Atext.get()
    hours = Htext.get()
    day = da.datetime.today().day
    month = da.datetime.today().month
    year = da.datetime.today().year
    Atext.selection_clear()
    AddToDB(conn,activity,hours,day,month,year)

conn = con.connect(host = "localhost",user ="root",passwd ="2Notebook1",database = "videogames",auth_plugin='mysql_native_password')
command = ""
screen = tk.Tk()
screen.geometry("500x300")
graph = tk.Button(screen,text = "This is o show graph",fg="green", command =lambda:ActivtyHourChar(conn= conn))
graph.place(relx= 0,x=0,y=0,anchor = "nw")
submit = tk.Button(screen,text = "Sumbit",fg="green", command =lambda :GetText())
submit.place(relx= 0,x=150,y=0,anchor = "nw")

Atext = tk.Entry(screen)
Atext.insert(tk.INSERT,"Enter Activity")
Atext.place(relx=0,x=40,y=30,anchor = "nw")
Htext = tk.Entry(screen)
Htext.insert(tk.INSERT,"Enter hours")
Htext.place(relx=0,x=40,y=100,anchor = "nw")
#graph.pack(side = tk.LEFT)
screen.mainloop()

while(command != "q"):
    command = input("Enter command")
    if command == "act":
        ActivtyHourChar(conn)
    elif command =="q":
        print("Exiting...")
    elif command =="add":
        AddToDB(conn)

    else:
        print("Invalid command")