#-*-coding;utf-8 -*-



import requests


'''
    测试阿布代理的连接性能
'''
# 要访问的目标页面
targetUrl = "http://test.abuyun.com/proxy.php"

# 代理服务器
proxyHost = "http-dyn.abuyun.com"
proxyPort = "9020"

# 代理隧道验证信息
proxyUser = "H4J7N7721S559Z1D"
proxyPass = "CD9DB618E6224FCA"

proxyMeta = "http://%(user)s:%(pass)s@%(host)s:%(port)s" % {
    "host" : proxyHost,
    "port" : proxyPort,
    "user" : proxyUser,
    "pass" : proxyPass,
}


proxies = {
    "http"  : proxyMeta,
    "https" : proxyMeta,
}

head={
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "Accept-Language": "zh-CN,zh;q=0.9",
    "Connection": "keep-alive",
    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"
}

# 请求
for  i in range(1,4):
    resp = requests.get(targetUrl, headers=head,proxies=proxies)
    # 输出结果
    print(resp.status_code)
    print(resp.text)

