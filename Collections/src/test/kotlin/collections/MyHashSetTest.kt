package collections

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyHashSetTest {

    private val numbers = MyHashSet<Int>()

    @Test
    fun `When added 100 elements then size is 100`() {
        repeat(100) {
            numbers.add(it)
        }
        assertEquals(100, numbers.size)
    }

    @Test
    fun `When added 10 similar elements then size is 1`() {
        repeat(10) {
            numbers.add(0)
        }
        assertEquals(1, numbers.size)
    }

    @Test
    fun `When adding is succeed then method return true`() {
        assertTrue { numbers.add(100) }
    }

    @Test
    fun `When adding is failed then method return false`() {
        numbers.add(100)
        assertFalse { numbers.add(100) }
    }

    @Test
    fun `When element present in set Then method returns true`() {
        repeat(10) {
            numbers.add(it)
        }
        assertTrue { numbers.contains(9) }
    }

    @Test
    fun `When element is absent in set Then method returns false`() {
        repeat(10) {
            numbers.add(it)
        }
        assertFalse { numbers.contains(10) }
    }

    @Test
    fun `When element removed then size must be decreased`(){
        repeat(10){
            numbers.add(it)
        }
        numbers.removeNumber(5)
        assertEquals(9, numbers.size)
    }

    @Test
    fun `When element removed then contains return false`(){
        repeat(10){
            numbers.add(it)
        }
        numbers.removeNumber(5)
        assertFalse { numbers.contains(5) }
    }

    @Test
    fun `When set is cleared then size is 0`(){
        repeat(10){
            numbers.add(it)
        }
        numbers.clear()
        assertEquals(0, numbers.size)
    }

    @Test
    fun `When set is cleared then all elements  is absent`(){
        repeat(10){
            numbers.add(it)
        }
        numbers.clear()
        repeat(10){
           assertFalse { numbers.contains(it) }
        }
    }
}