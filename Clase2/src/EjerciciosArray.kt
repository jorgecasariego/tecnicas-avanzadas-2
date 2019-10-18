fun main(args: Array<String>) {
    // Como crear arrays en kotlin
    val diasSemana = arrayOf("Lunes", "Martes", "Miercoles", "Jueves")

    // Como imprimir el primer elemento del array
    println("El primer dia de la semana es ${diasSemana.get(0)}")

    // Tamaño del array
    println("El tamaño del array es " + diasSemana.size)

    // Array de variables mixtas
    val variablesMixtas = arrayOf("1", 2, true, false)

    //Imprimir el 4to elmento del array
    println("El cuarto elemento del array es ${variablesMixtas.get(3)}")

    // Setear el 3er valor del array
    variablesMixtas.set(2, "TRUE")
    println("Ahora el array es de la forma ${variablesMixtas[2]}")

    val valoresEnteros = intArrayOf(1, 2, 3, 4)
    val valoresEnteros2 = arrayOf<Int>(1, 2, 3, 4)

    //Maneras de recorrer un array
    //1. Manera 1
    for (dia in diasSemana) {
        println(dia)
    }

    for((posicion, dia) in diasSemana.withIndex()) {
        println("El día $dia esta en la posicion $posicion dentro del array")
    }

}







