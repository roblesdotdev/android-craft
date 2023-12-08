package functions

fun main() {
    hello()
    greet()
    greet("Mary Jane")

    val result = addTwo(3)
    println("The result is $result")

    // Named arguments
    println(printDetails(
        email = "john@email.com",
        name = "John Doe",
    ))

    // Undefined arguments
    printStrings("Argentina", "Uruguay", "Colombia")
}

// Return Unit
fun hello() {
    println("Hello")
}

// Default params
fun greet(name: String = "Unknown") {
    println("Hello, $name")
}

fun throwingExceptions(): Nothing {
    throw Exception("This function throws an exception")
}

fun addTwo(a: Int): Int {
    return add(a, 2)
}

// Single expression function
fun add(a: Int, b: Int): Int = a + b

fun printDetails(name: String, email: String, phone: String = "") {
    println("name: $name, email: $email, phone: $phone")
}

// undefined arguments
fun printStrings(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}