package com.codingblocks.conduit.anko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.core.view.iterator
import com.codingblocks.conduit.anko.fragments.HomeFragment
import com.codingblocks.conduit.anko.fragments.SigninFragment
import com.codingblocks.conduit.anko.fragments.SignupFragment
import com.codingblocks.conduit.anko.layouts.activities.MainActivityUI
import com.google.android.material.navigation.NavigationView
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var ui: MainActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = MainActivityUI().also {
            it.setContentView(this)
            it.nav.setNavigationItemSelectedListener(this)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment =  when (item.itemId) {
            R.id.menu_home -> HomeFragment()
            R.id.menu_signin -> SigninFragment()
            R.id.menu_signup -> SignupFragment()
            else -> HomeFragment()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(ui.container.id, fragment)
            .commit()
        item.isChecked = true
        ui.drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
