package com.jjjoonngg.parayo.product.search

import android.app.Application
import android.content.Intent
import com.jjjoonngg.parayo.product.detail.ProductDetailActivity
import com.jjjoonngg.parayo.product.list.ProductListItemDateSource
import com.jjjoonngg.parayo.product.list.ProductListPagedAdapter
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductSearchViewModel(app: Application) : BaseViewModel(app),
    ProductListPagedAdapter.ProductLiveDataBuilder,
    ProductListPagedAdapter.OnItemClickListener {

    var keyword: String? = null
    var products = buildPagedList()

    override fun createDateSource() = ProductListItemDateSource(null, keyword)

    override fun onClickProduct(productId: Long?) {
        startActivity<ProductDetailActivity> {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            putExtra(ProductDetailActivity.PRODUCT_ID, productId)
        }
    }
}