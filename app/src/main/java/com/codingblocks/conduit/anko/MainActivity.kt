package com.codingblocks.conduit.anko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.conduit.anko.layouts.activities.MainActivityUI
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ui = MainActivityUI().also {
            it.setContentView(this)
        }
    }
}
