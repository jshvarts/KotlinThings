package com.shvartsy.kotlinthings.inheritance

/**
 * Student extensions.
 */
/**
 * Removes spaces and lowercases full name
 */
inline fun Student.longName(): String = this.fullName.replace(" ", "").toLowerCase()
