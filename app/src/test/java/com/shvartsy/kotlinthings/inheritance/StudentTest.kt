package com.shvartsy.kotlinthings.inheritance

import org.junit.Assert.*
import org.junit.Test

/**
 * Unit tests for {@link Student}.
 */
const val SAMPLE_ID: Int = 1
const val FULL_NAME: String = "john smith"
const val GRADUATION_YEAR: Int = 2020

class StudentTest {

    lateinit var testSubject: Student

    @Test
    fun primaryConstructor_setsPersonFieldsOnly() {
        // GIVEN
        testSubject = Student(SAMPLE_ID, FULL_NAME)

        // THEN
        assertEquals(SAMPLE_ID, testSubject.id)
        assertEquals(FULL_NAME, testSubject.fullName)
        assertNull(testSubject.graduationYear)
    }

    @Test
    fun secondaryConstructor_setsStudentFields() {
        // GIVEN
        testSubject = Student(SAMPLE_ID, FULL_NAME, GRADUATION_YEAR)

        // THEN
        assertEquals(SAMPLE_ID, testSubject.id)
        assertEquals(FULL_NAME, testSubject.fullName)
        assertEquals(GRADUATION_YEAR, testSubject.graduationYear)
    }

    @Test
    fun married_canBeSet() {
        // GIVEN
        testSubject = Student(SAMPLE_ID, FULL_NAME)

        // WHEN
        testSubject.married = true

        // THEN
        val isMarried = testSubject.married
        assertTrue(isMarried)
    }

    @Test
    fun firstName_whenAvailable_returnsFirstElementOfFullName() {
        // GIVEN
        testSubject = Student(SAMPLE_ID, FULL_NAME)

        // WHEN
        val firstName = testSubject.firstName()

        // THEN
        assertEquals(FULL_NAME.split(" ")[0], firstName)
    }

    @Test
    fun longName_restructuresFullName() {
        // GIVEN
        testSubject = Student(SAMPLE_ID, FULL_NAME)

        // WHEN
        val result = testSubject.longName()

        // THEN
        assertEquals("johnsmith", result)
    }
}