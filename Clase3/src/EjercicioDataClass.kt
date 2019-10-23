data class Universidad(var nombre: String, val fundacion: Int, var ubicacion: String)

fun main() {
    val uCatolica = Universidad("Universidad Catolica", 1950, "Santa Librada")
    val uNacional = Universidad("Universidad Nacional", 1960, "San Lorenzo")

    println(uCatolica)
    println(uNacional)

    println("La fundacion de la ${uCatolica.nombre} es ${uCatolica.fundacion}")

    uCatolica.nombre = "Universidad Católica Ntra. Sra. de la Asunción"
    println(uCatolica)

    val uNacionalAsuncion = uNacional.copy(ubicacion = "Asunción")
    println(uNacionalAsuncion)
    println(uNacional)

    val (nombreUniversidadSeleccionada,
        fundacionUniversidadSeleccionada) = uCatolica

    println(nombreUniversidadSeleccionada)
    println(fundacionUniversidadSeleccionada)
    //println(ubicacionUniversidadSeleccionada)

    val universidades: MutableList<Universidad> = mutableListOf()
    universidades.add(uCatolica)
    universidades.add(uNacional)
    universidades.add(uNacionalAsuncion)

    println(universidades)

    

}