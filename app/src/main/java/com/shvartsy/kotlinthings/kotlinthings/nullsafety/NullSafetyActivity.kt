package com.shvartsy.kotlinthings.kotlinthings.nullsafety

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.shvartsy.kotlinthings.kotlinthings.R

/**
 * Kotlin things related to Null Safety.
 */
class NullSafetyActivity : AppCompatActivity() {

    val notNullString: String = "NOT_NULL"

    val nullString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        println("*** Null Safety ***")


        printNullIfNull(notNullString)
        printNullIfNull(nullString)


        printNothingIfNull(notNullString)
        printNothingIfNull(nullString)


        printSuppliedDefaultIfNullUsingElvisOp(notNullString)
        printSuppliedDefaultIfNullUsingElvisOp(nullString)


        printAfterIfNullCheck(notNullString)
        printAfterIfNullCheck(nullString)


        println(": " + returnNullInRightHandElvisOp(notNullString))
        println(": " + returnNullInRightHandElvisOp(nullString))


        try {
            println(": " + throwExceptionInRightHandElvisOp(notNullString))
            println(": " + throwExceptionInRightHandElvisOp(nullString))
        } catch (e: IllegalArgumentException) {
            println(" threw exception: " + e)
        }
    }

    /**
     * Produces null value instead of NullPointerException
     */
    fun printNullIfNull(str: String?) = println("printNullIfNull with param $str: " + str?.length)

    /**
     * Performs a certain operation only for non-null values
     */
    fun printNothingIfNull(str: String?) = str?.let { println("printNothingIfNull with param $str: $it") }

    fun printSuppliedDefaultIfNullUsingElvisOp(str: String?) {
        val toPrint: String = str ?: "empty"
        println("printSuppliedDefaultIfNullUsingElvisOp with param $str: $toPrint")
    }

    fun printAfterIfNullCheck(str: String?) {
        if (str != null) {
            // compiler tracks the null check and lets you access the value without the "?"
            println("printAfterIfNullCheck with param $str: " + str.length)
        }
    }

    /**
     * Since return is an expression in Kotlin, it can be used on the right hand side of the elvis operator.
     * Handy for checking function arguments
     */
    fun returnNullInRightHandElvisOp(str: String?): String? {
        print("returnNullInRightHandElvisOp with param: " + str)
        val ret = str ?: return null
        return ret
    }

    /**
     * Since throw is an expression in Kotlin, it can be used on the right hand side of the elvis operator.
     * Handy for checking function arguments
     */
    fun throwExceptionInRightHandElvisOp(str: String?): String? {
        print("throwExceptionInRightHandElvisOp with param: " + str)
        val ret = str ?: throw IllegalArgumentException("str expected")
        return ret
    }
}