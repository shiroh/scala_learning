package scalaForImpatient

class ChapterSix {

}

object ChapterSis {
  def main(args: Array[String]) {
	  var p = Point(3, 4)
	  println(p.x, p.y)
  }
}

object Conversions {
  def inchesToCentimeters(inches: Double) = inches + 1;
  def gallonsToLiters(gallons: Double) = gallons + 1
  def milesToKilometers(miles: Double) = miles + 1
}

abstract class UnitConversion {
  def convert(value: Double):Double
}

object InchesToCentimeters extends UnitConversion{
    def convert(value: Double) = {
    		value + 1
    }
}

class Point(var x: Double, var y: Double)
object Point {
  def apply(x: Double, y: Double) = new Point(x, y)
}