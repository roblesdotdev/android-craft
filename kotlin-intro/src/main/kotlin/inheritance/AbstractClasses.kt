package inheritance

abstract class StoredEntity {
    private val isActive = true
    abstract fun store()

    // Member no abstract with implementation
    fun status(): String {
        return isActive.toString()
    }
}

class Employee: StoredEntity() {
    override fun store() {
        println("Store")
    }
}

fun main() {
    val se = Employee()

    println(se.status())

    se.store()
}