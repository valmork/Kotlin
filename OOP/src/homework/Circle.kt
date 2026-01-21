package homework

import kotlin.math.PI

class Circle(
    val radius: Double
): Shape("Circle") {
    override fun area(): Double {
        return roundToTwoDecimals(PI * radius * radius)
    }

    override fun perimeter(): Double {
        return roundToTwoDecimals(2 * PI * radius)
    }
}