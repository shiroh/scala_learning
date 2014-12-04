package scalaForImpatient

class ChapterTwo {
  def check(num: Int) = {
    if (num > 0) 1
    else if (num < 0) -1
    else 0
  }

  def forLoop {
    var a = 0 to 10
    for (i <- (0 to 10).reverse) print(i)
  }

  // n is val , reassignment to a val error will be raised if use n directly instead of num
  def countDown(n: Int) {
    var num = n
    while (num >= 0) {
      print(num + " ")
      num -= 1
    }
  }

  def manipulate(s: String) = {
    var num: Long = 1
    for (c <- s) {
      num *= c.toInt
    }
    num
  }

  def manipluate_2(s: String) = {
    //    s.foldLeft(num)((a,b)=>a*b.toInt)
    s.foldLeft(1L)(_ * _.toInt)
  }

  def manipulate_3(s: String): Long = {
    if (s.isEmpty())
      1L
    else
      s.head.toInt * manipulate_3(s.tail)
  }
}

object ChapterTwo {
  val ct = new ChapterTwo;

  def main(args: Array[String]) {
    test0(100)
    println(test1)
    test3
    println()
    test4(15)
    println()
    test5("Hello")
  }

  def test0(num: Int) {
    println(ct.check(num));
  }

  def test1() {}

  def test3 {
    ct.forLoop
  }

  def test4(n: Int) {
    ct.countDown(n)
  }

  def test5(s: String) {
    println(ct.manipulate(s))
    println(ct.manipluate_2(s))
    println(ct.manipulate_3(s))
  }
}