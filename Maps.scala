object MapExample {
  def main(args: Array[String]): Unit = {
    val students = Map(
      "Arun" -> 90,
      "Bala" -> 85,
      "Kumar" -> 95
    )

    println("Students and Marks:")
    for ((student, mark) <- students) {
      println(student + " -> " + mark)
    }

    println("Arun's mark: " + students("Arun"))
  }
}
