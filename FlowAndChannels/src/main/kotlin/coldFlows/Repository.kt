package coldFlows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object Repository {

    val timer = getTimerFlow()

    private fun getTimerFlow(): Flow<Int> {
        return flow {
            while (true) {
                var seconds = 0
                emit(seconds++)
                delay(1000)
            }
        }
    }
}