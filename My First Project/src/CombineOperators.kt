fun main(){
    val isHungry = readln().toBoolean()
    val money = readln().toInt()

    if (isHungry && money > 500){
        println("Купите пиццу")
    }
    else if (isHungry && money < 500){
        println("Купите доширак")
    }
    else if (!isHungry && money > 500){
        println("Сходите в кино")
    }
    else if (!isHungry && money < 500){
        println("Сходите на прогулку")
    }
}