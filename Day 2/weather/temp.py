import requests
import json
import time

t = time.time()
x = requests.get('https://www.metaweather.com/api/location/2487956/', params = {"q": "consolidated_weather"})
data = x.json()

print(data)

# print("London temperature is ", data["consolidated_weather"][0]["the_temp"])
print("It took seconds to get that info", time.time() - t)