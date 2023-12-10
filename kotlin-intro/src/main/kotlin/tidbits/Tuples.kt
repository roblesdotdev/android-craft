package tidbits

fun capitalAndPopulation(country: String): Pair<String, Long> {
    return Pair("Argentina", 14_000_000)
}

fun countryInformation(country: String): Triple<String, String, Long> {
    return Triple("Argentina", "Another", 14_000_000)
}

fun main() {
    val result = capitalAndPopulation("Argentina")

    println(result.first)
    println(result.second)

    val info = countryInformation("Argentina")

    println(info.third)

    // Deconstruct
    val (capital, population) = result

    println("The capital is $capital and the population is $population")
}