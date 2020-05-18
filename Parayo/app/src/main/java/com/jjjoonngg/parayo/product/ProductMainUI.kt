package com.jjjoonngg.parayo.product

import android.view.Gravity
import android.view.Menu.NONE
import android.view.MenuItem
import android.view.MenuItem.SHOW_AS_ACTION_ALWAYS
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.jjjoonngg.parayo.R
import com.jjjoonngg.parayo.common.Prefs
import com.jjjoonngg.parayo.signin.SignInActivity
import com.jjjoonngg.parayo.view.borderBottom
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class ProductMainUI(
    private val viewModel: ProductMainViewModel
) : AnkoComponent<ProductMainActivity>,
    NavigationView.OnNavigationItemSelectedListener {

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
                    .let(::addHeaderView)

                menu.apply {
                    add(NONE, MENU_ID_INQUIRY, NONE, "내 문의").apply {
                        setIcon(R.drawable.ic_chat)
                    }
                    add(NONE, MENU_ID_LOGOUT, NONE, "로그아웃").apply {
                        setIcon(R.drawable.ic_signout)
                    }
                }

                setNavigationItemSelectedListener(this@ProductMainUI)
            }.lparams(wrapContent, matchParent) {
                gravity = Gravity.START
            }
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_ID_INQUIRY -> {
                viewModel.toast("내 문의")
            }
            MENU_ID_LOGOUT -> {
                Prefs.token = null
                Prefs.refreshToken = null
                viewModel.startActivityAndFinish<SignInActivity>()
            }
        }
        drawerLayout.closeDrawer(navigationView)
        return true
    }


    companion object {
        private const val MENU_ID_INQUIRY = 1
        private const val MENU_ID_LOGOUT = 2
    }
}