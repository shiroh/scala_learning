package scalaForImpatient

import scala.math.Ordered
import java.awt._
import scala.collection.Iterable
import scala.collection.mutable.ArrayBuffer

class ChapterTen {

}
object ChapterTen {
  def main(args: Array[String]) {

  }
}

class OrderedPoint(var p: java.awt.Point) extends Ordered[java.awt.Point] {
  def compare(that: java.awt.Point) = {
    if (p.getX() <= that.getX() && p.getY() < that.getY()) -1
    else if (p.getX() == that.getX() && p.getY() == that.getY()) 0
    else 1
  }
}

