package demo

object Demo3 {
  def main(args: Array[String]): Unit = {
    val list = List((1,2),(3,4),(5,6))

    val truple = list.map(t=>(t._1,t._2))

    truple.foreach(println(_))

  }

}
