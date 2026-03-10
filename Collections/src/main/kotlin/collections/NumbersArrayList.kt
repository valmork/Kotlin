package collections

class NumbersArrayList : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(number: Int) {
        growIfNeeded()
        numbers[size] = number
        size++
    }

    override fun remove(index: Int) {
        checkIndex(index)
        System.arraycopy(numbers, index + 1, numbers,  index, size - index - 1)
        size--
        numbers[size] = null
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return numbers[index]!!
    }

    private fun growIfNeeded(){
        if (numbers.size == size){
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, size)
            numbers = newArray
        }
    }

    override fun removeNumber(number: Int) {
        for (i in 0 until size){
            if (numbers[i] == number){
                remove(i)
                return
            }
        }
    }

    override fun add(index: Int, number: Int) {
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(numbers, index, numbers, index + 1, size - index)
        numbers[index] = number
        size++
    }

    override fun clear() {
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        for (i in 0 until size){
            if (numbers[i] == number){
                return true
            }
        }
        return false
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun minus(number: Int) {
        removeNumber(number)
    }

    private fun checkIndex(index: Int){
        if (index < 0 || index >= size){
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    private fun checkIndexForAdding(index: Int){
        if (index < 0 || index > size){
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    companion object{

        private const val INITIAL_CAPACITY = 10
    }
}