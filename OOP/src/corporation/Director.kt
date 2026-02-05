package corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.DIRECTOR,
    salary = salary
), Supplier {

    override fun buyThings() {
        println("My position is director. I am buying something...")
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

    fun takeCoffee(assistant: Assistant){
        val drinkName: String = assistant.bringCoffee()
        println("Thank you ${assistant.name}! The @drinkName is very tasty!")
    }

    fun forceToWork(consultant: Consultant){
        consultant.serveCustomers()
        println("Консультант ${consultant.name} обслужил ${consultant.serveCustomers()} клиентов")
    }

    override fun work() {
        println("I am drinking coffee ...")
    }
}