package stdlib

fun main() {
    val elements = 1..100_000_000

    // asSequence convert iterable into a lazy collection
    val output = elements.asSequence().filter { it < 10 }.map { Pair("Item", it) }

    output.forEach { println(it) }

    val sum30 = elements.asSequence().take(30).sum()

    println("The sum is $sum30")

    val numbers = generateSequence(1) { x -> x * 10 }

    numbers.take(10).forEach { println(it) }

    // Lazy init

    // Read only when is called
    val lazyInit: Int by lazy { 10 }
}