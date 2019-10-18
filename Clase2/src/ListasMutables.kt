fun main() {
    val dias: MutableList<String> = mutableListOf(
        "Lunes",
        "Martes",
        "Miercoles",
        "Viernes"
    )

    // Imprimit
    println(dias)
    dias.add("Sabado")
    println(dias)
    dias.add(3, "Jueves")
    println(dias)

    if (dias.none()) {
        println("No hay dias en el array")
    } else {
        println("La lista tiene ${dias.size} valores")
    }

    dias.removeAt(0)
    println(dias)

    val vacio = mutableListOf<String>()
    println("El primer valor de la lista es ${vacio.elementAtOrElse(5) {
        println("No hay ningun elemento en la posicion 5")
    }}")

    val diasClases:MutableList<String> = mutableListOf("Martes", "Jueves")
    val diasClasesConHorario: MutableList<String> = mutableListOf<String>()

    // Ejercicio: copiar los equipos a una nueva colección con la posición
    // Ejemplo: ["1) Martes: 16:30", " 2) Jueves: 16:30"
    diasClases.forEachIndexed { indice, dia ->
        diasClasesConHorario.add("${indice + 1}) $dia: 16:30")
    }

    println(diasClasesConHorario)

}