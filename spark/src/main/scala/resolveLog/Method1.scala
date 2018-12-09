package resolveLog

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 根据日志，统计每个URL被点击的次数
  * 然后取出URL中的host,取每个host最多的前3
  *
  * 这里的分组取前3是一种很傻的方式，就是分别将含有特殊host的去出来，然后在内存中排序，输出
  * 很容易就会导致OOM的问题
  */

object Method1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("Method1")
    val sc = new SparkContext(conf)

    val rmap = sc.textFile("hdfs://ns1/testData/t1/itcast.log")
    // 获取三个分别输出；
    // take()是任意获取3个，top是排序后获取，但是要通过隐式转换获取排序规则
    rmap.take(3)
        .foreach(println(_))

    // 将数据按行输入，然后按照\t进行切割；
    // 将切割出来的url部分取出，然后组成（url,1）这种元组给传出
    // flatMap是将数据的一行当数组，而map是将输入的一行当字符串
    val rflatmap = rmap.map(line=>{
      val urls = line.split("\t")
      (urls(1),1)
    })

    // reduceByKey中间传入的函数实际上是 计算 value 中的值的。就是MR中Reduce函数的核心，让前面的值之和+后面的值
    // 这里输出的是一个元组，（key,累加后的和）
    val rreduce = rflatmap.reduceByKey((preRes,nextNum)=>preRes+nextNum)

    val rmap2 = rreduce.map(t=>{
      val host = new URL(t._1).getHost()
      (host,t._1,t._2)
    })

    // sortBy()和sortByKey()默认按照升序进行排列，传入false，表示不按照升序排列
    // sortByKey()只能按照key进行排序，且只对二元祖有效；但是sortBy()可以按照指定的字段进行排序，可以针对多元祖
    val rsortByKey = rmap2.sortBy(t=>t._3,false)

    // 取出各个前三的数据
    val top3 = rsortByKey.filter(t=>t._1.equals("java.itcast.cn"))
        .sortBy(t=>t._3,false)
        .take(3)





    sc.stop()
  }

}
