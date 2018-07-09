# -*- coding: utf-8 -*-
import scrapy


class LiajiatestSpider(scrapy.Spider):
    # 引擎名称
    name = 'lianjiaTest'
    allowed_domains = ['cnblogs.com']
    start_urls = ['https://bj.lianjia.com/ershoufang/rs%E4%B8%8A%E6%B5%B7%E8%99%B9%E5%8F%A3%E5%8C%BA/']    # 起始的url

    # scrapy内置的解析引擎
    def parse(self, response):

        pass
