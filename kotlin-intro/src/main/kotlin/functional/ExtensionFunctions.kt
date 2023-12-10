package functional

fun String.hello() {
    println("It's me")
}

fun String.toTitleCase(): String {
    return this.split(" ").joinToString(" ") { it.capitalize() }
}

fun main() {
    "".hello()

    println("this is a sample string to title case it".toTitleCase())
}