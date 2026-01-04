fun main(){
//    print("Введите ваш возраст: ")
//    var age = readln().toInt()
//    if (age < 18){
//        repeat(18 - age){
//            println("Нужно подождать еще год!")
//        }
//        println("Теперь ты можешь идти в кино!")
//    }
//    else{
//        println("Ты можешь идти в кино")
//    }
//    var isAdult = false
//    while (!isAdult){
//        if (age >= 18){
//            isAdult = true
//            println("Ты можешь идти в кино")
//        }
//        else{
//            println("Нужно подождать еще год")
//            age++
//        }
//    }
    var sum = 0
    var number = readln().toInt()
    while (number != 0){
        sum += number
        number--
    }
    println(sum)
}