package stdlib

data class Album(val title: String, val year: Int, val chartUK: Int, val tracks: List<Track> = emptyList())

data class Track(val title: String, val duartionSeconds: Int)

val albums = listOf(
    Album(
        title = "The Dark of the Moon",
        year = 1973,
        chartUK = 2,
        tracks = listOf(
            Track("Speack to Me", 90),
            Track("Breathe", 163),
            Track("On he Run", 216),
            Track("Time", 421),
            Track("The Great Gig in the Sky", 276),
            Track("Money", 382),
            Track("Us and Them", 462),
            Track("Any Color You Like", 205),
            Track("Brain Damage", 228),
            Track("Eclipse", 123)
        )
    ),
    Album(
        title = "The Wall",
        year = 1979,
        chartUK = 2,
    ),
    Album(
        title = "Wish You Were Here",
        year = 1975,
        chartUK = 1,
    ),
    Album(
        title = "More",
        year = 1969,
        chartUK = 1,
    )
)

fun main() {
   val withChartUK1 = albums.filter { it.chartUK == 1 }

    withChartUK1.forEach {
        println(it)
    }

    val withTracks = albums.filter { it.tracks.isNotEmpty() }

    val transformation = albums.map { it.title.uppercase() }

    transformation.forEach { println(it) }

    val result = albumAndTrackLowerThanXSecons(230, albums)

    println("==================")
    result.forEach { println(it) }
}

fun albumAndTrackLowerThanXSecons(seconds: Int, albums: List<Album>): List<Pair<String, String>> {
    return albums.flatMap {album ->
        val albumTitle = album.title
        album.tracks.filter { track -> track.duartionSeconds < seconds }
            .map{
                Pair(albumTitle, it.title)
            }
    }
}