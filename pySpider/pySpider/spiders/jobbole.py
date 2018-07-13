# -*- coding: utf-8 -*-
import scrapy




class jobBoleSpider(scrapy.Spider):
    # 引擎名称
    name = 'jobbole'
    allowed_domains = ['importnew.com']
    start_urls = ['http://www.importnew.com/all-posts']    # 起始的url


    # scrapy内置的解析引擎
    def parse(self, response):

        pass