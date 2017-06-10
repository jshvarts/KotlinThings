package com.shvartsy.kotlinthings.nullsafety

import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for {@link NullSafetyExamples}.
 */
class NullSafetyExamplesTest {

    lateinit var testSubject: NullSafetyExamples

    val notNullString: String = "not null"
    val nullString: String? = null

    @Before
    fun setUp() {
        testSubject = NullSafetyExamples()
    }

    @Test
    fun safeCallNullCheck_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.safeCallNullCheck(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test
    fun safeCallNullCheck_whenParamNull_returnsNull() {
        // WHEN
        val result: Int? = testSubject.safeCallNullCheck(nullString)

        // THEN
        assertNull(result)
    }

    @Test
    fun dotLet_whenParamNotNull_executesFooAndReturnsParamLength() {
        // GIVEN
        testSubject = spy(testSubject)

        // WHEN
        val result: Int? = testSubject.dotLet(notNullString)

        // THEN
        verify(testSubject).executeFoo()
        assertEquals(notNullString.length, result)
    }

    @Test
    fun dotLet_whenParamIsNull_doesNotExecuteFooAndReturnsNull() {
        // GIVEN
        testSubject = spy(testSubject)

        // WHEN
        val result: Int? = testSubject.dotLet(nullString)

        // THEN
        verify(testSubject, never()).executeFoo()
        assertNull(result)
    }

    @Test
    fun elvisOperator_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.elvisOperator(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test
    fun elvisOperator_whenParamIsNull_returnsMinus1() {
        // WHEN
        val result: Int? = testSubject.elvisOperator(nullString)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun ifNullCheck_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.ifNullCheck(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test
    fun ifNullCheck_whenParamIsNull_returnsMinus1() {
        // WHEN
        val result: Int? = testSubject.ifNullCheck(nullString)

        // THEN
        assertEquals(-1, result)
    }

    @Test
    fun checkParamReturnNullWithElvisOperator_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.checkParamReturnNullWithElvisOperator(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test
    fun checkParamReturnNullWithElvisOperator_whenParamIsNull_returnsNull() {
        // WHEN
        val result: Int? = testSubject.checkParamReturnNullWithElvisOperator(nullString)

        // THEN
        assertNull(result)
    }

    @Test
    fun checkParamThrowExceptionWithElvisOperator_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.checkParamThrowExceptionWithElvisOperator(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkParamThrowExceptionWithElvisOperator_whenParamIsNull_throwsException() {
        // WHEN
        testSubject.checkParamThrowExceptionWithElvisOperator(nullString)
    }

    @Test
    fun doubleBang_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.doubleBang(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test(expected = NullPointerException::class)
    fun doubleBang_whenParamIsNull_throwsException() {
        // WHEN
        testSubject.doubleBang(nullString)
    }

    @Test
    fun safeCast_whenParamNotNull_returnsParamLength() {
        // WHEN
        val result: Int? = testSubject.safeCast(notNullString)

        // THEN
        assertEquals(notNullString.length, result)
    }

    @Test
    fun safeCast_whenParamIsNull_returnsNull() {
        // WHEN
        val result: Int? = testSubject.safeCast(nullString)

        // THEN
        assertNull(result)
    }


    @Test
    fun filterNotNullFromNullableListElements_retainsNotNullElementsOnly() {
        // GIVEN
        val nullableList: List<Int?> = listOf(1, 2, null, 4)

        // WHEN
        val result: List<Int> = testSubject.filterNotNullFromNullableListElements(nullableList)

        // THEN
        assertEquals(3, result.size)
    }
}