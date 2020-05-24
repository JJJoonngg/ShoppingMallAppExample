package com.jjjoonngg.parayo.product.registration

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.jjjoonngg.parayo.R
import com.jjjoonngg.parayo.api.ApiGenerator
import net.codephobia.ankomvvm.databinding.bindUrl
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ProductRegistrationUI(
    private val viewModel: ProductRegistrationViewModel
) : AnkoComponent<ProductRegistrationActivity> {

    override fun createView(ui: AnkoContext<ProductRegistrationActivity>) =
        ui.scrollView {
            verticalLayout {
                padding = dip(20)
                clipToPadding = false

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    pickImageView(ui, 0)
                    space().lparams(dip(8))
                    pickImageView(ui, 1)
                    space().lparams(dip(8))
                    pickImageView(ui, 2)
                    space().lparams(dip(8))
                    pickImageView(ui, 3)
                }
            }
        }

    private fun _LinearLayout.pickImageView(
        ui: AnkoContext<ProductRegistrationActivity>, imageNum: Int
    ) = imageView(R.drawable.ic_image) {
        scaleType = ImageView.ScaleType.CENTER
        backgroundColor = 0xFFEEEEEE.toInt()
        onClick { viewModel.pickImage(imageNum) }
        bindUrl(ui.owner, viewModel.imagesUrls[imageNum]) {
            it?.let {
                scaleType = ImageView.ScaleType.CENTER_CROP
                Glide.with(this)
                    .load("${ApiGenerator.HOST}$it")
                    .centerCrop()
                    .into(this)
            }
        }
    }.lparams(dip(60), dip(60))
}