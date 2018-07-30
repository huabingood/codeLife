# -*- coding: utf-8 -*-

# Define here the models for your spider middleware
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/spider-middleware.html

from scrapy import signals
from  pySpider.utils import getIPFromDaXiang
import random
from pySpider.utils import getDaXiang


class PyspiderSpiderMiddleware(object):
    # Not all methods need to be defined. If a method is not defined,
    # scrapy acts as if the spider middleware does not modify the
    # passed objects.

    @classmethod
    def from_crawler(cls, crawler):
        # This method is used by Scrapy to create your spiders.
        s = cls()
        crawler.signals.connect(s.spider_opened, signal=signals.spider_opened)
        return s

    def process_spider_input(self, response, spider):
        # Called for each response that goes through the spider
        # middleware and into the spider.

        # Should return None or raise an exception.
        return None

    def process_spider_output(self, response, result, spider):
        # Called with the results returned from the Spider, after
        # it has processed the response.

        # Must return an iterable of Request, dict or Item objects.
        for i in result:
            yield i

    def process_spider_exception(self, response, exception, spider):
        # Called when a spider or process_spider_input() method
        # (from other spider middleware) raises an exception.

        # Should return either None or an iterable of Response, dict
        # or Item objects.
        pass

    def process_start_requests(self, start_requests, spider):
        # Called with the start requests of the spider, and works
        # similarly to the process_spider_output() method, except
        # that it doesn’t have a response associated.

        # Must return only requests (not items).
        for r in start_requests:
            yield r

    def spider_opened(self, spider):
        spider.logger.info('Spider opened: %s' % spider.name)


class PyspiderDownloaderMiddleware(object):
    # Not all methods need to be defined. If a method is not defined,
    # scrapy acts as if the downloader middleware does not modify the
    # passed objects.

    @classmethod
    def from_crawler(cls, crawler):
        # This method is used by Scrapy to create your spiders.
        s = cls()
        crawler.signals.connect(s.spider_opened, signal=signals.spider_opened)
        return s

    def process_request(self, request, spider):
        # Called for each request that goes through the downloader
        # middleware.

        # Must either:
        # - return None: continue processing this request
        # - or return a Response object
        # - or return a Request object
        # - or raise IgnoreRequest: process_exception() methods of
        #   installed downloader middleware will be called
        return None

    def process_response(self, request, response, spider):
        # Called with the response returned from the downloader.

        # Must either;
        # - return a Response object
        # - return a Request object
        # - or raise IgnoreRequest
        return response

    def process_exception(self, request, exception, spider):
        # Called when a download handler or a process_request()
        # (from other downloader middleware) raises an exception.

        # Must either:
        # - return None: continue processing this exception
        # - return a Response object: stops process_exception() chain
        # - return a Request object: stops process_exception() chain
        pass

    def spider_opened(self, spider):
        spider.logger.info('Spider opened: %s' % spider.name)



# IP 代理的相关设置
class ProxyMiddleware(object):
    EXCEPTIONS_TO_CHANGE = (TimeoutError, ConnectionRefusedError, ValueError)
    '''从代理中发出请求'''
    def process_request(self,request,spider):

        if request.url.startswith('http://'):
            proxy = 'http://'+ getIPFromDaXiang.get1IP()
            request.meta['proxy']=proxy
        else:
            proxy = 'https://'+getIPFromDaXiang.get1IP()
        print(proxy+"调用")
        request.meta['proxy']=proxy



    ''' 验证代理访问是否存在问题，如果存才问题，就重新请求一次代理IP
        主要处理访问异常（有错误码返回的情况）
    '''
    def process_response(self, request, response, spider):
        # 如果返回的response状态不是200，重新生成当前request对象
        if response.status != 200:
            print(request.meta.get('proxy')+"在本次请求中无法使用，错误代码是："+str(response.status))
            # proxyHost = request.meta.get('proxy').split('//')[1]
            # getIPFromDaXiang.drop1IP(proxyHost)
            # 根据协议头拼接代理的协议
            if request.url.startswith('http://'):
                proxy = 'http://'+ getIPFromDaXiang.get1IP()
                request.meta['proxy']=proxy
            else:
                proxy = 'https://'+ getIPFromDaXiang.get1IP()
                request.meta['proxy']=proxy
                return request
        else:
            return response

    '''
        如果代理存在问题，就切换代理再次访问
        主要处理没有返回的异常，比如直接被拒绝之类的
    '''
    def process_exception(self, request, exception, spider):
        print("代理连接异常，重新获取")
        print(exception)
        if isinstance(exception, self.EXCEPTIONS_TO_CHANGE):
            proxyHost = request.meta.get('proxy').split('//')[1]
            getIPFromDaXiang.drop1IP(proxyHost)

            if request.url.startswith('http://'):
                proxy = 'http://'+ getIPFromDaXiang.get1IP()
                request.meta['proxy']=proxy
            else:
                proxy = 'https://'+ getIPFromDaXiang.get1IP()
                request.meta['proxy']=proxy
            return request