package homework

import kotlin.system.measureTimeMillis

fun main(){

        val testLines = List(10000) { "Line $it" }
        val merger = TextMerger()

        val time = measureTimeMillis {
                val result = merger.mergeText(testLines)
                println("Length: ${result.length}")
        }

        println("Time: $time ms")
}