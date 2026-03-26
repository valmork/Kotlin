package backpressure

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

// Буфер - по умолчанию емкость - 64 элемента, можно менять ее
fun main() {
    val flow = flow {
        repeat(100) {
            emit(it)
            delay(100)
        }
    }.buffer(capacity = 100)
    scope.launch {
        flow.collect {
            delay(1000)
            println(it)
        }
    }
}