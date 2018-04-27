package ru.andrey.savchenko.mvptest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val list0 = mutableListOf<User>()
        val list3 = mutableListOf<User>()
        val list1 = mutableListOf<User>(User(1, "test"))
        val list2 = mutableListOf<User>(User(2, "test"), User(3, "askdfj"))
        println(list1===list2)
        println(list0==list3)
        assertEquals(4, 2 + 2)
    }
}
