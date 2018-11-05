class Customer {
  def buy(inputShoppingList: String): List[Fruit.Value] = {
    inputShoppingList.split("\\W").filter(s => s.nonEmpty && Fruit.values.map(_.toString).contains(s)).map(Fruit.withName).toList
  }

  def checkOut(shoppingCart: List[Fruit.Value]): Int = {
    checkOutSpecialOffers(shoppingCart)
  }

  private def checkOutSpecialOffers(shoppingCart: List[Fruit.Value]): Int = {
    val appleCount = shoppingCart.count(_.equals(Fruit.Apple))
    val orangeCount = shoppingCart.count(_.equals(Fruit.Orange))
    (appleCount / 2 + appleCount % 2) * Fruit.Apple.price + (orangeCount * 2 / 3 + orangeCount % 3) * Fruit.Orange.price
  }
}
