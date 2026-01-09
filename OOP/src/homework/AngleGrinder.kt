package homework

class AngleGrinder(
    val discDiameter: Int,
    val isSmoothStart: Boolean,
    val isDustProtection: Boolean,
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage: Int
): PowerTool(brand, model, power, weight, cableLength, price, voltage) {
    override fun turnOn() {
        println("УШМ режет")
    }
}