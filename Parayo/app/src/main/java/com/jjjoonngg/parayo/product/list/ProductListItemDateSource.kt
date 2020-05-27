package com.jjjoonngg.parayo.product.list

import androidx.paging.PageKeyedDataSource
import com.jjjoonngg.parayo.App
import com.jjjoonngg.parayo.api.ParayoApi
import com.jjjoonngg.parayo.api.response.ApiResponse
import com.jjjoonngg.parayo.api.response.ProductListItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.toast
import java.lang.Exception

class ProductListItemDateSource(
    private val categoryId: Int?
) : PageKeyedDataSource<Long, ProductListItemResponse>() {

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ProductListItemResponse>
    ) {
        val response = getProducts(Long.MAX_VALUE, NEXT)
        if (response.success) {
            response.data?.let {
                if (it.isNotEmpty()) callback.onResult(it, it.first().id, it.last().id)
            }
        } else {
            GlobalScope.launch(Dispatchers.Main) {
                showErrorMessage(response)
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, ProductListItemResponse>
    ) {
        val response = getProducts(params.key, NEXT)
        if (response.success) {
            response.data?.let { if (it.isNotEmpty()) callback.onResult(it, it.last().id) }
        } else {
            GlobalScope.launch(Dispatchers.Main) {
                showErrorMessage(response)
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, ProductListItemResponse>
    ) {
        val response = getProducts(params.key, PREV)
        if (response.success) {
            response.data?.let { if (it.isNotEmpty()) callback.onResult(it, it.first().id) }
        } else {
            GlobalScope.launch(Dispatchers.Main) {
                showErrorMessage(response)
            }
        }
    }

    private fun getProducts(id: Long, direction: String) = runBlocking {
        try {
            ParayoApi.instance.getProducts(id, categoryId, direction)
        } catch (exception: Exception) {
            ApiResponse.error<List<ProductListItemResponse>>(
                "알 수 없는 오류가 발생했습니다."
            )
        }
    }

    private fun showErrorMessage(
        response: ApiResponse<List<ProductListItemResponse>>
    ) {
        App.instance.toast(response.message ?: "알수 없는 오류가 발생했습니다.")
    }

    companion object {
        private const val NEXT = "next"
        private const val PREV = "prev"
    }
}