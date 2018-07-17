# -*- coding:utf-8 -*-

import threading
import time


def println():
    for i in range(1,20):
        print("hyw")
        time.sleep(1)

# 如果这里多了一个括号，就不会是多线程了
t = threading.Thread(target=println)
t.start()

print('yhb')