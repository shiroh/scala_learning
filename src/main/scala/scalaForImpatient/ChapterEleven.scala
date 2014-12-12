package scalaForImpatient

class ChapterEleven {
}
object ChapterEleven {
  def main(args: Array[String]) {
    Q1
    println(Money(0, 50) - Money(1, 75))
    var f = RichFile("/home/shijun/git", "playgroung", "scala")
    var f2 = f
  }

  def Q1 {
    println(3 + 4 -> 5)
    var a = 3 -> 4 + 5.toString
    println(a)
  }
}

class Money(var dollar: Int, var cent: Int) {
  def +(other: Money) = {
    var flag = false; var newCent = 0; var newDollar = 0

    if (cent + other.cent > 100) { flag = true; newCent = cent + other.cent - 100 }
    else newCent = cent + other.cent

    if (flag) newDollar = dollar + other.dollar + 1 else newDollar = dollar + other.dollar
    Money(newDollar, newCent)
  }
  def -(other: Money) = {
    var flag = false; var newCent = 0; var newDollar = 0
    if (cent - other.cent < 0) { flag = true; newCent = cent - other.cent + 100 }
    else newCent = cent - other.cent
    if (flag) newDollar = dollar - other.dollar - 1 else newDollar = dollar - other.dollar
    Money(newDollar, newCent)
  }

  def ==(other: Money) = dollar == other.dollar && cent == other.cent
  override def toString = dollar + " " + cent
}
object Money {
  def apply(dollar: Int, cent: Int) = new Money(dollar, cent)
}

class RichFile(var path: String, var file: String, var ext: String)
object RichFile {
  def apply(path: String, file: String, ext: String) = new RichFile(path, file, ext)
  def unapply(input: RichFile) = Some(input.path, input.file, input.ext)
}

