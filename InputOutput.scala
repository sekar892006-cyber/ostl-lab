import scala.io.StdIn._

object InputOutput {
  def main(args: Array[String]): Unit = {
    print("Enter your name: ")
    val name = readLine()
    print("Enter your age: ")
    val age = readInt()
    println(s"Name: $name")
    println(s"Age: $age")
  }
}
