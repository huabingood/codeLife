# -*- coding: utf-8 -*-
import scrapy

'''
主要是爬取链家网：
    1.需求：
        将链家上海网中所有的房屋信息进行爬取，获取其中的标题，图片，简介，位置，顾客信息，房价，面积，具体链接获取，并将该信息存入数据库
        将图片存储到本地，命名规范是标题名
    2.思路以及具体功能
        a.房屋基本信息的获取：标题，图片，简介，顾客信息，房价，面积，详情页链接，图片链接
'''







class LiajiatestSpider(scrapy.Spider):
    # 引擎名称
    name = 'lianjiaTest'
    allowed_domains = ['lianjia.com']
    start_urls = ['https://sh.lianjia.com/ershoufang/']    # 起始的url

    # scrapy内置的解析引擎
    def parse(self, response):
        # 将一个基本信息设为一个div块，然后从div块中获取我们需要的详情信息
        fatherDiv = response.xpath('/html/body/div[4]/div[1]/ul/li')
        for sons in fatherDiv:
            title = sons.xpath('./div[1]/div[1]/a/text()').extract_first('')
            print(title)



    '''
        解析出我们需要的信息，并将数据交给item进行处理
        实际上这里的代码相当于scrapy架构中的engine，由scheduler向互联网提出请求（他命令downloder向互联网提出请求，并接受返回的数据），并将返回的数据交给
        engine,然后engin负责具体的解析，并将解析后的数据交个item实例化一个对象，item对象交给pipline进行持久化
    '''
    def getDetail(self,response):
        pass
