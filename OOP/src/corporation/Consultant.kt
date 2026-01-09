package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

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