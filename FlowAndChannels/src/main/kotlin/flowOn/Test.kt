package flowOn

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

private val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

fun main() {
    scope.launch {
        getFlow().onStart { println("onStart: ${getCurrentThread()}") }
            .onEach { println("onEach 1: ${getCurrentThread()}") }
            .flowOn(dispatcher)
            .map {
                println("Map: ${getCurrentThread()}")
                it
            }
            .flowOn(Dispatchers.Default)
            .onEach { println("onEach 2: ${getCurrentThread()}") }
            .collect {
                println("Collected: $it in ${getCurrentThread()}")
            }
    }
}

fun getFlow() = flow {
    var seconds = 0
    while (true) {
        emit(seconds++)
        delay(1000)
    }
}

fun getCurrentThread(): String = Thread.currentThread().name