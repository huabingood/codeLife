package simpleAlgorithm

import java.util

import scala.collection.mutable

object WCScala {
  def main(args: Array[String]): Unit = {
    val str = "abcdaabbcc"
    val wc = new mutable.HashMap[Char,Int]()
    val keys = wc.keySet

    for(c<-str){
      if(keys.contains(c)){
        wc.put(c,wc.getOrElse(c,0)+1)
      }else{
        wc.put(c,1)
      }
    }

    println(wc)



  }

}
