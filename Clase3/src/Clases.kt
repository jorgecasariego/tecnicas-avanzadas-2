class Auto (var marca: String, var modelo: String, var anho: Int, var isDriving: Boolean = false) {

    fun esAptoParaUber() =  anho >= 2009

    fun imprimir() {
        println("Marca: ${marca} - Modelo: ${modelo} - Año: ${anho} - isDriving: ${isDriving}")
    }

}

fun main() {

    val auto1 = Auto("Ford", "Mondeo", 2008)
    val otroAuto = Auto("Kia", "Picanto", 2019)
    val otroAUtoMas = Auto("Toyota", "Hilux", 2013, true)

    auto1.imprimir()
    otroAuto.imprimir()
    otroAUtoMas.imprimir()

    if(auto1.esAptoParaUber()) {
        println("Es Ford Mondeo es apto para UBER")
    }

    if(otroAuto.esAptoParaUber()) {
        println("El kia picanto 2019 es apto para UBER")
    }
}