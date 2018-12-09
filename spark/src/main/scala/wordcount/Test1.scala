package wordcount

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Test1 {

  def main(args: Array[String]): Unit = {
    // 获取配置文件
    val conf = new SparkConf().setAppName("WC")
    // 根据配置文件生成sc
    val sc = new SparkContext(conf)

    // 进行词频统计
    sc.textFile("hdfs://ns1/user/hive/warehouse/hive_test.db/books/*")
      // 如果实在分不清flatMap和Map怎么使用，建议使用map
      // .map(line=>{ val words = line.split("\t");for(i <- words){ (i,1)};})
      .flatMap(x => x.split("\t"))
      .map(x => (x, 1))
      .persist(StorageLevel.MEMORY_AND_DISK)
      .reduceByKey((_ + _))
      .collect()

    sc.stop()
  }
}
