package com.codingblocks.conduit.anko.extensions

import android.content.Context
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.UI

inline fun <T: Context> AnkoContext<T>.importView(
    component: AnkoComponent<Context>
): View = this.ctx.UI { component.createView(this) }.view