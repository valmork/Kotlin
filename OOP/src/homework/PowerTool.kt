package homework

open class PowerTool(
    val brand: String,
    val model: String,
    val power: Int,
    val weight: Double,
    val cableLength: Int,
    val price: Price,
    val voltage: Int
) {
    open fun turnOn(){
    }
}

//fun task() {
//    // Создаем объекты с правильными аргументами
//    val drill: Drill = Drill(
//        brand = "Bosch",          // строка
//        model = "GSB 13 RE",      // строка
//        drillChuckDiameter = 13   // целое число
//    )
//
//    val angleGrinder: AngleGrinder = AngleGrinder(
//        brand = "Makita",         // строка
//        model = "GA4530",         // строка
//        discDiameter = 115        // целое число
//    )
//
//    val chainSaw: ChainSaw = ChainSaw(
//        brand = "Husqvarna",      // строка
//        model = "120 Mark II",    // строка
//        chainSawTireLength = 35   // целое число
//    )
//
//    val powerTools: List<PowerTool> = listOf(drill, angleGrinder, chainSaw)
//
//    for (powertool in powerTools) {
//        powertool.turnOn()
//    }
//}