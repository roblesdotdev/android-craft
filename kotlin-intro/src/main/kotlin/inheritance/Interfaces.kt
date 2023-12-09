package inheritance

// Vs abstract classes
// Interfaces cannot maintain state

interface CustomerRepository {
    fun getById(id: Int): Customer
    fun store(obj: Customer)

    fun greet() {
        println("Default implementation")
    }
}

class SQLCustomerRepository: CustomerRepository {
    override fun getById(id: Int): Customer {
        TODO("Not yet implemented")
    }

    override fun store(obj: Customer) {
        TODO("Not yet implemented")
    }

}

fun main() {
    val repo = SQLCustomerRepository()

    repo.greet()
}