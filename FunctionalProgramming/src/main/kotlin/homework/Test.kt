package homework

fun main() {

}

fun List<Int>.sumOfEvents(): Int{
    var sum = 0
    for (number in this){
        if (number % 2 == 0){
            sum += number
        }
    }
    return sum
}

fun processList(){
    val numbers = readln().trim().split(" ").map { it.toInt() }
    println("Сумма чётных чисел: ${numbers.sumOfEvents()}")
}