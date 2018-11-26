##一.什么是倒排索引
倒排索引是一种搜索常用的算法。即形成 关键词-文档 的映射关系。普通的文档搜索是通过遍历整篇文档找关键词，费时费力。而
倒排索引是根据关键词找文档，这样只要搜索关键词，就能迅速的找到文档，类似日常中给文章设置tag.

##二.需求
共有三篇文档，需要将此三篇文档的所有词提取出来，然后以词作为键，文档名和该词出现的次数作为值

### 2.1 例如
a.txt
hello world
hello hadoop
hello mapreduce
hi java

b.txt
hi java
hi scala
hello python
hello c

c.txt
hello hive
hello hbase
hi hadoop
hello hadoop

### 2.2 输出结果
hello a.txt->3,b.txt->2,c.txt->3
world a.txt->1
hadoop a.txt->1,c.txt->2
…………


##三.注意事项
1.如何从map中获取当前分片的文件名
`String fileName = ((FileSplit)context.getInputSplit()).getPath().getName();`