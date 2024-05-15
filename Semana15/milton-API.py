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
print("URL: " + (url))
json_status = json_data["info"]["statuscode"]
if json_status == 0:
    print("API Status: " + str(json_status) + " = A successful route call.\n")
    print("=============================================")
    print("Directions from " + (orig) + " to " + (dest))
    print("Trip Duration:   " + (json_data["route"]["formattedTime"]))
    print("Kilometers:      " + str("{:.2f}".format((json_data["route"]["distance"])*1.61)))
    # print("Fuel Used (Gal): " + str("{:.2f}".format((json_data["route"]["fuelUsed"])*3.78))) fuel used only available in USA
    for each in json_data["route"]["legs"][0]["maneuvers"]:
        print((each["narrative"]) + " (" + str("{:.2f}".format((each["distance"])*1.61) + " km)"))
    print("=============================================")

