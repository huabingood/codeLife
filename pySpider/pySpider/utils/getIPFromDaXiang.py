# -*- coding: utf-8 -*-

import requests
import json
import random



myOrderid="555201784430512"
ipNumsgetOnce='4'
format='json'
DaXiangDaiLiUrl='http://tpv.daxiangdaili.com/ip/'

url=DaXiangDaiLiUrl+'?tid='+myOrderid+'&num='+ipNumsgetOnce+'&format='+format

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
    proxyIPs = requests.get(url,headers=head).text
    print(proxyIPs)
    # proxyIP = '176.31.71.157:3128';
    proxyIP = json.loads(proxyIPs)

    return proxyIP

'''验证获取的IP是否可用'''
def getRealIP():
    # 为了防止被干死，测试不同的网络
    # http_url=['http://icanhazip.com/',
    #           'https://www.qiniu.com/',
    #           'http://www.icbc.com.cn/icbc/',
    #           'http://www.abchina.com/cn/',
    #           'https://www.126.com/',
    #           'http://www.189.cn/']


    http_url=['http://www.clcindex.com/',
              'http://www.clcindex.com/',
              'http://www.clcindex.com/']

    # 这个网址是验证公网IP的，可以用来验证数据是否走了代理
    # http_url='http://icanhazip.com/'
    proxyIPs = getIP()

    # 声明一个接受
    for ip in proxyIPs:
        realIP=ip['host']+':'+str(ip['port'])
        # ipPool.append(realIP)
        # 验证IP是否可以访问
        proxyIPs={'http':realIP}
        try:
            response = requests.get(random.choice(http_url),headers=head,proxies=proxyIPs)
            code = response.status_code
            if code!=200:
                print("获取的IP："+realIP+"不可用，被丢弃！")
                continue
            else:
                ipPool.append(realIP)
                print("获取的IP："+realIP+"可用")
        except Exception:
                print("获取的IP："+realIP+"直接报错了")



'''
    随机获取一个IP返给scrapy
'''
def get1IP():
    ipNums = len(ipPool)
    if ipNums<2:
        getRealIP()
        print('因为长度为:'+str(ipNums)+',所以我被执行了。')
    print("被请求了，目前所有的IP是："+str(ipPool))
    return random.choice(ipPool)

'''
    删除列表中的一个IP
'''
def drop1IP(proxyIP):
    ipPool.remove(proxyIP)



if __name__ == '__main__':
    ip=get1IP()
