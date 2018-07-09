# -*- coding: utf-8 -*-
import scrapy


class QiyetestSpider(scrapy.Spider):
    name = 'qiyeTest'
    allowed_domains = ['cnblogs.com']
    start_urls = ['http://cnblogs.com/']

    def parse(self, response):
        pass
