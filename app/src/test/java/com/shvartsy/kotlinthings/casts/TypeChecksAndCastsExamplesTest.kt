package com.shvartsy.kotlinthings.casts

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Unit tests for {@link TypeChecksAndCastsExamplesTest}.
 */
class TypeChecksAndCastsExamplesTest {
    lateinit var testSubject: TypeChecksAndCastsExamples

    @Before
    fun setUp() {
        testSubject = TypeChecksAndCastsExamples()
    }

    @Test
    fun operatorIs_whenParamIsString_returnsParamLength() {
        // GIVEN
        val param: Any = "asdf"
        val paramLength = "asdf".length

        // WHEN
        val result: Int? = testSubject.operatorIs(param)

        // THEN
        assertEquals(result, paramLength)
    }

    @Test
    fun operatorIs_whenParamNotString_returnsMinus1() {
        // GIVEN
        val param: Any = 12

        // WHEN
        val result: Int? = testSubject.operatorIs(param)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun operatorIsNot_whenParamIsString_returnsParamLength() {
        // GIVEN
        val param: Any = "asdf"
        val paramLength = "asdf".length

        // WHEN
        val result: Int? = testSubject.operatorIsNot(param)

        // THEN
        assertEquals(result, paramLength)
    }

    @Test
    fun operatorIsNot_whenParamIsNotString_returnsMinus1() {
        // GIVEN
        val param: Any = 12

        // WHEN
        val result: Int? = testSubject.operatorIsNot(param)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun operatorAsAndElvis_whenParamIsString_returnsParamLength() {
        // GIVEN
        val param: Any = "asdf"
        val paramLength = "asdf".length

        // WHEN
        val result: Int? = testSubject.operatorAsAndElvis(param)

        // THEN
        assertEquals(result, paramLength)
    }

    @Test
    fun operatorAsAndElvis_whenParamIsString_returnsMinus1() {
        // GIVEN
        val param: Any = 12

        // WHEN
        val result: Int? = testSubject.operatorAsAndElvis(param)

        // THEN
        assertEquals(-1, result)
    }
}