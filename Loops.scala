object Loops {
  def main(args: Array[String]): Unit = {
    println("For loop:")
    for (i <- 1 to 5) println(i)

    println("While loop:")
    var i = 1
    while (i <= 5) {
      println(i)
      i += 1
    }
  }
}
