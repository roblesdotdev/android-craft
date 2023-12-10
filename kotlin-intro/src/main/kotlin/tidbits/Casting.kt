package tidbits

open class Person {}

class Employee: Person() {
    fun vacationDays(days: Int) {
        if (days < 60) {
            println("You need more vacation")
        }
    }
}

class Contractor: Person() {

}

fun hasVacations(obj: Person) {
    // Smart cast
    when(obj) {
        is Employee -> obj.vacationDays(20)
        is Contractor -> obj.toString()
    }
}

fun main() {
    var input: Any = 10

    // Safe conversion -> String?
    val str = input as? String

    println(str?.length)
}