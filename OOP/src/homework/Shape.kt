package homework

import kotlin.math.round

abstract class Shape(
    val name: String
) {
    abstract fun area(): Double

    abstract fun perimeter(): Double

    protected  fun roundToTwoDecimals(value: Double): Double{
        val roundedValue = round(value * 100) / 100
        return roundedValue
    }
}