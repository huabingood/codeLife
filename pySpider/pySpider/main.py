# -*- coding:utf-8 -*-

from scrapy.cmdline import execute

import sys
import os

# __file__ 表示当前文件夹
# os.path.abspath(__file__) 表示获取当前文件夹的路径
# os.path.dirname() 表示获取传入路径的子路径
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

# 执行scrapy ,需要三个参数，其中jobble指这个爬虫的名字
# 在调试之前，注意在setting.py 中不要遵循robots协议
execute(["scrapy","crawl","zhongTuFenLei"])
# execute(["scrapy","crawl","abu"])