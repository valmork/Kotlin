package extensions

fun <R, T> Iterable<T>.transform(operation: (T) -> R): List<R>{
    val result = mutableListOf<R>()
    for (person in this){
        result.add(operation(person))
    }
    return result
}

fun <T> Iterable<T>.filter(isSuitable: (T) -> Boolean): List<T>{
    val result = mutableListOf<T>()
    for (item in this){
        if (isSuitable(item)){
            result.add(item)
        }
    }
    return result
}

fun <T> Iterable<T>.myForEach(function: (T) -> Unit){
    for (item in this){
        function(item)
    }
}

inline fun <T, R> T.myLet(block: (T) -> R): R{
    return block(this)
}

inline fun <T> T.myAlso(block: (T) -> Unit): T{
    block(this)
    return this
}

fun <K, V, R> Map<K, V>.transformValues(transform: (V) -> R): Map<K, R>{
    val newMap = mutableMapOf<K,R>()
    for (entry in this){
        newMap[entry.key] = transform(entry.value)
    }
    return newMap
}