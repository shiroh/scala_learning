package scalaForImpatient

import collection.mutable.{ Map, HashMap, SortedSet }

class ChapterThirteen
object ChapterThirteen {

  def main(args: Array[String]) {
	  var a = indexes("Mississippi")
	  println(a)
  }

  def indexes(str: String) = {
    var map = new scala.collection.mutable.HashMap[Char, SortedSet[Int]]
    var i = 0
    for (c <- str) {
      var entry = map.get(c)
      entry match {
        case Some(entry) => map(c) = entry + i
        case None => map += (c -> SortedSet(i))
      }
      i += 1
    }
    map
  }
  
  def divArr(arr:Array[Double], column:Int) = {
	  arr.grouped(column).toArray
  }
}