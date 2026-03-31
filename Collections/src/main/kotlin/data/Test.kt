package data

fun main() {
    // Пример деструктуризации
    val (english, french) = MyPair("", "")

    val dictionary = listOf(
        "A" to "B",
        "" myTo "",
        Pair("Hello", "Bonjour"),
        Pair("Thank you", "Merci")
    )
    for ((first, second) in dictionary) {
        println("$first - $second")
    }
}

data class MyPair<F, S>(val first: F, val second: S)

// Инфикс упрощает чтение, у нее не должно быть параметра по умолчанию, параметр должен быть один,
// слева у функции должен быть параметр, то есть она extension
infix fun <A, B> A.myTo(second: B): Pair<A, B> {
    return Pair(this, second)
}