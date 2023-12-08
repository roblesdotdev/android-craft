package basics

fun main() {
    var myString = "Not Empty"

    if (myString != "") {
        println("Not empty")
    } else if (myString.startsWith("b")) {
        println("My string starts with b")
    } else {
        println("My string is empty")
    }

    val result = if (myString.isBlank()) "Foo" else "Bar"

    println(result)

    val test = testResult("Value")
    println(test)
}

fun testResult(value: String): String {
    return when(value) {
        "Value" -> "Correct"
        "Empty" -> "No value result"
        else -> "Invalid value result"
    }
}