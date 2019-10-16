fun main(args: Array<String>) {
    mostrarMiNombre()

    // Crear una funcion que calcule tu edad pasandole la fecha de nacimiento
    println("Mi edad es ${calcularEdad(1982)}")
    println("La suma de 2 + 2 es ${suma(2, 2)}")
    println("La multiplicacion de 2 x 2 es ${multiplicacion(y=2, x=2)}")

    // Mayor de edad o Menor de edad
    println("La persona es ${esMayorDeEdad(15)}")
}

fun esMayorDeEdad(edad: Int) = if (edad > 18) "mayor de edad" else " menor de edad"

fun multiplicacion(x: Int, y: Int) = x * y

fun suma(valor1: Int, valor2: Int): Int = valor1 + valor2

fun calcularEdad(edad: Int): Int {
    return 2019 - edad
}

fun mostrarMiNombre() {
    println("Mi nombre es Jorge")
}