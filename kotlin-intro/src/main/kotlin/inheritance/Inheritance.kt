package inheritance

// By default, classes are final

// Open allow to inherit
open class Person {

    // open allows override
    open fun validate() {}
}

open class Customer: Person() {
    // Not override
    final override fun validate() {
       println("Override")
    }
}

class SpecialCustomer: Customer() {
}

fun main() {
    val customer = Customer()
    val special = SpecialCustomer()

    customer.validate()
    special.validate()
}