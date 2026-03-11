package collections

fun main() {
    val numbers = NumbersHashSet()
    repeat(100){
        numbers.add(it)
    }
    numbers.elements.forEach(::println)
}