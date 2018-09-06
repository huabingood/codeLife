package oopTest.animailDemo

import oop.amimailDemo.{AnimalImple, Cat}
import org.junit.Test

/**
  * 描述：
  *
  * @author huabingood@qq.com
  * @create 2018-09-06
  * @version 1.0
  */
class CatTest {

  @Test
  def testPolymorphic(): Unit = {
    val ai = new Cat("喵喵", 1)
    ai.jump(ai)
    ai.eat(ai)
    ai.myOnly()
  }

}
