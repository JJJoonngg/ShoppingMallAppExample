package com.jjjoonngg.parayo.product

import android.app.Application
import android.app.IntentService
import android.content.Intent
import com.jjjoonngg.parayo.product.registration.ProductRegistrationActivity
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductMainViewModel(app: Application) : BaseViewModel(app) {
    fun openRegistrationActivity() {
        startActivity<ProductRegistrationActivity>() { flags = Intent.FLAG_ACTIVITY_SINGLE_TOP }
    }
}