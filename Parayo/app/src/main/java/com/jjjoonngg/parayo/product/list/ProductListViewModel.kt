package com.jjjoonngg.parayo.product.list

import android.app.Application
import android.content.Intent
import androidx.paging.DataSource
import com.jjjoonngg.parayo.api.response.ProductListItemResponse
import net.codephobia.ankomvvm.lifecycle.BaseViewModel
import org.jetbrains.anko.error

class ProductListViewModel(app: Application) : BaseViewModel(app),
    ProductListPagedAdapter.ProductLiveDataBuilder,
    ProductListPagedAdapter.OnItemClickListener {

    var categoryId: Int = -1
    var products = buildPagedList()

    override fun createDateSource(): DataSource<Long, ProductListItemResponse> {
        if (categoryId == -1)
            error(
                "categoryId가 설정되지 않았습니다",
                IllegalStateException("categoryId is -1")
            )
        return ProductListItemDateSource(categoryId)
    }

    override fun onClickProduct(productId: Long?) {
//        startActivity<ProductDetailActivity> {
//            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//            putExtra(ProductDetailActivity.PRODUCT_ID, productId)
//        }
        toast("ProductDetailActivity 구현 예정")
    }
}