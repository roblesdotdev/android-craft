package clasess

object Global {
    const val PI = 3.14
}

fun main() {
    println(Global.PI)

    val localObject = object {
        val PI = 3.14
    }

    println(localObject.PI)
}