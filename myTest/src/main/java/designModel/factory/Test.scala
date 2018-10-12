package designModel.factory

/**
  * 测试工厂模式
  */
object Test {
  def main(args: Array[String]): Unit = {
    val ming = new MingDynasty()
      .getDynastyInstance()
    ming.emperor()
  }
}
