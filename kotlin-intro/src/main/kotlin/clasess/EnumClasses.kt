package clasess

enum class Priority {
    MINOR,
    NORMAL,
    MAJOR,
}

enum class WithValue(val value: Int) {
    FIRST(1),
    SECOND(2) {
        override fun toString(): String {
            return "Second Priority(2)"
        }
    }
}

fun main() {
    val priority: Priority = Priority.NORMAL

    println(priority)

    val first: WithValue = WithValue.FIRST
    println(first)
    println(first.value)

    val second: WithValue = WithValue.valueOf("SECOND")
    println(second)

    for (p in Priority.entries) {
        println(p.name)
    }
}