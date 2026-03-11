package collections

import kotlin.math.abs

class NumbersHashSet : NumbersMutableSet {

    var elements = arrayOfNulls<Node>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(number: Int): Boolean {
        if (size >= elements.size * LOAD_FACTOR){
            increaseArray()
        }
        return add(number, elements).also { added ->
            if (added){
                size++
            }
        }
    }

    private fun add(number: Int, array: Array<Node?>): Boolean{
        val newElement = Node(number)
        val position = getElementPosition(number, array.size)
        var existedElement = array[position]
        if (existedElement == null){
            array[position] = newElement
            return true
        } else {
            while (true) {
                if (existedElement?.item == number) {
                    return false
                } else {
                    if (existedElement?.next == null) {
                        existedElement?.next = newElement
                        return true
                    } else {
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }

    private fun increaseArray(){
        val newArray = arrayOfNulls<Node>(elements.size * 2)
        for (node in elements){
            var currentElement = node
            while (currentElement != null){
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    override fun removeNumber(number: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        elements = arrayOfNulls<Node>(INITIAL_CAPACITY)
    }

    override fun contains(number: Int): Boolean {
        for (node in elements){
            if ()
        }
    }

    private fun getElementPosition(number: Int, arraySize: Int): Int{
        return abs(number % arraySize)
    }

    data class Node(
        val item: Int,
        var next: Node? = null
    )

    companion object{

        private const val INITIAL_CAPACITY = 15
        private const val LOAD_FACTOR = 0.75
    }
}