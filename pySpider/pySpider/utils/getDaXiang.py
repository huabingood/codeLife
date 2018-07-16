# -*- coding: utf-8 -*-

import requests
import json
import random



myOrderid="555201784430512"
ipNumsgetOnce='1'
format='json'
DaXiangDaiLiUrl='http://tpv.daxiangdaili.com/ip/'

url=DaXiangDaiLiUrl+'?tid='+myOrderid+'&num='+ipNumsgetOnce

head={
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "Accept-Language": "zh-CN,zh;q=0.9",
    "Connection": "keep-alive",
    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"
}

ipPool=[]


'''从大象代理中获取IP'''
def getIP():
    # 从大象代理中获取IP
    proxyIP = requests.get(url,headers=head).text
    print(proxyIP)
    # proxyIP = '176.31.71.157:3128';

    return proxyIP



if __name__ == '__main__':
    ip=getIP()
