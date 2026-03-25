package hotFlows

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

object Repository2 {

    private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
    private val scope = CoroutineScope(dispatcher)

    // Способ под капотом
//    val timer = MutableSharedFlow<Int>().apply {
//        scope.launch {
//            getTimerFlow().collect {
//                emit(it)
//            }
//        }
//    }.asSharedFlow()

    val timer = getTimerFlow().shareIn(
        scope = scope,
        started = SharingStarted.Eagerly
    )

    private fun getTimerFlow(): Flow<Int> {
        return flow {
            var seconds = 0
            while (seconds < 5) {
                println("Emitted: $seconds")
                emit(seconds++)
                delay(1000)
            }
        }
    }
}