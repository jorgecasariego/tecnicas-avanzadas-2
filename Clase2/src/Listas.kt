fun main() {
    // Listas Inmutables
    val diasSemana: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves")
    //                                                                              ^
    //                                                                             it
    // resultado = martes, jueves
    // tamaño de la lista
    println("El tamaño de la lista es ${diasSemana.size}")

    // Imprimir la lista
    println(diasSemana.last())

    // Filtrar solo los martes  y jueves
    val resultado = diasSemana.filter {it == "Martes" || it == "Jueves"}
    println("Los dias de clase son $resultado")
}