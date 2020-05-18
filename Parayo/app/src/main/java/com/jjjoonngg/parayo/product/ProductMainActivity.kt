package com.jjjoonngg.parayo.product

import android.os.Bundle
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView

class ProductMainActivity : BaseActivity<ProductMainViewModel>() {
    override val viewModelType = ProductMainViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProductMainUI(getViewModel())
            .setContentView(this)
    }
}