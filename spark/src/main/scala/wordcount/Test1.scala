package wordcount

import org.apache.spark.{SparkConf, SparkContext}

object Test1 {

  def main(args: Array[String]): Unit = {
    // 获取配置文件
    val conf = new SparkConf().setAppName("WC")
    // 根据配置文件生成sc
    val sc = new SparkContext(conf)

    // 进行词频统计
    sc.textFile("hdfs:/ns1/user/hive/warehouse/books/")
      .flatMap(x => x.split("\t"))
      .map(x => (x, 1))
      .reduceByKey((_ + _))
      .collect()

    sc.stop()
  }
}
