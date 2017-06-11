package com.shvartsy.kotlinthings.inheritance

/**
 * Sub-class to demonstrate inheritance in Kotlin.
 */
class Student(id: Int, fullName: String) : Person(id, fullName) {
    var graduationYear: Int? = null

    init {
        println("initialized Student")
    }

    constructor(id: Int, fullName: String, graduationYear: Int) : this(id, fullName) {
        this.graduationYear = graduationYear
    }
}