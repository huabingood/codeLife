package wordcount

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 统计词頻Demo
  */
object Test2 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("Test2")
      .setMaster("local[2]")
    val sc = new SparkContext(conf)

    // 获取数据构建RDD,这种方式通常用于测试
    // 第二种方式是使用 sc.textFile(path) 从HDFS或者本地文件系统获取数据
    val rdd1 = sc.parallelize(Array("huabingood","huabingood","love","hyw","huabingood","love","huabingood"))

    // 将数据进行拆分
    val res = rdd1
      // map对单个数组中的每一个元素，拼接成(单词,1)的元组形式
      .map(word=>(word,1))
      // 传入的元组是（前面所有的总和，本次的值）
      // 因为是统计词頻，所以 前面所有出现的次数 + 本次的值
      .reduceByKey((preRes,nowNum)=>preRes+nowNum)

    // collect是Action,foreach是scala中的函数，不是RDD的
    res.collect().foreach(println(_))

    sc.stop()
  }
}
