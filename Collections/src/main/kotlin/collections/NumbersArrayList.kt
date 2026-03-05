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
        for (i in index until size - 1){
            numbers[i] = numbers[i + 1]
        }
        size--
        numbers[size] = null
    }

    override fun get(index: Int): Int {
        return numbers[index]!!
    }

    private fun growIfNeeded(){
        if (numbers.size == size){
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            for (index in numbers.indices){
                newArray[index] = numbers[index]
            }
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
        growIfNeeded()
        for (i in size downTo index + 1){
            numbers[i] = numbers[i - 1]
        }
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

    companion object{

        private const val INITIAL_CAPACITY = 10
    }
}