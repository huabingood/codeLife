# -*- coding: utf-8 -*-
import scrapy
from scrapy.http import Request
import sys
import time
import random
from pySpider.items import zhongTuFenLeiItem

class zhongTuFenLeiSpider(scrapy.Spider):
    # 引擎名称
    name = 'zhongTuFenLei'
    allowed_domains = ['clcindex.com']
    start_urls = ['http://www.clcindex.com']    # 起始的url

    # scrapy内置的解析引擎
    def parse(self, response):
        fatherUrl='http://www.clcindex.com'
        fatherDiv=response.xpath('//*[@id="catTable"]/tbody/tr')


        for son in fatherDiv:
            zhongTu = zhongTuFenLeiItem()

            # 如果循环的该列表中没有值，就直接跳出
            endTr = son.xpath('./@id').extract_first('不知道为什么没有取到值？！').strip()
            if endTr=="tr-placeholder":
                continue
            else:

                zhongTuCode=son.xpath('./td[2]/text()').extract_first('不知道为什么没有取到值？！').strip()
                fatherValue=response.meta.get("fatherValue",'')
                nowValue=son.xpath('./td[3]/a/text()').extract_first('不知道为什么没有取到值？！').strip()
                zhongTuValue=fatherValue+nowValue
                nextPage=fatherUrl+son.xpath('./td[3]/a/@href').extract_first('不知道为什么没有取到值？！')

                # 不知道为什么这种方式总是报变量未声明已使用的错误
                # zhongTuFenLeiItem = zhongTuFenLeiItem(zhongTuCode=zhongTuCode,zhongTuValue=zhongTuValue)
                # yield zhongTuFenLeiItem
                zhongTu["zhongTuCode"]=zhongTuCode
                zhongTu["zhongTuValue"]=zhongTuValue
                # print(str(zhongTu))
                yield zhongTu

                # print(zhongTuCode+'\t'+zhongTuValue)
                # print('-------------------------------------------')
                # print(nextPage)
                # sleepTime=[1,2,3]
                # time.sleep(random.choice(sleepTime))

                yield Request(url=nextPage,meta={"fatherValue":zhongTuValue,"change_proxy": True},callback=self.parse)