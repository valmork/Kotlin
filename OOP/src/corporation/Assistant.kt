package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int = 0,
    salary: Int
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

    override fun copy(salary: Int, age: Int): Assistant {
        return Assistant(this.id, this.name, age, salary)
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