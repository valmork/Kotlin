package movies

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.time.measureTime

private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val scope = CoroutineScope(dispatcher)

fun main() {
    val job = scope.launch {
        val time = measureTime {
            loadMovies()
        }
        println(time)
    }
    scope.launch {
        delay(4000)
        job.cancel()
    }
}

private suspend fun loadMoviesIds(): List<Int> {
    delay(3000)
    return (0 .. 100).toList()
}

private suspend fun loadMovieById(id: Int): String {
    delay(100)
    return "Movie: $id"
}

private fun test() {
    scope.launch {
        launch {  }
        launch {  }
    }
    scope.launch {  }
}

private suspend fun loadMovies(): List<String> {
    return coroutineScope {
        loadMoviesIds().map {
            scope.async {
                loadMovieById(it).also {
                    println(it)
                }
            }
        }.awaitAll()
    }

}