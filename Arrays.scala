object ArraysExample {
  def main(args: Array[String]): Unit = {
    val numbers = Array(10, 20, 30, 40, 50)
    println("Array elements:")
    for (n <- numbers) println(n)
    println("Sum: " + numbers.sum)
    println("Maximum: " + numbers.max)
  }
}
