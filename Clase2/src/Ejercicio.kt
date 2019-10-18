fun main() {
    val ciudades = listOf<String>(
        "Asunción",
        "Ciudad del este",
        "Encarnación",
        "Saltos del guaira",
        "Concepción",
        "Pozo Colorado", "Antequera")

    ciudades
        .filter { it.length < 15 }
        .sortedByDescending { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }


}