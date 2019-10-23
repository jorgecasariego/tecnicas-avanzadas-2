open class Persona(val nombre: String, val edad: Int) {
    var club: String = ""
    open fun imprimirDatosPersonales() {
        println("Nombre: $nombre - Edad: $edad")
    }
}

class Empleado(nombre: String, edad: Int, val sueldo: Double): Persona(nombre, edad) {

    override fun imprimirDatosPersonales() {
        super.imprimirDatosPersonales()
        print(" Sueldo $sueldo")
    }

    fun pagaIRP() {
        if (sueldo > 6500000) {
            println("$nombre debe pagar IRP")
        } else {
            println("El empleado $nombre no debe pagar IRP")
        }
    }
}

fun main() {
    val persona = Persona("María", 23)
    persona.imprimirDatosPersonales()

    val empleado = Empleado("Adriana", 23, 120000000.0)
    empleado.imprimirDatosPersonales()
    empleado.pagaIRP()
}