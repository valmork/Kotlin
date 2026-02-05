package exceptions

fun main() {
    val list = listOf<Int>(1, 2, 3, 4, 5)
    try {
        println(list[5])
    } catch (exception: ArrayIndexOutOfBoundsException){
        println("You out of array`s bounds")
    }

}