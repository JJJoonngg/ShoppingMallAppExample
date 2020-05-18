package com.jjjoonngg.parayo.product

import android.view.Gravity
import android.view.MenuItem.SHOW_AS_ACTION_ALWAYS
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.jjjoonngg.parayo.R
import com.jjjoonngg.parayo.view.borderBottom
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class ProductMainUI(
    private val viewModel: ProductMainViewModel
) : AnkoComponent<ProductMainActivity> {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<ProductMainActivity>) =
        ui.drawerLayout {
            drawerLayout = this

            verticalLayout {
                toolbar = toolbar {
                    title = "Parayo"
                    bottomPadding = dip(1)
                    background = borderBottom(width = dip(1))
                    menu.add("Search")
                        .setIcon(R.drawable.ic_search_black)
                        .setShowAsAction(SHOW_AS_ACTION_ALWAYS)
                }.lparams(matchParent, wrapContent)
            }.lparams(matchParent, matchParent)

            navigationView = navigationView {
                ProductMainNavHeader()
                    .createView(AnkoContext.create(context, this))
                    .run(::addHeaderView)
            }.lparams(wrapContent, matchParent) {
                gravity = Gravity.START
            }
        }
}