package collections

interface NumbersMutableList {

    val size: Int

    fun add(number: Int)

    fun add(index: Int ,number: Int)

    operator fun plus(number: Int)

    operator fun minus(number: Int)

    operator fun get(index: Int): Int

    fun remove(index: Int)

    fun removeNumber(number: Int)

    fun clear()

    fun contains(number: Int): Boolean
}