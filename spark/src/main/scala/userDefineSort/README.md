# 用户自定义排序

## 需求
对输入的数据先按照年龄排序，年龄相同的按照分数排序

## 解析
1. 类似与MR中的二次排序
2. 如何实现
   + 自定义类需要继承`Ordered`和`Serializable`类
   + 重写比较方法
   
`
case class Girl(val faceValue: Int, val age: Int) extends Ordered[Girl] with Serializable {
  override def compare(that: Girl): Int = {
    if(this.faceValue == that.faceValue) {
      that.age - this.age
    } else {
      this.faceValue -that.faceValue
    }
  }
}`

