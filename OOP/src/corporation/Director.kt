package corporation

class Director(
    id: Int,
    name: String,
    age: Int
): Worker(id = id, name = name, age = age, position = Position.DIRECTOR) {
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