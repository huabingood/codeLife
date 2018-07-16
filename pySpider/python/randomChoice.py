#-*-coding:utf-8 -*-

import random

'''
    验证python中的去随机值
'''


http_url=['http://www.baidu.com/',
          'http://www.sohu.com/',
          'http://www.sogou.com/',
          'http://www.sina.com.cn/',
          'http://www.163.com/',
          'http://v.qq.com/',
          'http://sh.meituan.com/',
          'http://neixin.cn/home/',
          'http://www.vip.com/',
          'http://www.189.cn/']

print(random.choice(http_url))
print(random.choices(http_url))