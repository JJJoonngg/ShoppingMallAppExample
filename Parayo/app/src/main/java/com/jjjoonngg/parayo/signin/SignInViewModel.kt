package com.jjjoonngg.parayo.signin

import android.app.Application
import androidx.lifecycle.MutableLiveData
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class SignInViewModel(app: Application) : BaseViewModel(app) {
    val email = MutableLiveData("")
    val password = MutableLiveData("")
}