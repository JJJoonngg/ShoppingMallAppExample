package com.jjjoonngg.parayo.product

import android.app.Application
import android.app.IntentService
import android.content.Intent
import com.jjjoonngg.parayo.product.registration.ProductRegistrationActivity
import com.jjjoonngg.parayo.product.search.ProductSearchActivity
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductMainViewModel(app: Application) : BaseViewModel(app) {

    fun openSearchActivity(keyword:String?){
        keyword?.let{
            startActivity<ProductSearchActivity>{
                putExtra(ProductSearchActivity.KEYWORD, keyword)
            }
        }?:toast("검색 키워드를 입력해주세요.")
    }

    fun openRegistrationActivity() {
        startActivity<ProductRegistrationActivity>() { flags = Intent.FLAG_ACTIVITY_SINGLE_TOP }
    }
}