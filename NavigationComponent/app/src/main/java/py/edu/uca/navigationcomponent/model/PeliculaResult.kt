package py.edu.uca.navigationcomponent.model

data class PeliculaResult(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: ArrayList<Pelicula>
)