package com.shvartsy.kotlinthings.inheritance

/**
 * Base class to demonstrate inheritance in Kotlin.
 */
open class Person(val id: Int, val fullName: String) {
    var married: Boolean = false
        set // public setter for married
}