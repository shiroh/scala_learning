package scalaForImpatient

import scala.collection.mutable.ArrayBuffer

class ChapterFour {

}
object ChapterFour {
  def main(args: Array[String]) {
    println(test0(Map("alice" -> 10, "bob" -> 20)))
    test7
    println(minmax(Array(1, 5, 2, 1, 1321, 543, 1, 0)))
    println(Iteqgt(Array(1, 5, 2, 1, 1321, 543, 1, 0),5))
    test10
  }

  def test0(map: Map[String, Int]) = {
    //how to use map()?
    for ((k, v) <- map) yield (k, v * 0.9)
  }

  def test7 {
    //TODO
    var map = Map[String, String]()
    var r = System.getProperties();
    var entrySet = r.entrySet()
    var iter = entrySet.iterator()
    while (iter.hasNext()) {
      var e = iter.next()
      map += (e.getKey().toString() -> e.getValue().toString())
    }
  }

  def minmax(values: Array[Int]) = {
    var arrayBuffer = new ArrayBuffer[Int]
    arrayBuffer ++= values
    var t = (arrayBuffer.min, arrayBuffer.max)
    t
  }

  def Iteqgt(values: Array[Int], v: Int) = {
	  var array = new ArrayBuffer[Int]
	  array ++= values
	  
	  (array.filter(_ < v).length, array.filter(_ == v).length, array.filter(_ > v).length)
  }
  
  def test10 {
    println("Hello".zip("World"))
    println(ArrayBuffer("Hello").zip(ArrayBuffer("World")))
  }
}