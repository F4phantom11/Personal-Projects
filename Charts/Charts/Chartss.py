import pandas as pd
import matplotlib.pyplot as plt
import mysql.connector as con
print ("hello")
conn = con.connect(host = "localhost",user ="root",passwd ="2notebook1",database = "videogames",auth_plugin='mysql_native_password')
cursor = conn.cursor()
cursor.execute("Select * from activity")
result = cursor.fetchall()


print(cursor.column_names)
data = []
for x in result:
    data.append([int(x[2]), int(x[3])])
    plt.plot([int(x[2])])







df = pd.DataFrame(data, columns= ['Test','wow'])

plt.show()