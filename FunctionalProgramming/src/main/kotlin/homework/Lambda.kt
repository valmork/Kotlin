package homework

fun main(){
    startProcessing()
}

fun processNumbers(numbers: List<Int>, function1 : (Int) -> Boolean, function2 : (Int) -> Int): List<Int> {
    val newNumbers = mutableListOf<Int>()
    for (number in numbers){
        if (function1(number)){
            newNumbers.add(number)
        }
    }
    val finalNumbers = mutableListOf<Int>()
    for (newNumber in newNumbers){
        finalNumbers.add(function2(newNumber))
    }

    return finalNumbers
}

fun startProcessing() {
    println("Введите числа, разделенные пробелами:")
    val numbersReadInt = readln().trim().split(" ").map { it.toInt() }
    val results = processNumbers(numbersReadInt,
        {it > 10 },
        {it * 3})
    println("Результат обработки: $results")
}