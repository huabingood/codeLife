package oopTest

import oop.VariableInitialValue
import org.junit.Test

/**
  * 描述：
  * 使用scala编写测试类，以后的测试类都可以使用scala进行编写
  *
  * @author huabingood@qq.com
  * @create 2018-09-05
  * @version 1.0
  */
class VariableInitialValueScalaTest {
  @Test
  def getAllTest(): Unit = {
    val va = new VariableInitialValue()
    va.getAll()
  }

}
