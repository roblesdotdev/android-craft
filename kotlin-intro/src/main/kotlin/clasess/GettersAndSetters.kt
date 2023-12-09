package clasess

import java.util.Calendar

class Employee(val id: Int, var name: String, val yearOfBirth: Int) {

    val age: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth

    var socialSecurityNumber: String = ""
        set(value) {
            if (!value.startsWith("SN")) {
                throw IllegalArgumentException("Social security should start with SN")
            }
            field = value
        }

    override fun toString(): String {
        return "Employee(%s, %s)".format(id, name)
    }

}

fun main() {
    val employee = Employee(1, "Mary Jane", 1999)

    println(employee)
    println("Employee age: ${employee.age}")

    employee.socialSecurityNumber = "SN1234"

    println(employee.socialSecurityNumber)
}