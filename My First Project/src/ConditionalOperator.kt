fun main(){
    val isTruck = readln().toBoolean()
    var vehicleType = ""
    val power = readln().toInt()
    var percent: Int = 0
    var sum: Int = 0

    if (isTruck){
        vehicleType = "грузовой автомобиль"
        if(power > 250){
            percent = 85
        }
        else if(power > 200){
            percent = 65
        }
        else if(power > 150){
            percent = 50
        }
        else if(power > 100){
            percent = 40
        }
        else{
            percent = 25
        }
    }
    else{
        vehicleType = "легковой автомобиль"
        if (power > 250){
            percent = 150
        }
        else if (power > 200){
            percent = 75
        }
        else if (power > 150){
            percent = 49
        }
        else if (power > 100){
            percent = 34
        }
        else{
            percent = 10
        }
    }

    sum = power * percent


    println("Вид ТС: ${vehicleType}\nМощность двигателя: ${power} л.с.\nНалоговая ставка: ${percent} руб./л.с.\nСумма налога: ${sum} руб.")
}