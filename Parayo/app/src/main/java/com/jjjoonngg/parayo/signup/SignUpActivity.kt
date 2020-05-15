package com.jjjoonngg.parayo.signup

import android.os.Bundle
import android.os.PersistableBundle
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView

class SignUpActivity : BaseActivity<SignUpViewModel>() {
    override val viewModelType = SignUpViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SignUpActivityUI(getViewModel())
            .setContentView(this)
    }
}