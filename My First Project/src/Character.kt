fun main(){
//    var letter = 'A'
//    repeat(26){
//        println(letter)
//        letter++
//    }

//    while (letter != '['){
//        println(letter)
//        letter++
//    }

    val password = readln().toCharArray()
    var symbolCounter = 0
    for (symbol in password){
        if (symbol == 'Ъ'){
            symbolCounter++
        }
    }
    if (symbolCounter != 0){
        println("У вас идеальный пароль!")
    }
    else{
        println("Опс! В вашем пароле кое-чего не хватает.")
    }
}