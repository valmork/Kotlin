fun main(){
//    val numbers = 0 .. 1000 step 2
//    print("Введите ваше число: ")
//    val number = readln().toInt()
//    val result = number in numbers
//    println(result)

    val firstNumber = readln().toInt()
    val secondNumber = readln().toInt()

    val numbers = firstNumber .. secondNumber step 8
    for (number in numbers){
        println(number)
    }
}