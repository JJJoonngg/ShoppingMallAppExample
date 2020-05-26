package com.jjjoonngg.parayo.product.list

import android.app.Application
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductListViewModel(app: Application) : BaseViewModel(app) {
    fun onClickItem(id: Long?) {
        toast("click $id")
    }
}