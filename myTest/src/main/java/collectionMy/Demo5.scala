package collectionMy

import java.util

/**
  * sclal中调用java的集合
  * 并将java的集合转换为scala自己特有的集合，然后返回
  */
object Demo5 {
    def main(args: Array[String]): Unit = {
        val a = new util.ArrayList[String]()
        a.add("huabingood")
        a.add("huangyuwei")

        import scala.collection.JavaConversions._
        a.foreach(println(_))
    }

}
