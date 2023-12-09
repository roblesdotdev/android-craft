package clasess

class Customer {
    var id = 0
    var name: String = ""
    val surname: String = ""

    override fun toString(): String {
        return "Customer(%s, %s)".format(id, name)
    }
}

// With constructor properties
class Customer2(var id: Int, var name: String, val surname: String = "") {
    override fun toString(): String {
        return "Customer2(%s, %s)".format(id, name)
    }
}

class Customer3(var id: Int, var name: String) {

    init {
        name = name.uppercase()
    }

    override fun toString(): String {
        return "Customer3(%s, %s)".format(id, name)
    }
}

fun main() {
    val customer = Customer()
    customer.id = 10
    customer.name = "John"

    println(customer)

    val customer2 = Customer2(1, "Mary Jane")
    println(customer2)
    customer2.name = "Changed"
    customer2.id = 32
    println(customer2)

    val customer3 = Customer3(1, "john doe")
    println(customer3)
}