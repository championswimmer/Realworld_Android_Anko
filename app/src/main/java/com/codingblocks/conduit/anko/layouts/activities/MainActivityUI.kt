package com.codingblocks.conduit.anko.layouts.activities

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.IdRes
import androidx.drawerlayout.widget.DrawerLayout
import com.codingblocks.conduit.anko.R
import com.codingblocks.conduit.anko.extensions.importView
import com.google.android.material.navigation.NavigationView
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class MainActivityUI: AnkoComponent<Context> {
    lateinit var drawer: DrawerLayout
    lateinit var nav: NavigationView
    lateinit var container: FrameLayout

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        drawer = drawerLayout {
            fitsSystemWindows = true

            container = frameLayout {
                id = View.generateViewId()
            }.lparams(matchParent, matchParent)

            nav = navigationView {
                fitsSystemWindows = true
                addHeaderView(importView(NavDrawerHeaderUI()))
                inflateMenu(R.menu.main_menu_loggedout)
            }.lparams(wrapContent, matchParent, Gravity.START)
        }
        drawer
    }

    class NavDrawerHeaderUI: AnkoComponent<Context> {
        override fun createView(ui: AnkoContext<Context>): View = with(ui) {
            frameLayout {
                lparams(matchParent, dip(200))
                backgroundColor = resources.getColor(R.color.colorPrimary)
            }
        }

    }
}