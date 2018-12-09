# 需求分析
## 日志格式如下：
1.中间使用`\t`作为分割符
```20160321101954	http://java.itcast.cn/java/course/javaeeadvanced.shtml
   20160321101954	http://java.itcast.cn/java/course/javaee.shtml
   20160321101954	http://java.itcast.cn/java/course/android.shtml
   20160321101954	http://java.itcast.cn/java/video.shtml
   20160321101954	http://java.itcast.cn/java/teacher.shtml
   20160321101954	http://java.itcast.cn/java/course/android.shtml
   20160321101954	http://php.itcast.cn/php/teacher.shtml
   20160321101954	http://net.itcast.cn/net/teacher.shtml
   20160321101954	http://java.itcast.cn/java/course/hadoop.shtml
```
## 业务需求：
1.根据日志，统计每个URL被点击的次数\
2.然后取出URL中的host,取每个host最多的前3