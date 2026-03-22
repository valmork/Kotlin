package executors

import java.util.concurrent.Executors
import kotlin.concurrent.thread

fun main() {
    val executorService = Executors.newCachedThreadPool()
    repeat(9000){
        executorService.execute {
            processImage(Image(it))
        }
    }
}

private fun processImage(image: Image){
    println("Image $image is processing")
    Thread.sleep(1000)
    println("Image $image is processed")
}

data class Image (val id: Int)