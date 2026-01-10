package homework

import java.io.File

class Car {
    val brand: String
    val model: String
    val enginePower: Int
    val bodyColor: String

    constructor(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }

    fun drive() {
        if (enginePower >= 120){
            println("Еду быстро, но недалеко на $brand $model")
        }
        else{
            println("Еду далеко, но небыстро на $brand $model")
        }

    }

    // объявите здесь функцию refuel()
    fun refuel(azs: String, mark: String, countLiters: Int){
        println("Произведена заправка на АЗС \"$azs\"\nМарка бензина: $mark\nКол-во литров: $countLiters")
    }

    fun printInfo(){
        println("$brand $model $enginePower л.с. $bodyColor")
    }



//    fun init(brand: String, model: String, enginePower: Int, bodyColor: String){
//        this.brand = brand
//        this.model = model
//        this.enginePower = enginePower
//        this.bodyColor = bodyColor
//    }
}

fun task() {
    //создайте здесь экземпляр homework.Car и вызовите у него метод refuel()
    val source = readln()
    val sourceElements = source.split(" ")
    val brand: String = sourceElements[0]
    val model = sourceElements[1]
    val enginePower = sourceElements[2].toInt()
    val bodyColor = sourceElements[3]
    val car = Car(brand, model, enginePower, bodyColor)
//    car.drive()
    car.printInfo()
//    car.refuel(AZS, markCar, countedLiters)
}

// задача для урока 3.16
//class Car(
//    val make: String,
//    val model: String,
//    val year: Int,
//    val vin: String,
//    val color: String,
//)
//
//fun serialize(car: Car): String {
//    return "${car.make}%${car.model}%${car.year}%${car.vin}%${car.color}"
//}
//
//fun deserialize(carAsString: String): Car {
//    val parameters = carAsString.split("%")
//    val make = parameters[0]
//    val model = parameters[1]
//    val year = parameters[2].toInt()
//    val vin = parameters[3]
//    val color = parameters[4]
//    Car(make, model, year, vin, color)
//}