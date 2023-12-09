package clasess

// Data classes remove the boilerplate code.
// Used for data representation

// Default methods: toString, equals, hash

data class CustomerKotlin(
    private val id: Int,
    val name: String,
    val email: String
)

fun main() {
    val customer = CustomerKotlin(1, "Kotlin", "kotlin@email.com")

    println(customer)

    val customer2 = CustomerKotlin(1, "Kotlin", "kotlin@email.com")

    if (customer == customer2) {
        println("They are the same")
    }
}