package collections

interface MyMutableCollection<T>: MyCollection<T>, MutableIterable<T> {

    override val size: Int

    fun add(element: T): Boolean

    fun removeNumber(element: T)

    fun clear()

    override fun contains(element: T): Boolean
}