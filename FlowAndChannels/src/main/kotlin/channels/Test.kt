package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

private val channel = Channel<Int>()

fun main() {
    scope.launch {
        repeat(100) {
            println("1 is sending...")
            channel.send(1)
            println("1 was sent")
            delay(1000)
        }
    }
    scope.launch {
        repeat(100) {
            println("2 is sending...")
            channel.send(2)
            println("2 was sent")
            delay(1000)
        }
    }
    scope.launch {
        val number = channel.receive()
        println("Consumer 1: $number")
    }
    scope.launch {
        val number = channel.receive()
        println("Consumer 2: $number")
    }
}