package basics

fun main() {
    val myLong = 10L    // Long
    val myFloat = 100F  // Float
    val myHex = 0xFF    // Int

    val myInt = 100
    val myLongFromInt = myInt.toLong()

    // Char
    val myChar = 'A'

    // String
    val myString = "A"

    val withEscapeChar = "A new line \n"

    val multiLineString = """
        This is a string
        And this is another line
    """.trimIndent()

    println(multiLineString)

    val name = "John Doe"
    val withInterpolation = "Hello $name!"

    println(withInterpolation)

    // Len
    println("The len of name is ${name.length}")
}