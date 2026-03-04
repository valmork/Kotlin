package calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 add to 10 Then Result 15`(calculator: Calculator){
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 add to 100 Then Result 150`(calculator: Calculator){
        val result = calculator.sum(100, 50)
        val expected = 150
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 substract from 100 Then Result 50`(calculator: Calculator){
        val result = calculator.substract(100, 50)
        val expected = 50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 0 substract from 100 Then Result 100`(calculator: Calculator){
        val result = calculator.substract(100, 0)
        val expected = 100
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 multiply to 100 Then Result 5000`(calculator: Calculator){
        val result = calculator.multiply(100, 50)
        val expected = 5000
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 0 multiply to 100 Then Result 0`(calculator: Calculator){
        val result = calculator.multiply(100, 0)
        val expected = 0
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 divide by 2 Then Result 5`(calculator: Calculator){
        val result = calculator.divide( 10, 2)
        val expected = 5.toDouble()
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 100 divide by 1 Then Result 100`(calculator: Calculator){
        val result = calculator.divide(100, 1)
        val expected = 100.toDouble()
        assertEquals(expected, result)
    }

    companion object{

        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalculator(), LoggingCalculator())
    }


}