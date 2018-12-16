package com.codingblocks.conduit.anko.layouts.activities

import android.content.Context
import android.view.Gravity
import android.view.View
import com.codingblocks.conduit.anko.R
import com.codingblocks.conduit.anko.extensions.importView
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class MainActivityUI: AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        drawerLayout {
            fitsSystemWindows = true
            frameLayout {
                textView("Hello World") {

                }.lparams(wrapContent, wrapContent, Gravity.CENTER)
            }.lparams(matchParent, matchParent)

            navigationView {
                fitsSystemWindows = true
                addHeaderView(importView(NavDrawerHeaderUI()))
                inflateMenu(R.menu.main_menu_loggedout)
            }.lparams(wrapContent, matchParent, Gravity.START)
        }
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