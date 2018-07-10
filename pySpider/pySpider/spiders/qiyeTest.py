# -*- coding: utf-8 -*-
import scrapy


class qiyetestSpider(scrapy.Spider):
    # 引擎名称
    name = 'qiyeTest'
    allowed_domains = ['cnblogs.com']
    start_urls = ['http://www.cnblogs.com/qiyeboy/category/793342.html']    # 起始的url

    # scrapy内置的解析引擎
    def parse(self, response):
        price = response.xpath('//*[@id="CategoryEntryList1_EntryStoryList_ctl00_Entries_TitleUrl_0"]/text()').extract_first('0')
        print(price)
        pass
