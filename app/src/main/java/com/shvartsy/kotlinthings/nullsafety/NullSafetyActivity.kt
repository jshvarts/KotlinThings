package com.shvartsy.kotlinthings.nullsafety

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.shvartsy.kotlinthings.R

/**
 * Kotlin things related to Null Safety.
 */
class NullSafetyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        println("*** Null Safety ***")
    }
}