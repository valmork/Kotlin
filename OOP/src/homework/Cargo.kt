package homework

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePackaging: String,
    val netWeight: Double,
    val grossWeight: Double
) {
    fun printInfo(){
        println("Длина: $length\n" +
                "Ширина: $width\n" +
                "Высота: $height\n" +
                "Тип упаковки: $typePackaging\n" +
                "Вес нетто: $netWeight\n" +
                "Вес брутто: $grossWeight")
    }
}