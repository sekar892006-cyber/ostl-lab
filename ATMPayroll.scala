import scala.io.StdIn._

case class Employee(name: String, basicSalary: Double, allowance: Double, deduction: Double) {
  def grossSalary: Double = basicSalary + allowance
  def netSalary: Double = grossSalary - deduction
}

object ATMPayroll {

  def atmMenu(): Unit = {
    println("\n--- ATM ---")
    println("1. Check Balance")
    println("2. Deposit")
    println("3. Withdraw")
    println("4. Exit")
  }

  def payrollMenu(): Unit = {
    println("\n--- Payroll Calculator ---")
    println("1. Calculate salary")
    println("2. Exit")
  }

  // Pattern matching
  def atmAction(choice: Int, balance: Double): Double = choice match {
    case 1 =>
      println(f"Balance: ₹$balance%.2f")
      balance

    case 2 =>
      print("Enter deposit: ")
      val amount = readDouble()
      if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive")
      val newBalance = balance + amount
      println(f"New balance: ₹$newBalance%.2f")
      newBalance

    case 3 =>
      print("Enter withdrawal: ")
      val amount = readDouble()
      if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive")
      if (amount > balance) throw new IllegalArgumentException("Insufficient balance")
      val newBalance = balance - amount
      println(f"New balance: ₹$newBalance%.2f")
      newBalance

    case 4 =>
      println("Leaving ATM...")
      balance

    case _ =>
      throw new IllegalArgumentException("Invalid ATM choice")
  }

  // Exception handling
  def safeAtmAction(choice: Int, balance: Double): Double = {
    try {
      atmAction(choice, balance)
    } catch {
      case e: NumberFormatException =>
        println("Invalid number input.")
        balance
      case e: IllegalArgumentException =>
        println("Error: " + e.getMessage)
        balance
    }
  }

  // Method creation
  def calculatePayroll(employee: Employee): Unit = {
    println(s"Employee: ${employee.name}")
    println(f"Gross Salary: ₹${employee.grossSalary}%.2f")
    println(f"Net Salary: ₹${employee.netSalary}%.2f")
  }

  // Functional programming: map/filter/foldLeft
  def functionalPayroll(employees: List[Employee]): Unit = {
    val highEarners = employees.filter(_.netSalary >= 30000)
    val names = employees.map(_.name)
    val totalPayroll = employees.map(_.netSalary).foldLeft(0.0)(_ + _)

    println("Employee names: " + names.mkString(", "))
    println("Employees with net salary >= 30000: " +
      highEarners.map(_.name).mkString(", "))
    println(f"Total payroll: ₹$totalPayroll%.2f")
  }

  def main(args: Array[String]): Unit = {
    var balance = 10000.0
    var running = true

    while (running) {
      atmMenu()
      print("Enter choice: ")
      val choice = readInt()
      balance = safeAtmAction(choice, balance)
      if (choice == 4) running = false
    }

    payrollMenu()
    print("Enter employee name: ")
    val name = readLine()
    print("Enter basic salary: ")
    val basic = readDouble()
    print("Enter allowance: ")
    val allowance = readDouble()
    print("Enter deduction: ")
    val deduction = readDouble()

    val employee = Employee(name, basic, allowance, deduction)
    calculatePayroll(employee)

    val employees = List(
      employee,
      Employee("Arun", 30000, 5000, 2000),
      Employee("Bala", 25000, 4000, 1000)
    )

    println("\n--- Functional Programming Demonstration ---")
    functionalPayroll(employees)
  }
}
