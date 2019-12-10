package py.edu.uca.navigationcomponent.model

data class Pelicula(
    val id: Int,
    val title: String,
    val poster_path: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val release_date: String
)