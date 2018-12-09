package commonFriends


import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object CommonFriends {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("CommonFriends")
      .setMaster("local[2]")

    val sc = new SparkContext(conf)

    val data = sc.parallelize(Array("A:B,C,D,F,E,O","B:A,C,E,K","C:F,A,D,I"))
    // 对数据进行拆分，形成（人，Array(友)）的元组
    // data的处理必须是flatMap，而不能是map；因为map返回的是一个整体，而flatmap返回的是整体中的一个部分
    // map和flatMap的区别详见：https://www.iwwenbo.com/spark-map-flatmap/
    val rdd1 = data.flatMap(str=>{
      val persons = str.split(":")
      val friends = persons(1).split(",")
      val personAndfriend:scala.collection.mutable.ListBuffer[(String,String)] = new ListBuffer[(String, String)]
      for(e<-friends){
        personAndfriend.append((e,persons(0)))
      }
      personAndfriend
    })
    // 形成（友，str(人人人人)）的形式
    val rdd2 = rdd1.reduceByKey((preSum,nowFriend)=>preSum+nowFriend)

    // 形成（人-人，友）的形式
    val rdd3 = rdd2.flatMap(t=>{
      val res:scala.collection.mutable.ListBuffer[(String,String)] = new ListBuffer[(String, String)]
      val friend = t._1
      val personsStr = t._2.toList.distinct
      if(personsStr.length>1) {
        for (i <- 0 to personsStr.length - 1) {
          for(j <- i+1 to personsStr.length-1){
            res.append((personsStr(i)+"-"+personsStr(j),friend))
          }
        }
      }else{
        res.append((personsStr(0).toString,friend))
      }
      res
    })

    // 形成（人-人,友）的形式
    val rdd4 = rdd3.reduceByKey((preSum,nowFriend)=>preSum+nowFriend)

    // 打印结果
    val rdd0 = rdd4.collect()
      .foreach(println(_))

    sc.stop()
  }
}
