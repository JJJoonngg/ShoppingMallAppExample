package com.jjjoonngg.parayo.intro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.jjjoonngg.parayo.api.ParayoApi
import com.jjjoonngg.parayo.signin.SignInActivity
import com.jjjoonngg.parayo.signup.SignUpActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import java.lang.Exception

class IntroActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ui = IntroActivityUI()
        ui.setContentView(this)

        GlobalScope.launch {
            delay(1000)
            startActivity<SignInActivity>()
            finish()
        }
    }
}