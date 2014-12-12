package scalaForImpatient

import scala.collection.mutable.ArrayBuffer

class ChapterEight {

}

object ChapterEight {
  def main(args: Array[String]) {
    Bundle.addToCart(SimpleItem(1, "shoes"))
    Bundle.addToCart(SimpleItem(2, "cloth"))
    Bundle.addToCart(SimpleItem(3, "DVD"))

    println(Bundle.desc)
    
    
    var rect = new Rectangle(10,20)
    var circle = new Circle(23)
    println(rect.print)
    println(circle.print)
  }
}

//------------------------------------------------------------------------//

class BankAccount_2(initialBalance: Double) {
  protected var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(initialBalance: Double) extends BankAccount_2(initialBalance) {
  override def deposit(amount: Double) = { super.deposit(amount - 1) }
  override def withdraw(amount: Double) = { super.withdraw(amount + 1) }
}

class SavingsAccount(initialBalance: Double) extends BankAccount_2(initialBalance) {
  private var freeTradeCount = 3;
  var interest = 0.03

  def eranMonthlyInterest = freeTradeCount = 3; balance * interest
  override def deposit(amount: Double) = {
    if (freeTradeCount != 0) {
      freeTradeCount -= 1
      super.deposit(amount)
    } else {
      super.deposit(amount - 1)
    }
  }

  override def withdraw(amount: Double) = {
    if (freeTradeCount != 0) {
      freeTradeCount -= 1
      super.withdraw(amount)
    } else {
      super.withdraw(amount + 1)
    }
  }
}

//------------------------------------------------------------------------//
abstract class Item {
  def price: Double
  def desc: String
}

class SimpleItem(val price: Double, val desc: String) extends Item
object SimpleItem { def apply(price: Double, desc: String) = new SimpleItem(price, desc) }

object Bundle {
  val cart = new ArrayBuffer[Item]()
  var price = 0.0;
  def addToCart(item: Item) { cart += item; price += item.price }
  def desc = { for (item <- cart) yield item.desc }
}

//------------------------------------------------------------------------//
package local{
  /**
   * if var is not declared in the parameter, x and y can not be used in the other class
   */
	class Point(var x: Double,var y: Double)
	class LabeledPoint(label:String, x: Double, y: Double) extends Point(x, y)
} 
//------------------------------------------------------------------------//

abstract class Shape{
  def centerPoint: local.Point
  def print = {centerPoint.x + " " + centerPoint.y}
}

class Rectangle(length:Double, wide:Double) extends Shape{
  def centerPoint = new local.Point(length/2, wide/2)
}

class Circle(r:Double) extends Shape {
  def centerPoint = new local.Point(r, r)
}

//------------------------------------------------------------------------//
