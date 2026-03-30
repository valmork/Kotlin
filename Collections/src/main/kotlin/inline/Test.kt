package inline

fun main() {
    val list = (0 .. 100).toList()

    list.myFilter(object : Condition<Int> {
        override fun isSuitable(element: Int): Boolean {
            return element % 2 == 0
        }
    }).forEach {
        println(it)
    }

//    list.myFilter { it % 2 == 0 }.forEach {
//        println(it)
//    }
}

interface Condition<T> {

    fun isSuitable(element : T): Boolean
}

fun <T> List<T>.myFilter(condition: Condition<T>): List<T> {
    val result = mutableListOf<T>()
    for (element in this) {
        if (condition.isSuitable(element)) {
            result.add(element)
        }
    }
    return result
}

fun <T> List<T>.myFilter(condition: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (element in this) {
        if (condition(element)) {
            result.add(element)
        }
    }
    return result
}