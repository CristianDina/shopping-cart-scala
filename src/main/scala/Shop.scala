import scala.io.StdIn.readLine

object Shop {
  def main(args: Array[String]): Unit = {
    val input = readLine("Please provide your shopping list. Press ENTER to submit.\n")
    val customer = new Customer
    val shoppingCart = customer.buy(input)
    val total = customer.checkOut(shoppingCart)
    println("=> £" + total / 100 + "." + f"${total % 100}%02d")
  }
}
