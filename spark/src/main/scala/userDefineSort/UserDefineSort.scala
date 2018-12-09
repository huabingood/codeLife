package userDefineSort

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 用户自定义排序规则
  */
object UserDefineSort {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("aa")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(List(("yuihatano", 90, 28, 1), ("angelababy", 90, 27, 2),("JuJingYi", 95, 22, 3)))
    // 按照指定的排序规则排序
    val rdd2 = rdd1.sortBy(t=>MySort(t._2,t._3),false)

    rdd2.collect().foreach(println(_))

    sc.stop()
  }
}

/**
  * 用户自定义排序规则的类
  * 继承Ordered主要是为类排序，Serializable是为了实现序列化
  * @param age
  * @param score
  */
case class MySort(age:Int,score:Int) extends Ordered[MySort] with Serializable{
  // 排序规则：先按年龄比，然后按分数比较
  override def compare(that: MySort): Int = {
    if(this.age==that.age){
      this.score-that.score
    }else{
      this.age-that.age
    }
  }
}