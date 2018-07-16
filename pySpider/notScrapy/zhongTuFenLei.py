#-*-coding;utf-8 -*-



import requests
import json
from lxml import etree
import random
import threading


myOrderid="555201784430512"
ipNumsgetOnce='4'
format='json'
DaXiangDaiLiUrl='http://tpv.daxiangdaili.com/ip/'

url=DaXiangDaiLiUrl+'?tid='+myOrderid+'&num='+ipNumsgetOnce+'&format='+format


# 中图分类网址
zhongTuUrl = 'http://www.clcindex.com/'

# 请求头
head={
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "Accept-Language": "zh-CN,zh;q=0.9",
    "Connection": "keep-alive",
    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"
}

# 代理IP池
proxyIPPool=[]


'''
    从大象代理中获取代理IP，并放入IP池
'''
def getProxyIPPoor():
    proxyIPPoolsText = requests.get(url,headers=head).text
    proxyIPPoolJson = json.loads(proxyIPPoolsText)
    for proxyIP in proxyIPPoolJson:
        realProxyIP=proxyIP['host']+':'+str(proxyIP['port'])
        proxyIPPool.append(realProxyIP)
        # try:
        #     proxyIPs={'http':realProxyIP}
        #     response = requests.get(zhongTuUrl,headers=head,proxies=proxyIPs)
        #     httpCode=response.status_code
        #     if httpCode==200:
        #         print(realProxyIP+"测试通过！")
        #         proxyIPPool.append(realProxyIP)
        #     else:
        #         print(realProxyIP+"返回状态异常")
        #         continue
        # except Exception:
        #     print(realProxyIP+"抛出异常")
        #     print(Exception)

'''
    从代理线程池中随机获取一个代理IP，
    如果线程池中的代理小于2就新起一个线程获取代理
'''
def getProxyIP():
    if not proxyIPPool:
        getProxyIPPoor()
    if len(proxyIPPool)<2:
        t = threading.Thread(target=getProxyIP())
        t.setDaemon(True)
        t.start()
    proxyIP = random.choice(proxyIPPool)
    proxyIPMap={'http':proxyIP}
    return  proxyIPMap


'''
    解析网页，获取中图分类法
'''
def parseUrl(url):
    proxies=getProxyIP()
    try:
        response = requests.get(url,headers=head,proxies=proxies)
    except Exception:
        print(Exception)
        print("反正是异常")
    finally:
        parseUrl(url)

    print(response.text)
    html = etree.parse(response.text)
    print(html)
    fatherDiv = html.xpath('//*[@id="catTable"]/tbody/tr')

    for son in fatherDiv:
        endTr = son.xpath('./@id')[0].strip()
        if endTr=="tr-placeholder":
            continue
        else:
            zhongTuCode=son.xpath('./td[2]/text()')[0].strip()
            fatherValue=response.meta.get("fatherValue",'')
            nowValue=son.xpath('./td[3]/a/text()')[0].strip()
            zhongTuValue=fatherValue+nowValue
            nextPage=zhongTuUrl+son.xpath('./td[3]/a/@href')[0]
            print(zhongTuCode+"\t"+zhongTuValue)

            parseUrl(nextPage)


if __name__=='__main__':
    parseUrl('http://www.clcindex.com/')