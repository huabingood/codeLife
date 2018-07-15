# -*- coding: utf-8 -*-

import requests




myOrderid="555201784430512"
ipNumsgetOnce='1'
DaXiangDaiLiUrl='http://tpv.daxiangdaili.com/ip/'
url=DaXiangDaiLiUrl+'?tid='+myOrderid+'&num='+ipNumsgetOnce

head={
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "Accept-Language": "zh-CN,zh;q=0.9",
    "Connection": "keep-alive",
    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"
}



'''从大象代理中获取IP'''
def getIP():
    # 从大象代理中获取IP
    proxyIP = requests.get(url,headers=head).text
    # proxyIP = '176.31.71.157:3128';
    print('从大象代理中获取IP：'+proxyIP)
    return proxyIP

'''验证获取的IP是否可用'''
def getRealIP():
    http_url='http://www.baidu.com/'
    # 这个网址是验证公网IP的，可以用来验证数据是否走了代理
    # http_url='http://icanhazip.com/'
    proxyIP = getIP()
    proxyIPs={
        'http':proxyIP
    }

    response = requests.get(http_url,headers=head,proxies=proxyIPs)

    code = response.status_code
    while code!=200:
        getRealIP()
        print(proxyIP+"无法直接访问百度，重新从代理中获取IP！")
    print(proxyIP+"可以使用。")

    return proxyIP


if __name__ == '__main__':
    ip=getRealIP()
