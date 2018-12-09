package sparkSQL


import org.apache.spark.sql.SparkSession


object RDD2DF {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("RDD2DF")
      .master("local[2]")
      .getOrCreate()

    val sc = spark.sparkContext

    var dataRdd = sc.textFile("file:///home/huabingood/testData/itcast.log")

    val getMetaData = dataRdd.flatMap(line => line.split("\t"))
      .map(words => ipLog(words(0).toString, words(1).toString))

    import spark.implicits._

    val getDS = getMetaData.toDS()
      .createOrReplaceTempView("ipLog")

    val sqlDS = spark.sql("select * from ipLog")

    sqlDS.show()



    dataRdd.collect().foreach(println(_))

    sc.stop()
  }
}

case class ipLog(timeStamp: String, url: String)