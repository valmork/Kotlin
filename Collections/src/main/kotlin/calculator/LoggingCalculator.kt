package calculator

class LoggingCalculator: Calculator {

    override fun sum(a: Int, b: Int): Int{
        val result = a + b
        println("Operation sum($a, $b). Result: $result")
        return result
    }

    override fun substract(a: Int, b: Int): Int{
        val result = a - b
        println("Operation substract($a, $b). Result: $result")
        return result
    }

    override fun divide(a: Int, b: Int): Double{
        val result = a.toDouble() / b
        println("Operation divide($a, $b). Result: $result")
        return result
    }

    override fun multiply(a: Int, b: Int): Int{
        val result = a * b
        println("Operation multiply($a, $b). Result: $result")
        return result
    }
}