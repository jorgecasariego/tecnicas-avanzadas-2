fun main(args: Array<String>) {

    val edad = 18

    if (edad > 18) {
        println("Es mayor de edad")
    } else {
        println("Es menor de edad")
    }

    convertirNumeroALetras(10)
}

fun convertirNumeroALetras(numero: Int) {
    when(numero) {
        1 -> {
            println("Uno")
        }
        2 -> println("Dos")
        3 -> println("Tres")
        4 -> println("Cuatro")
        5 -> println("Cinco")
        6 -> println("Seis")
        7 -> println("Siete")
        8 -> println("Ocho")
        else -> {
            println("Numero no reconocido")
        }
    }
}
