package com.jjjoonngg.parayo.intro

import android.app.Activity
import android.os.Bundle
import com.jjjoonngg.parayo.common.Prefs
import com.jjjoonngg.parayo.product.ProductMainActivity
import com.jjjoonngg.parayo.signin.SignInActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class IntroActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ui = IntroActivityUI()
        ui.setContentView(this)

        GlobalScope.launch {
            delay(1000)
            if (Prefs.token.isNullOrEmpty()) {
                startActivity<SignInActivity>()
            } else {
                startActivity<ProductMainActivity>()
            }
            finish()
        }
    }
}