package nullsafety

// Declare nullable type with ?
// String?  Int? ....

fun main() {
    val message: String? = null

    if (message != null) {
        println(message.uppercase())
    }

    // Elvis operator
    println(message?.uppercase())


}