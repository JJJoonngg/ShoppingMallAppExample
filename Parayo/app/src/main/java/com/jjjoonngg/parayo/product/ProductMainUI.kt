package com.jjjoonngg.parayo.product

import android.view.Gravity
import android.view.MenuItem.SHOW_AS_ACTION_ALWAYS
import com.google.android.material.navigation.NavigationView
import com.jjjoonngg.parayo.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class ProductMainUI(
    private val viewModel: ProductMainViewModel
) : AnkoComponent<ProductMainActivity> {

    lateinit var navigationView: NavigationView

    override fun createView(ui: AnkoContext<ProductMainActivity>) =
        ui.drawerLayout {
            verticalLayout {
                toolbar {
                    title = "Parayo"
                    menu.add("Search")
                        .setIcon(R.drawable.ic_search_black)
                        .setShowAsAction(SHOW_AS_ACTION_ALWAYS)
                }.lparams(matchParent, wrapContent)
            }.lparams(matchParent, matchParent)

            navigationView = navigationView {
            }.lparams(wrapContent, matchParent) {
                gravity = Gravity.START
            }
        }
}