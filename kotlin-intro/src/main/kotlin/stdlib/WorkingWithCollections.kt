package stdlib

fun main() {
    val emptyList: List<String> = emptyList()

    val list: List<String> = listOf("first", "second")

    val mutableList: MutableList<String> = mutableListOf()

    mutableList.add("first", )

    mutableList.add(0, "zero")

    for (el in mutableList) {
        println(el)
    }

}