package com.example.application

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val delta: Double = 0.0001

    @Test
    fun divideNumbers_correctArguments_returnsQuotient() {
        val expected = -4.0

        val result = divideNumbers(10.0, 2.0)

        assertEquals(5.0, result, delta)

        val resultNegative = divideNumbers(-12.0, 3.0)

        assertEquals(expected, resultNegative, delta)
    }

    @Test
    fun divideNumbers_doubleArguments_returnsCorrectDouble() {
        val expected = 2.5

        val result = divideNumbers(5.0, 2.0)

        assertEquals(expected, result, delta)
    }

    @Test
    fun divideNumbers_divisionByZero_throwsIllegalArgumentException() {
        val expected = "Деление на ноль ЗАПРЕЩЕНО!!!"

        val exception = assertThrows(IllegalArgumentException::class.java) {
            divideNumbers(10.0, 0.0)
        }

        assertEquals(expected, exception.message)
    }
}