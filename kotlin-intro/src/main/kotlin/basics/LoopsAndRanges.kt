package basics

fun main() {
    // For Loop
    for (a: Int in 1..10) {
        println("Value: $a")
    }

    for (a in 5 downTo 0)  {
        print("$a ")
    }

    val capitals = listOf("London", "Paris", "Rome", "Madrid")
    for (capital in capitals) {
        println(capital)
    }

    var count = 0
    while (count < 5) {
        println("Count $count")
        count++
    }
}