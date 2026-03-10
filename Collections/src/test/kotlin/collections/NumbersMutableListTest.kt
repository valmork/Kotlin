package collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumbersMutableListTest {


    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 element then size is 1`(list: NumbersMutableList){
        list.add(0)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to first position then it is in first position`(list: NumbersMutableList){
        repeat(100){
            list.add(it)

        }
        list.add(0, 1000)
        assertEquals(1000, list[0])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 elements then size is 10`(list: NumbersMutableList){
        repeat(10){
            list.add(it)
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100 elements then size is 100`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50th element then result is 50`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        assertEquals(50, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreased`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        list.remove(50)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed 50th element then next value at this position`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        list.remove(50)
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed value 50 then next value at this position`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        list.removeNumber(50)
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list is cleared then size is 0`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list contains element then return true`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        assertTrue(list.contains(90))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list does not contain element then return false`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        assertFalse(list.contains(200))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method get invoked with wrong index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list [10]
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method get invoked with negative index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list [-10]
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method add invoked with wrong index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.add(11, 1000)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method add invoked with negative index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.add(-1, 100)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method remove invoked with wrong index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.remove(12)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method remove invoked with negative index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.remove(-1)
        }
    }

    companion object{

        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList(), NumbersLinkedList())
    }

}