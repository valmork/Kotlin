package calculator

interface Calculator {
    fun sum(a: Int, b: Int): Int

    fun substract(a: Int, b: Int): Int

    fun divide(a: Int, b: Int): Double

    fun multiply(a: Int, b: Int): Int
}