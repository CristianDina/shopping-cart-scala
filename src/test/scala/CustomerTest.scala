import org.scalatest.FunSuite

class CustomerTest extends FunSuite {
  test("Customer.buy - Happy Path") {
    val customer = new Customer
    assert(customer.buy("[ Apple, Apple, Orange, Apple ]") === List(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple))
  }

  test("Customer.buy - Extract only available fruits from input shopping list") {
    val customer = new Customer
    assert(customer.buy("[ Apple, Apple, Orange, Apple, Pie, Banana]") === List(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple))
  }

  test("Customer.buy - Extract despite chaotic input") {
    val customer = new Customer
    assert(customer.buy("  \n  AppleApple, \tOrange\n, ApplePie \n \t \r Apple \f") === List(Fruit.Orange, Fruit.Apple))
  }

  test("Customer.checkOut - Happy Path") {
    val customer = new Customer
    assert(customer.checkOut(List(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple)) === "=> £2.05")
  }
}

