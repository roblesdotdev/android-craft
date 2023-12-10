package tidbits

class NotANumberException(message: String): Throwable(message) {}

fun checkIsNumber(obj: Any) {
    when (obj) {
        !is Int, Long, Float, Double -> throw NotANumberException("This is not a number")
    }
}

fun main() {
    try {
        checkIsNumber("A")
    } catch (e: IllegalArgumentException) {
        println("Do nothing!")
    } catch (e: NotANumberException) {
        println("${e.message}")
    }
}