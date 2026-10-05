object ListsExample {
  def main(args: Array[String]): Unit = {
    val numbers = List(10, 20, 30, 40)
    println("List: " + numbers)
    println("First element: " + numbers.head)
    println("Sum: " + numbers.sum)

    val doubled = numbers.map(_ * 2)
    println("Doubled: " + doubled)
  }
}
