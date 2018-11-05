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
    assert(customer.checkOut(List(Fruit.Apple, Fruit.Orange, Fruit.Orange, Fruit.Orange, Fruit.Apple)) === Fruit.Apple.price + Fruit.Orange.price * 2)
  }

  test("Customer.checkOut - Oranges special offer for exact number of oranges for special offer") {
    val customer = new Customer
    val count = 3
    assert(customer.checkOut(List.fill(count)(Fruit.Orange)) === getOrangesSpecialOffer(count))
  }

  test("Customer.checkOut - Oranges special offer and 1 extra orange") {
    val customer = new Customer
    val count = 4
    assert(customer.checkOut(List.fill(count)(Fruit.Orange)) === getOrangesSpecialOffer(count))
  }

  test("Customer.checkOut - Oranges special offer and 2 extra orange") {
    val customer = new Customer
    val count = 5
    assert(customer.checkOut(List.fill(count)(Fruit.Orange)) === getOrangesSpecialOffer(count))
  }

  test("Customer.checkOut - Apples special offer for exact number of apples for special offer") {
    val customer = new Customer
    val count = 2
    assert(customer.checkOut(List.fill(count)(Fruit.Apple)) === getApplesSpecialOffer(count))
  }

  test("Customer.checkOut - Apples special offer and 1 extra apple") {
    val customer = new Customer
    val count = 3
    assert(customer.checkOut(List.fill(count)(Fruit.Apple)) === getApplesSpecialOffer(count))
  }

  private def getOrangesSpecialOffer(count: Int): Int = Fruit.Orange.price * (count * 2 / 3 + count % 3)

  private def getApplesSpecialOffer(count: Int): Int = Fruit.Apple.price * (count / 2 + count % 2)
}


