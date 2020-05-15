package com.jjjoonngg.parayo.signin

import android.os.Bundle
import android.os.PersistableBundle
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView

class SignInActivity : BaseActivity<SignInViewModel>() {
    override val viewModelType = SignInViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SignInActivityUI(getViewModel())
            .setContentView(this)
    }
}