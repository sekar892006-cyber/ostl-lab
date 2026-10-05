object FunctionsExample {
  def add(a: Int, b: Int): Int = a + b
  def factorial(n: Int): Long =
    if (n <= 1) 1 else n * factorial(n - 1)

  def main(args: Array[String]): Unit = {
    println("Add: " + add(10, 20))
    println("Factorial: " + factorial(5))
  }
}
