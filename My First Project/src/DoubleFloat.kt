fun main(){
//    val firsNumber = readln().toDouble()
//    val mathOperator = readln()
//    val secondNumber = readln().toDouble()
//
//    if (mathOperator == "*"){
//        println("Результат: ${firsNumber * secondNumber}")
//    }
//    else if (mathOperator == "/"){
//        println("Результат: ${firsNumber / secondNumber}")
//    }
//    else if (mathOperator == "+"){
//        println("Результат: ${firsNumber + secondNumber}")
//    }
//    else{
//        println("Результат: ${firsNumber - secondNumber}")
//    }

    val radius = readln().toDouble()
    val pi: Double = 3.14

    val lengthOfCircle = 2 * pi * radius
    val squareOfRadius = pi * radius * radius

    println("Радиус: $radius\nДлина окружности: $lengthOfCircle\nПлощадь круга: $squareOfRadius")
}