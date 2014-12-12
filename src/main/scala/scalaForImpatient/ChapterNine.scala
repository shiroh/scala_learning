package scalaForImpatient

import scala.io.Source

class ChapterNine {

}
object ChapterNine {
  def main(args: Array[String]) {
//	  FileReader.reverseLines
//	  FileReader.replaceTab
	  FileReader.findWord
  }
}

object FileReader {
  def reverseLines {
    var source = Source.fromFile("landmark.txt")
    var lines = source.getLines.toArray.reverse
    for(l <- lines)
      println(l)
  }
  
  def replaceTab {
    var source = Source.fromFile("landmark.txt")
    var content = source.mkString
    var c = content.replace("""\t""", "    ")
    println(c)
  }

  def findWord {
    for(w <- Source.fromFile("helloworld.txt").mkString.split(" ").filter(_.length() > 3)) println(w)
  }
}

