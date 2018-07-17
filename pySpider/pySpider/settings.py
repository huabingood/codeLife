# -*- coding: utf-8 -*-

# Scrapy settings for pySpider project
#
# For simplicity, this file contains only settings considered important or
# commonly used. You can find more settings consulting the documentation:
#
#     https://doc.scrapy.org/en/latest/topics/settings.html
#     https://doc.scrapy.org/en/latest/topics/downloader-middleware.html
#     https://doc.scrapy.org/en/latest/topics/spider-middleware.html

BOT_NAME = 'pySpider'

SPIDER_MODULES = ['pySpider.spiders']
NEWSPIDER_MODULE = 'pySpider.spiders'

# 设置日志等级
# LOG_LEVEL= 'WARNING'

# 如果请求超过某个时间段就会被干掉
DOWNLOAD_TIMEOUT=30

# 使用Feed将数据写到本地csv文件中
# 这种方式无需配置pipline,就能将数据保存到本地，但是无法对item进行过滤
# 如果想对item进行操作，必须设置pipline
FEED_URI = 'file:///home/huabingood/resutl/zhongTuFenLei.csv'
FEED_FORMAT = 'CSV'



# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'pySpider (+http://www.yourdomain.com)'
USER_AGENT='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36'

# 为 False 是不遵循robots协议
# Obey robots.txt rules
ROBOTSTXT_OBEY = False

# Configure maximum concurrent requests performed by Scrapy (default: 16)
CONCURRENT_REQUESTS = 10

# Configure a delay for requests for the same website (default: 0)
# See https://doc.scrapy.org/en/latest/topics/settings.html#download-delay
# See also autothrottle settings and docs
DOWNLOAD_DELAY = 0.2
RANDOMIZE_DOWNLOAD_DELAY=True
# The download delay setting will honor only one of:
#CONCURRENT_REQUESTS_PER_DOMAIN = 16
#CONCURRENT_REQUESTS_PER_IP = 16

# Disable cookies (enabled by default)
COOKIES_ENABLED = False

# Disable Telnet Console (enabled by default)
#TELNETCONSOLE_ENABLED = False

# 这个是UA设置
# Override the default request headers:
DEFAULT_REQUEST_HEADERS = {
  'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
  'Accept-Language': 'zh_CN',
  'User-Agent': 'Mozilla/5.0 (iPhone 84; CPU iPhone OS 10_3_3 like Mac OS X) AppleWebKit/603.3.8 (KHTML, like Gecko) Version/10.0 MQQBrowser/7.8.0 Mobile/14G60 Safari/8536.25 MttCustomUA/2 QBWebViewType/1 WKType/1',
}

# Enable or disable spider middlewares
# See https://doc.scrapy.org/en/latest/topics/spider-middleware.html
#SPIDER_MIDDLEWARES = {
#    'pySpider.middlewares.PyspiderSpiderMiddleware': 543,
#}

# Enable or disable downloader middlewares
# See https://doc.scrapy.org/en/latest/topics/downloader-middleware.html
DOWNLOADER_MIDDLEWARES = {
   #'pySpider.middlewares.PyspiderDownloaderMiddleware': 543,
  'pySpider.middlewares.ProxyMiddleware':100
}

# Enable or disable extensions
# See https://doc.scrapy.org/en/latest/topics/extensions.html
#EXTENSIONS = {
#    'scrapy.extensions.telnet.TelnetConsole': None,
#}

# Configure item pipelines
# See https://doc.scrapy.org/en/latest/topics/item-pipeline.html
#ITEM_PIPELINES = {
#    'pySpider.pipelines.PyspiderPipeline': 300,
#}

# 根据网速实现自动限速（限制一个线程的请求间隔）
# Enable and configure the AutoThrottle extension (disabled by default)
# See https://doc.scrapy.org/en/latest/topics/autothrottle.html
# 开启智能线束
# AUTOTHROTTLE_ENABLED = True
# The initial download delay
# 初始化线程延迟，默认是5秒，通常智能的延迟就是在这个值和实际相应时间的均值
# AUTOTHROTTLE_START_DELAY = 5
# The maximum download delay to be set in case of high latencies
# 最大延迟时间，反正我也不知道干嘛用的
# UTOTHROTTLE_MAX_DELAY = 60
# 请求线程的并发量
# The average number of requests Scrapy should be sending in parallel to
# each remote server
# AUTOTHROTTLE_TARGET_CONCURRENCY = 1.0
# 是否自动开启debug模式，调试的时候建议开启
# Enable showing throttling stats for every response received:
# AUTOTHROTTLE_DEBUG = False

# 将request缓存到本地，如果是调试建议放开注释
# Enable and configure HTTP caching (disabled by default)
# See https://doc.scrapy.org/en/latest/topics/downloader-middleware.html#httpcache-middleware-settings
#HTTPCACHE_ENABLED = True
#HTTPCACHE_EXPIRATION_SECS = 0
#HTTPCACHE_DIR = 'httpcache'
#HTTPCACHE_IGNORE_HTTP_CODES = []
#HTTPCACHE_STORAGE = 'scrapy.extensions.httpcache.FilesystemCacheStorage'
