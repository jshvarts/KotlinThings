package com.shvartsy.kotlinthings.casts

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Unit tests for {@link TypeChecksAndCastsExamplesTest}.
 */
const val SAMPLE_STRING = "asdf"

class TypeChecksAndCastsExamplesTest {
    lateinit var testSubject: TypeChecksAndCastsExamples

    @Before
    fun setUp() {
        testSubject = TypeChecksAndCastsExamples()
    }

    @Test
    fun operatorIs_whenParamIsString_returnsParamLength() {
        // GIVEN
        val param: Any = SAMPLE_STRING

        // WHEN
        val result: Int? = testSubject.operatorIs(param)

        // THEN
        assertEquals(SAMPLE_STRING.length, result)
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
        val param: Any = SAMPLE_STRING

        // WHEN
        val result: Int? = testSubject.operatorIsNot(param)

        // THEN
        assertEquals(SAMPLE_STRING.length, result)
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
        val param: Any = SAMPLE_STRING

        // WHEN
        val result: Int? = testSubject.operatorAsAndElvis(param)

        // THEN
        assertEquals(SAMPLE_STRING.length, result)
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

    @Test
    fun whenWithSmartCast_whenParamIsInt_returnsSelf() {
        // GIVEN
        val param: Any = 12

        // WHEN
        val result: Int? = testSubject.whenWithSmartCast(param)

        // THEN
        assertEquals(param, result)
    }

    @Test
    fun whenWithSmartCast_whenParamIsString_returnsParamLength() {
        // GIVEN
        val param: Any = SAMPLE_STRING

        // WHEN
        val result: Int? = testSubject.whenWithSmartCast(param)

        // THEN
        assertEquals(SAMPLE_STRING.length, result)
    }

    @Test
    fun whenWithSmartCast_whenParamIsList_returnsMinus1() {
        // GIVEN
        val param: Any = listOf(1, 2)

        // WHEN
        val result: Int? = testSubject.whenWithSmartCast(param)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun safeCastAfterAndOr_whenParamIsNotString_returnsMinus1() {
        // GIVEN
        val param: Any = 5

        // WHEN
        val result: Int? = testSubject.safeCastAfterAndOr(param)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun safeCastAfterAndOr_whenParamIsStringWithLength0_returnsMinus1() {
        // GIVEN
        val paramWithLength0: Any = ""

        // WHEN
        val result: Int? = testSubject.safeCastAfterAndOr(paramWithLength0)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun safeCastAfterAndOr_whenParamIsString_returnsParamLength() {
        // GIVEN
        val param: Any = SAMPLE_STRING

        // WHEN
        val result: Int? = testSubject.safeCastAfterAndOr(param)

        // THEN
        assertEquals(SAMPLE_STRING.length, result)
    }
}