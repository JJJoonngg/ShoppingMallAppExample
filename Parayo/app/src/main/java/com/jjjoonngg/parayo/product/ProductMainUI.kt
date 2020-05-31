package com.jjjoonngg.parayo.product

import android.view.Gravity
import android.view.Menu.NONE
import android.view.MenuItem
import android.view.MenuItem.SHOW_AS_ACTION_ALWAYS
import android.view.View.generateViewId
import android.widget.TableLayout
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.GRAVITY_FILL
import com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE
import com.jjjoonngg.parayo.R
import com.jjjoonngg.parayo.common.Prefs
import com.jjjoonngg.parayo.signin.SignInActivity
import com.jjjoonngg.parayo.view.borderBottom
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.design.themedTabLayout
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onQueryTextListener
import org.jetbrains.anko.support.v4.drawerLayout
import org.jetbrains.anko.support.v4.viewPager

class ProductMainUI(
    private val viewModel: ProductMainViewModel
) : AnkoComponent<ProductMainActivity>,
    NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var tablayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<ProductMainActivity>) =
        ui.drawerLayout {
            drawerLayout = this

            frameLayout {
                verticalLayout {
                    toolbar = toolbar {
                        title = "Parayo"
                        bottomPadding = dip(1)
                        background = borderBottom(width = dip(1))
                        menu.add("Search")
                            .setIcon(R.drawable.ic_search_black)
                            .setActionView(searchView {
                                onQueryTextListener {
                                    onQueryTextSubmit { key ->
                                        viewModel.openSearchActivity(key)
                                        true
                                    }
                                }
                            })
                            .setShowAsAction(SHOW_AS_ACTION_ALWAYS)
                    }.lparams(matchParent, wrapContent)

                    tablayout = themedTabLayout(
                        R.style.Widget_MaterialComponents_TabLayout
                    ) {
                        bottomPadding = dip(1)
                        tabMode = MODE_SCROLLABLE
                        tabGravity = GRAVITY_FILL
                        background = borderBottom(width = dip(1))
                        lparams(matchParent, wrapContent)
                    }

                    viewPager = viewPager {
                        id = generateViewId()
                    }.lparams(matchParent, matchParent)
                }

                floatingActionButton {
                    imageResource = R.drawable.ic_add
                    onClick { viewModel.openRegistrationActivity() }
                }.lparams {
                    bottomMargin = dip(20)
                    marginEnd = dip(20)
                    gravity = Gravity.END or Gravity.BOTTOM
                }
            }
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