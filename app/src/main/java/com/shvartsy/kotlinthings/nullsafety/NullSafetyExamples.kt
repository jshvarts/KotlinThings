package com.shvartsy.kotlinthings.nullsafety

/**
 * Kotlin idioms regarding Null Safety.
 */
class NullSafetyExamples {

    /**
     * Safe call: results in null value rather than NullPointerException. Safe calls are useful in chains.
     */
    fun safeCallNullCheck(str: String?): Int? = str?.length

    /**
     * .let {} performs a certain operation only on non-null values
     */
    fun dotLet(str: String?): Int?  = str?.let {
        executeFoo()
        return it.length
    }

    fun elvisOperator(str: String?): Int = str?.length ?: -1

    fun ifNullCheck(str: String?): Int {
        if (str != null) {
            // compiler tracks the null check and lets you access the value without the "?"
            return str.length
        } else {
            return -1
        }
    }

    /**
     * Since return is an expression in Kotlin, it can be used on the right hand side of the elvis operator.
     * Handy for checking function arguments
     */
    fun checkParamReturnNullWithElvisOperator(str: String?): Int? {
        val ret: String = str ?: return null
        return ret.length
    }


    /**
     * Since throw is an expression in Kotlin, it can be used on the right hand side of the elvis operator.
     * Handy for checking function arguments
     */
    fun checkParamThrowExceptionWithElvisOperator(str: String?): Int? {
        val ret = str ?: throw IllegalArgumentException("str expected")
        return ret.length
    }

    /**
     * The !! Operator
     * Returns NullPointerException if argument is null.
     */
    fun doubleBang(str: String?): Int? {
        return str!!.length
    }

    /**
     * Avoid ClassCastException by performing a safe cast which returns null if cast failed.
     */
    fun safeCast(str: String?): Int? {
        val ret = str as? String
        return ret?.length
    }

    /**
     * Filters non null values out of a collection of elements of a nullable type
     */
    fun filterNotNullFromNullableListElements(nullableList: List<Int?>): List<Int> {
        return nullableList.filterNotNull()
    }

    fun executeFoo() {}
}