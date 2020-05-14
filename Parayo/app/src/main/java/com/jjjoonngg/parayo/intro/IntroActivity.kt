package com.jjjoonngg.parayo.intro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.jjjoonngg.parayo.api.ParayoApi
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.setContentView
import java.lang.Exception

class IntroActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ui = IntroActivityUI()
        ui.setContentView(this)

        runBlocking {
            try {
                val response = ParayoApi.instance.hello()
                Log.d("IntroActivity", response.data)
            } catch (exception: Exception) {
                Log.e("IntroActivity", "Hello API 호출 오류", exception)
            }
        }
    }
}