import scala.io.StdIn._

object Conditional {
  def main(args: Array[String]): Unit = {
    print("Enter a number: ")
    val n = readInt()

    if (n > 0) println("Positive")
    else if (n < 0) println("Negative")
    else println("Zero")

    val result = if (n % 2 == 0) "Even" else "Odd"
    println(result)
  }
}
