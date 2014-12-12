package scalaForImpatient

class ChapterTwelve
object ChapterTwelve {
  def main(args: Array[String]) {
    var array = values(x => x * x, -5, 5)
    println(array)
    var max = array.reduceLeft((x: Int, y: Int) => if (x <= y) y else x)
    println(max)
    println(factorial(5))
    println(factorial(5))
    println(largest(x => 10 * x - x * x, 1 to 10))
    println(largestAt(x => 10 * x - x * x, 1 to 10)._2)
    
    println(adjustToPair(_*_)((6,7)))
    
    val pairs = (1 to 10) zip (11 to 20)
    println(pairs.map(adjustToPair(_+_)))
  }

  def values(fun: Int => Int, low: Int, high: Int) = for (i <- low to high) yield fun(i)

  def factorial(n: Int) = (1 to n).reduceLeft(_ * _)

  def factorial_2(n: Int) = (1 to n).foldLeft(5)(_ * _)

  def largest(fun: Int => Int, inputs: Seq[Int]) = inputs.map(fun).reduceLeft((x, y) => if (x <= y) y else x)

  //  def findLargest((index: Int, max: Int), input: Int) = {
  //    var v = 10 * x - x * x
  //    if (v > max)
  //      (x, v)
  //    else
  //      (index, max)
  //  }

  def f(ab: (Int, Int), x: Int) = {
    var v = 10 * x - x * x
    if (v > ab._1)
      (v, x)
    else
      (ab._1, ab._2)
  }
  def largestAt(fun: Int => Int, inputs: Seq[Int]) = inputs.foldLeft((0, 0))(f)

  def adjustToPair(fun: (Int, Int) => Int)(ab: (Int, Int)) = { fun(ab._1, ab._2) }
  
  def checkLength(sArray: Array[String], iArray: Array[Int]) = {sArray.corresponds(iArray)(_.length == _)}
  
  def corresponds_2(th: Seq[String], that: Seq[Int]) = ( fun: (Seq[String],Seq[Int]) => Boolean) => Boolean
//    val i = this.iterator
//    val j = that.iterator
//    while (i.hasNext && j.hasNext)
//      if (!p(i.next(), j.next()))
//        return false
//
//    !i.hasNext && !j.hasNext
//  }
  
  
}
