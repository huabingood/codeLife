# -*- encoding:utf8 -*-

import urllib.request
from urllib import parse

url='http://www.sf-express.com/sf-service-owf-web/service/rate/newRates?origin=A4419001060&dest=A350524000&parentOrigin=A4419001060&parentDest=A350524000&weight=1.5&time=2018-07-12T15%3A30%3A00%2B08%3A00&volume=0&queryType=2&lang=sc&region=cn&translate='

header={
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "Accept-Language": "zh-CN,zh;q=0.9",
    "Connection": "keep-alive",
    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"
}


request=urllib.request.Request(url,headers=header)

response=urllib.request.urlopen(request)

print(response.read().decode('utf-8'))