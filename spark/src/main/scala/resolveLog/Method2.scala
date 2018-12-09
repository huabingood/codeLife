package resolveLog

import java.net.URL

import org.apache.spark.{Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

/**
  * 采用自定义分区的方式，取分组的topN
  */
object Method2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("aa")
      .setJars(Array("/home/huabingood/IdeaProjects/codeLife/spark/target/spark-1.0-SNAPSHOT.jar"))
      .setMaster("spark://huabingood02:7077")
      .setExecutorEnv("SPARK_EXECUTOR_MEMORY","1G")


    val sc = new SparkContext(conf)

    // 按行读取数据
    // 并将数据中的host从URL中取出，拼接成元组（host,1）的方式返回
    val rdd1 = sc.textFile("hdfs://ns1/testData/t1/itcast.log")
      .map(line=>{
        val urls = line.split("\t")(1)
        val host = new URL(urls).getHost()
        (host,1)
      })
      .reduceByKey((preRes,nowNub)=>preRes+nowNub)

    val distinctHost = rdd1.map(t=>t._1).distinct().collect()

    val hostPartitions = new HostPartitions(distinctHost)

    // partitionBy 是指对数据按照给定的分区方式进行重新分区
    // partitionBy 是指一次处理一个分区的数据，该分区的数据在iterator中，并要求返回一个iterator
    val res = rdd1.partitionBy(hostPartitions)
      .mapPartitions(it=>{
        it.toList.reverse.take(3).toIterator
      })

    res.collect().foreach(println(_))

    sc.stop()

  }


}


/**
  * 自定义分区
  *   1. 集成Partitioner类
  *   2.重写两个方法
  *     分区数
  *     如何分区
  * @param distinctHosts
  */
class HostPartitions(distinctHosts:Array[String]) extends Partitioner{
  var i = 0
  val hostpartitions = new mutable.HashMap[String, Int]()
  // 将分区号和分区值放入map中，方便读取
  distinctHosts.foreach(e=>{
    hostpartitions+=(e->i)
    i+=1
  })
  // 一共有几个分区
  override def numPartitions: Int = hostpartitions.size
  // 如何判断当前数据进入哪个分区
  override def getPartition(key: Any): Int = {
    hostpartitions.getOrElse(key.toString,0)
  }


}