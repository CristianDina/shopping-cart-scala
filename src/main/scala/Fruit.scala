object Fruit extends Enumeration {

  protected case class Val(price: Int) extends super.Val {}

  implicit def price(x: Value): Val = x.asInstanceOf[Val]

  val Apple = Val(60)
  val Orange = Val(25)
}
