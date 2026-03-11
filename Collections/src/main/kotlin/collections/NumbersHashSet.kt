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
        val position = getElementPosition(number, elements.size)
        var existedElement = elements[position] ?: return
        if (existedElement.item == number) {
            elements [position] = existedElement.next
            size--
            return
        } else {
            var previous = existedElement
            existedElement = existedElement.next ?: return
            while (true) {
                if (existedElement.item == number) {
                    previous.next = existedElement.next
                    size--
                    return
                } else {
                    previous = existedElement
                    existedElement = existedElement.next ?: return
                }
            }
        }
    }

    override fun clear() {
        elements = arrayOfNulls<Node>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        val position = getElementPosition(number, elements.size)
        var existedElement = elements[position]
        if (existedElement == null) return false
        else {
            while (true) {
                if (existedElement?.item == number) return true
                else {
                    if (existedElement?.next == null) {
                        return false
                    } else {
                        if (existedElement.next?.item == number) {
                            return true
                        } else {
                            existedElement = existedElement.next
                        }
                    }
                }
            }
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