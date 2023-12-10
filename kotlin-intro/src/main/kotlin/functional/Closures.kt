package functional

fun outsideFunction() {
    for (number in 1..30) {
        // Value captured in a closure
        unaryOperation(20) { x -> x * number }
    }
}

fun main() {

}