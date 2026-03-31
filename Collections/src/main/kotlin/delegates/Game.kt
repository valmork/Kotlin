package delegates

import collections.MyMutableList

fun main() {
    val mutableList = mutableListOf(1, 2, 3)
    val loggingMutableList = LoggingMutableList(mutableList)
    loggingMutableList.add(10)
}

interface Player {

    fun move()

    fun fight()
}

/* Data классы это самый простой способ-обертка реализации паттерна Wrapper(Decorator).
 Для лучшей реализации нужно использовать делегаты, пример - класс subscribeToFly */

data class Zombie(val userName: String): Player {

    override fun move() {
        println("I'm walking very slowly")
    }

    override fun fight() {
        println("I'm eating people")
    }
}

data class Human(val userName: String): Player {

    override fun move() {
        println("I'm running very fast")
    }

    override fun fight() {
        println("I'm shooting a gun...")
    }
}

data class PremiumPlayer(val player: Player): Player {

    override fun move() {
        player.move()
    }

    override fun fight() {
        player.fight()
    }

    fun callForHelp() {
        println("HELP ME!!!")
    }
}

data class subscribeToFly(val player: Player): Player by player {

    override fun move() {
        println("I'm premium user")
    }

    fun fly() {
        println("I'm flying very high")
    }
}

// Homework

class LoggingMutableList<T>(private val mutableList: MutableList<T>): MutableList<T> by mutableList {

    override fun add(element: T): Boolean {
        return mutableList.add(element).also {
            println("Added $element")
        }
    }
}