package jobHierarchy

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcherIO = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcherIO)

fun main() {
    val job = scope.launch {
        launch {
            printNumber(1)
        }
        launch {
            printNumber(2)
        }
    }
    Thread.sleep(3000)
    job.cancel()
}

private suspend fun printNumber(number: Int){
    while (true) {
        println(number)
        delay(1000)
    }
}