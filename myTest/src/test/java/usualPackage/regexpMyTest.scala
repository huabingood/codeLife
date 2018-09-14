package usualPackage

import org.junit.Test

/**
  *
  * 描述：
  * 使用scala写的测试类
  *
  * @author huabingood@qq.com
  * @create 2018-09-13
  * @version 1.0
  */
class regexpMyTest {
  val regexpMy = new RegexpMy()

  @Test
  def isMatchTest(): Unit = {
    val str = "ababc@asa.com.cn"
    val regexp = "[a-zA-Z_0-9]+@\\.[a-zA-Z]+com\\.cn"
    val b = regexpMy.isMatch(str, regexp)
    println(b)
  }

  @Test
  def regexpSplit(): Unit = {
    val str = "tool.chinaz.com"
    val regexp = "(\\w+\\.){2}(\\w+)"
    val index = 0
    val result = regexpMy.regexpSplit(str, regexp, index)
    println(result)
  }
}
