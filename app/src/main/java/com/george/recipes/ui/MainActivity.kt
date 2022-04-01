package com.george.recipes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.george.recipes.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val huts: String = "Huts"
        Timber.d(huts)
    }
}