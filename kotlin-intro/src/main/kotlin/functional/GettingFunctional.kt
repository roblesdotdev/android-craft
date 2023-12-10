package functional

fun operation(x: Int, y: Int, op: (Int, Int) -> Int) {
    println(op(x, y))
}

fun add(x: Int, y: Int) = x + y

fun unaryOperation(x: Int, op: (Int) -> Int) {
    println(op(x))
}

fun main() {
    // reference a function by name with ::
    operation(1, 2, ::add)

    // with lambda
    operation(1, 2) { x, y -> x + y }

    unaryOperation(2) { x -> x * x }

    // with single parameters can use "it"
    unaryOperation(5) { it * 6 }
}