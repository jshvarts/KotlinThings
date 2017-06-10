package com.shvartsy.kotlinthings.casts

/**
 * Kotlin things related to Type Checks and Casts.
 */
class TypeChecksAndCastsExamples {

    fun operatorIs(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return -1
    }

    fun operatorIsNot(obj: Any): Int? {
        if (obj !is String) {
            return -1
        }
        return obj.length
    }
}