package generics

fun main() {
//    val programmer = Container(Programmer("John"))
//    val director = Container(Director("Max"))
//    val worker = Container<Worker>()
}

fun <T> copy(src: Container<T>, dst: Container<in T>) {
    dst.value = src.value
}

data class Container<T>(var value: T? = null)