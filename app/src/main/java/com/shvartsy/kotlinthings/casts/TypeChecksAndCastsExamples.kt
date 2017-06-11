package com.shvartsy.kotlinthings.casts

/**
 * Kotlin idioms regarding Type Checks and Casts.
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
     * Safe (nullable) cast. Returns length of String if param has a type of String.
     * Otherwise, returns -1
     */
    fun operatorAsAndElvis(obj: Any): Int? {
        return (obj as? String)?.length ?: -1
    }

    fun whenWithSmartCast(obj: Any): Int = when(obj) {
        is Int -> obj
        is String -> obj.length
        else -> -1
    }

    /**
     * The compiler is smart enough to know a cast to be safe if a negative check
     * leads to a return or in the right-hand side of && and ||
     */
    fun safeCastAfterAndOr(obj: Any): Int {
        if (obj !is String || obj.length == 0) return -1
        return obj.length
    }
}