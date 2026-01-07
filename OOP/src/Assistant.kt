class Assistant {

    fun bringCoffee(count: Int, name: String){
        repeat(count){
            println("Встал")
            println("Взял кружку")
            println("Подошел к автомату")
            println("Налил кофе - $name")
            println("Принес начальнику")
        }
    }
}