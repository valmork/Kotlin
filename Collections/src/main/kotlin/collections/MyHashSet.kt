package collections

import kotlin.math.abs

class MyHashSet<T> : MyMutableSet<T> {

    private var modCount = 0
    var elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        modCount++
        if (size >= elements.size * LOAD_FACTOR){
            increaseArray()
        }
        return add(element, elements).also { added ->
            if (added){
                size++
            }
        }
    }

    private fun add(element: T, array: Array<Node<T>?>): Boolean{
        modCount++
        val newElement = Node(element)
        val position = getElementPosition(element, array.size)
        var existedElement = array[position]
        if (existedElement == null){
            array[position] = newElement
            return true
        } else {
            while (true) {
                if (existedElement?.item == element) {
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
        val newArray = arrayOfNulls<Node<T >>(elements.size * 2)
        for (node in elements){
            var currentElement = node
            while (currentElement != null){
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    override fun removeNumber(element: T) {
        modCount++
        val position = getElementPosition(element, elements.size)
        var existedElement = elements[position] ?: return
        if (existedElement.item == element) {
            elements [position] = existedElement.next
            size--
            return
        } else {
            var previous = existedElement
            existedElement = existedElement.next ?: return
            while (true) {
                if (existedElement.item == element) {
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
        modCount++
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
        val position = getElementPosition(element, elements.size)
        var existedElement = elements[position]
        if (existedElement == null) return false
        else {
            while (true) {
                if (existedElement?.item == element) return true
                else {
                    if (existedElement?.next == null) {
                        return false
                    } else {
                        if (existedElement.next?.item == element) {
                            return true
                        } else {
                            existedElement = existedElement.next
                        }
                    }
                }
            }
        }
    }

    private fun getElementPosition(element: T, arraySize: Int): Int{
        return abs(element.hashCode() % arraySize)
    }

    override fun iterator(): MutableIterator<T> {
         return object : MutableIterator<T>{

             private val currentModCount = modCount
             private var nodeIndex = 0
             private var nextNode = elements[nodeIndex]
             private var nextIndex = 0

             override fun hasNext(): Boolean {
                 return nextIndex < size
             }

             override fun next(): T {
                 if (currentModCount != modCount) throw ConcurrentModificationException()
                 while (nextNode == null){
                     nextNode = elements[++nodeIndex]
                 }
                 return nextNode?.item!!.also {
                     nextIndex++
                     nextNode = nextNode?.next
                 }
             }

             override fun remove() {
                 TODO("Not yet implemented")
             }
         }
    }

    data class Node<T>(
        val item: T,
        var next: Node<T>? = null
    )

    companion object{

        private const val INITIAL_CAPACITY = 15
        private const val LOAD_FACTOR = 0.75
    }
}