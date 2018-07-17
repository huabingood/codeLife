# -*- coding: utf-8 -*-
import scrapy
from scrapy.http import Request
import sys
import time
import random
from pySpider.items import zhongTuFenLeiItem

class AbuProxyTest(scrapy.Spider):
    # 引擎名称
    name = 'abu'
    allowed_domains = ['abuyun.com']
    start_urls = ['http://test.abuyun.com/proxy.php']    # 起始的url

    def parse(self, response):
        for i in range(1,4):
            ip=response.xpath('/html/body/table/tbody/tr[3]/td/text()').extract_first('')
            aa = response.xpath('/html/body/table/tbody/tr[3]/th')
            UA = response.xpath('/html/body/table/tbody/tr[12]/td/text()').extract_first('')
            print('第'+str(i)+"此循环，获取的内容是：")
            print(response.body)
            print(aa)
            print(ip)
            print(UA)