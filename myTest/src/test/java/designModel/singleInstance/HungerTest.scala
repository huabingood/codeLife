package designModel.singleInstance

import org.junit.Test

class HungerTest {
  @Test
  def testGetHungetInstance(): Unit = {
    val a = Hunger.getHungerInstance()
    val b = Hunger.getHungerInstance()

    if (a.equals(b)) {
      println("A和B是同一个对象")
    } else {
      println("A和B不是同一个对象")
    }
  }


}
