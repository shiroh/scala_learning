package scalaForImpatient

class ChapterFive {

}

class Counter {
  private var _count = 0
  // Getter 
  def count = _count

  // Setter 
  def count_=(value: Int) { if (_count >= Int.MaxValue) _count = Int.MaxValue else _count = value }
}

abstract class BankAccount {
  val balance = 0

  def deposit(value: BigDecimal): BigDecimal
  def withdraw(value: BigDecimal): BigDecimal

}

class Time(hr: Int, min: Int) {
  private val hour = hr;
  private val minute = min;

  def before(other: Time): Boolean = {
    if (hour < other.hour)
      true
    else if (hour > other.hour)
      false
    else {
      if (minute <= other.minute)
        true
      else
        false
    }
  }
}

class NewTime(hr: Int, min: Int) {
  private val _min = hr * 24 + min
  def before(other: NewTime): Boolean = {
    if (_min <= other._min) true
    else false
  }
}

class Person(age: Int) {
  var _age = if (age < 0) 0 else age
}

class NewPerson(name: String) {
  val firstName = name.split(" ")(0)
  val lastName = name.split(" ")(1)

  println("firstName : " + firstName + " lastName : " + lastName)
}

//The parameter manufacotr and carType declaring here are used as members of the class
class Car(var manufactor: String, val carType: String) {
//	private var _manufactor = manufactor
	private var _carType = carType
	private var _year = 0
	var _brand = ""
	
	def this(manufactor:String, carType:String, year:Int, brand:String)
	{
	  this(manufactor, carType)
	  this._year = year
	  this._brand = brand
	}
	def this(manufactor:String, carType:String, brand:String)
	{
	  this(manufactor, carType)
	  this._brand = brand
	}
	def this(manufactor:String, carType:String, year:Int)
	{
	  this(manufactor, carType)
	  this._year = year
	}

	
	def changeMan(value: String) {
	  manufactor = value
	}
	
	def getMan() = manufactor
//	println(_manufactor + " " + _carType + " " + _year + " " +  _brand)
//	def manufactor_ = _manufactor 
	def carType_ = _carType
	def year_ = _year
	
}

class Employee(val name: String = "John Q. Public", var salary: Double = 0.0)


object ChapterFive {
  def main(args: Array[String]) {
    var c = new Counter();
    c.count = Int.MaxValue + 1;
    println(c.count)

    var t1 = new Time(11, 17)
    var t2 = new Time(13, 16)
    println(t1.before(t2))

    var t3 = new NewTime(11, 17)
    var t4 = new NewTime(13, 16)
    println(t1.before(t2))

    var p = new NewPerson("John Smith")
    
    var car1 = new Car("benz", "s555")
    var car2 = new Car("benz", "s555", 1965)
    var car3 = new Car("benz", "s555", "hala")
    var car4 = new Car("benz", "s555", 1955, "hala")
    
    println(car4.getMan())

    var e = new Employee()
    println(e.name  + " salar is: " + e.salary )
  }
}