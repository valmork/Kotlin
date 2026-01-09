package corporation

class Assistant(
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

    fun bringCoffee(count: Int = 2, drinkName: String = "Cappuccino"): String{
        repeat(count){
            println("Встал")
            println("Взял кружку")
            println("Подошел к автомату")
            println("Налил кофе - $drinkName")
            println("Принес начальнику")
        }
        return drinkName
    }

    override fun work() {
        println("I am making coffee right now ...")
    }
}