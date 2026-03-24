package async

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.coroutines.coroutineContext

private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
    println("Exception caught")
}
private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher + CoroutineName("My coroutine") + Job())

fun main() {
    val deferred =  scope.async {
        method()
    }
    scope.launch {
        deferred.await()
    }
    scope.launch {
        method2()
    }
}

suspend fun method(){
    delay(3000)
    error("")
}
suspend fun method2(){
    delay(5000)
    println("Method 2 is finished")
}