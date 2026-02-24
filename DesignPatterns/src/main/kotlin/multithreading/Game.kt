package multithreading

import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {

    print("Enter your number from 0 to 1_000_000_000: ")
    val myNumber = readln().toInt()
    var whileNotGuessed = false

    thread {
        var second: Int = 1
        while (!whileNotGuessed){
            println(second++)
            Thread.sleep(1000)
        }
    }
    thread {
        while (true){
            val randomNumber = Random.nextInt(0,1_000_000_001)
            if (randomNumber == myNumber){
                println("I win. Your number is $randomNumber")
                whileNotGuessed = true
                break
            }
        }
    }



}