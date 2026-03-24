package cancellation

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher + CoroutineName("My coroutine") + Job())

fun main() {
    scope.launch {
        timer()
    }
}

private suspend fun timer(){
    var seconds = 0
    while (true){
        println(seconds++)
        delay(1000)
    }
}