package corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    position = Position.CONSULTANT,
    salary = salary
), Cleaner {

    override fun clean() {
        println("MY position is consultant. I am cleaning my workplace")
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

    fun sayHello(){
        print("Привет! Меня зовут ${this.name}.")
        if (age > 0){
            print(" Мне ${this.age} лет.")
        }
    }

    fun serveCustomers(): Int{
        val count = Random.nextInt(0, 100)
        repeat(count){
            println("Обслужил клиента")
        }
        return count
    }

    override fun work() {
        println("I am consulting right now ...")
    }
}