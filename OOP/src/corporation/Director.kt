package corporation

class Director(
    name: String,
    age: Int
): Worker(name = name, age = age) {
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