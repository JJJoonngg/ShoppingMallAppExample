package com.jjjoonngg.parayo.product.registration

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.jjjoonngg.parayo.product.category.categoryList
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductRegistrationViewModel(app: Application) : BaseViewModel(app) {

    val imagesUrls: List<MutableLiveData<String?>> = listOf(
        MutableLiveData(null as String?),
        MutableLiveData(null as String?),
        MutableLiveData(null as String?),
        MutableLiveData(null as String?)
    )

    val imagesIds: MutableList<Long?> =
        mutableListOf(null, null, null, null)

    val productName = MutableLiveData("")
    val description = MutableLiveData("")
    val price = MutableLiveData("")
    val categories = MutableLiveData(categoryList.map { it.name })
    var categoryIdSelected: Int? = categoryList[0].id

    val descriptionLimit = 500
    val productNameLimit = 40

    val productNameLength = MutableLiveData("0/$productNameLimit")
    val descriptionLength = MutableLiveData("0/$descriptionLimit")
}