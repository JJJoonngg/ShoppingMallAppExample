package com.jjjoonngg.parayo.product.registration

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.jjjoonngg.parayo.R
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
    }.lparams(dip(60), dip(60))
}