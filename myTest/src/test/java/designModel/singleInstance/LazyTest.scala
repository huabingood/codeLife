package designModel.singleInstance

import org.junit.Test


class LazyTest {
  @Test
  def testGetInstance(): Unit = {
    val a = Lazy.getLazyInstance()
    val b = Lazy.getLazyInstance()

    if (a == b) {
      println("是同一个对象")
    } else {
      println("不是同一个对象")
    }
  }

}
