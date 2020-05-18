package com.jjjoonngg.parayo.product

import android.view.Gravity
import com.google.android.material.navigation.NavigationView
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
            }.lparams(matchParent, matchParent)

            navigationView = navigationView {
            }.lparams(wrapContent, matchParent) {
                gravity = Gravity.START
            }
        }
}