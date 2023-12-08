package basics

/**
 * val and var both are used to declare a variable. var is like a general variable and can be assigned multiple
 * times and is known as the mutable variable in Kotlin. Whereas val is a constant variable and can not be assigned
 * multiple times and can be Initialized only single time and is known as the immutable variable in Kotlin.
 */

fun main() {
    var streetNumber: Int
    var streetName: String

    streetNumber = 32
    streetName = "High Street"

    // Inferred type
    val zip = "E11 P1"

    println("%s %d - %s".format(streetName, streetNumber, zip))

    streetNumber = 100;
    streetName = "Changed"

    println("$streetName $streetNumber")
}