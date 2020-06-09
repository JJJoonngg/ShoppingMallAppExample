package com.jjjoonngg.parayo.inquiry

import android.app.Application
import androidx.paging.DataSource
import com.jjjoonngg.parayo.api.response.InquiryResponse
import net.codephobia.ankomvvm.lifecycle.BaseViewModel
import org.jetbrains.anko.error
import java.lang.IllegalStateException

class ProductInquiryViewModel(app: Application) :
    BaseViewModel(app), InquiryPagedAdapter.InquiryLiveDataBuilder,
    InquiryPagedAdapter.InquiryItemClickListener {

    var productId: Long = -1
    val inquiries = buildPagedList()
    override fun createDateSource(): DataSource<Long, InquiryResponse> {
        if (productId == -1L)
            error("productId가 설정되지 않았습니다.", IllegalStateException("productId is -1"))
        return InquiryDataSource(productId)
    }

    override fun onClickInquiry(inquiryResponse: InquiryResponse?) {
        //do nothing
    }

    override fun onClickAnswer(inquiryResponse: InquiryResponse?) {
        inquiryResponse?.run { inquiry("ANSWER", id) }
    }

    fun inquiry(type: String, inquiryId: Long? = null) {
        toast("상품 문의 - type : $type, inquiryId = $inquiryId")
    }

}