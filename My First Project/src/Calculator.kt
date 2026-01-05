fun main(){
//    println("Введите ваш пример")
//    val source = readln()
//    val mathSources = source.split(" ")
//    val firsNumber = mathSources[0].toDouble()
//    val mathOperator = mathSources[1]
//    val secondNumber = mathSources[2].toDouble()
//
//    val result = when (mathOperator) {
//        "*" -> {
//            firsNumber * secondNumber
//        }
//        "/" -> {
//            firsNumber / secondNumber
//        }
//        "+" -> {
//            firsNumber + secondNumber
//        }
//        else -> {
//            firsNumber - secondNumber
//        }
//    }
//    println("Результат: $result")



//    val radius = readln().toDouble()
//    val pi: Double = 3.14
//
//    val lengthOfCircle = 2 * pi * radius
//    val squareOfRadius = pi * radius * radius
//
//    println("Радиус: $radius\nДлина окружности: $lengthOfCircle\nПлощадь круга: $squareOfRadius")

    val numbers= readln()
    val numbersArray = numbers.split(" ")
    var sum = 0
    for (number in numbersArray){
        sum += number.toInt()
    }
    println(sum)
}