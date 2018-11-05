class Customer {
  def buy(inputShoppingList: String):List[Fruit.Value] = {
    inputShoppingList.split("\\W").filter(s => s.nonEmpty && Fruit.values.map(_.toString).contains(s)).map(Fruit.withName).toList
  }

  def checkOut(shoppingCart: List[Fruit.Value]): String = {
    val total: Int = shoppingCart.map(_.price).sum
    "=> £" + total / 100 + "." + f"${total % 100}%02d"
  }
}
