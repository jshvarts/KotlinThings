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

    /**
     * Safe (nullable) cast. Returns length of String if param has a type of String. Otherwise, returns -1
     */
    fun operatorAsAndElvis(obj: Any): Int? {
        return (obj as? String)?.length ?: -1
    }

    fun whenWithSmartCast(obj: Any): Int {
        when(obj) {
            is Int -> return obj
            is String -> return obj.length
            else -> return -1
        }
    }
}