package corporation

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.ASSISTANT,
    salary = salary
), Cleaner, Supplier {

    override fun buyThings() {
        println("My position is assistant. I am buying something...")
    }

    override fun copy(
        id: Int,
        name: String,
        salary: Int,
        age: Int,
        position: Position
    ): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun clean() {
        println("My position is assistant. I am cleaning my workplace")
    }

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