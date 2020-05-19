package com.jjjoonngg.parayo.product.registration

import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.verticalLayout

class ProductRegistrationUI(
    private val viewModel: ProductRegistrationViewModel
) : AnkoComponent<ProductRegistrationActivity> {

    override fun createView(ui: AnkoContext<ProductRegistrationActivity>) =
        ui.scrollView {
            verticalLayout { }
        }
}