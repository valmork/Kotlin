package collections

interface MyMutableCollection<T>: MutableIterable<T> {

    val size: Int

    fun add(element: T): Boolean

    fun removeNumber(element: T)

    fun clear()

    fun contains(element: T): Boolean
}