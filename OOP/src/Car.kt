class Car {
    var brand = ""
    var model = ""
    var enginePower = 0
    var bodyColor = ""

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

    fun init(brand: String, model: String, enginePower: Int, bodyColor: String){
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }
}

fun task() {
    //создайте здесь экземпляр Car и вызовите у него метод refuel()
    val car = Car()
    val source = readln()
    val sourceElements = source.split(" ")
    val brand: String = sourceElements[0]
    val model = sourceElements[1]
    val enginePower = sourceElements[2].toInt()
    val bodyColor = sourceElements[3]
    car.init(brand, model, enginePower, bodyColor)
    car.drive()
//    car.refuel(AZS, markCar, countedLiters)
}