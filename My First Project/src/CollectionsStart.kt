fun main(){
    val months = listOf<String>("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")
    val numberOfMonth = readln().toInt()
    if (numberOfMonth >= 1 && numberOfMonth <= 12){
        println(months[numberOfMonth - 1])
    }
    else{
        println("Некорректное значение:$numberOfMonth")
    }
}