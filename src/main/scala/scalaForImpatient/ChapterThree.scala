package scalaForImpatient

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

class ChapterThree {

}
object ChapterThree {
  def main(args: Array[String]) {
    println(randomArray(10))
    println(replaceArray(Array(1, 2, 3, 4, 5)))
    println(avg(Array(1, 5, 6, 7, 10)))
    println(descending(ArrayBuffer(3, 1, 5, 6, 7, 10)))
    println(distinct(Array(3, 3, 1, 5, 6, 7, 5, 10)))
    println(timezoneSet)
  }

  def randomArray(n: Int) = {
    var r = new Random
    var array = ArrayBuffer[Int]()
    for (i <- 1 to n; num = r.nextInt if num > 0) {
      //      var num = r.nextInt;
      array += num
    }
    //    array.filter(_ > 0)
    array
  }

  def replaceArray(array: Array[Int]) = {

    val result = ArrayBuffer[Int]()
    for (i <- 0 until (array.length - 1, 2)) {
      result += array(i + 1)
      result += array(i)
    }
    if (array.length % 2 != 0)
      result += array(array.length - 1)

    result
  }

  def avg(array: Array[Double]) = {
    var sum = 0.0
    for (value <- array) {
      sum += value
    }
    sum / array.length
  }

  def descending(array: ArrayBuffer[Int]) = {
    var t = System.currentTimeMillis()
    //    val a = array.sortWith(_ > _)
    val a = array.toArray // ArrayBuffer => Array
    util.Sorting.quickSort(a)
    println(System.currentTimeMillis() - t)
    var b = new ArrayBuffer[Int] // Array => ArrayBuffer
    b ++= a
    b.reverse
  }

  def distinct(array: Array[Int]) = {
    var b = new ArrayBuffer[Int]
    b ++= array
    b.distinct
  }

  def timezoneSet = {
    var array = java.util.TimeZone.getAvailableIDs().filter((s: String) => s.startsWith("America"))
    //    array.map((s :String) => s.split("/")(1)).sortWith(_ < _).toSeq
    array.map(_.split("/")(1).sortWith(_ < _)).toSeq
  }
}