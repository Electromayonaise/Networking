#https://www.mapquest.com/directions/from/co-493843492/to/co-362957182
#https://api.chucknorris.io/jokes/categories

import urllib.parse
import requests
main_api = "https://www.mapquestapi.com/directions/v2/route?"
orig = "Cali, CO"
dest="Palmira, CO"

#USAR TU LLAVE OBTENIDA de el sitio developer de MapQuest
key = "S5QBdzNi6AtLvUfVdRTf5XRsrhn6LyYM" 
url = main_api + urllib.parse.urlencode({"key":key, "from": orig, "to": dest})
json_data=requests.get(url).json()
print(json_data) #mostrar respuesta de peticion