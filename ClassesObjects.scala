class Student(val name: String, val mark: Int) {
  def display(): Unit = {
    println(s"Name: $name")
    println(s"Mark: $mark")
  }
}

object ClassesObjects {
  def main(args: Array[String]): Unit = {
    val student = new Student("Arun", 90)
    student.display()
  }
}
