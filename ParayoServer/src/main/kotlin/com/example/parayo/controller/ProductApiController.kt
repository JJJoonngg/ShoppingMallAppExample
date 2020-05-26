package com.example.parayo.controller

import com.example.parayo.common.ApiResponse
import com.example.parayo.domain.product.Product
import com.example.parayo.domain.product.ProductService
import com.example.parayo.domain.product.registration.ProductImageService
import com.example.parayo.domain.product.registration.ProductRegistrationRequest
import com.example.parayo.domain.product.registration.ProductRegistrationService
import com.example.parayo.domain.product.toProductListItemResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1")
class ProductApiController @Autowired constructor(
    private val productImageService: ProductImageService,
    private val productRegistration: ProductRegistrationService,
    private val productService: ProductService
) {

    @PostMapping("/product_images")
    fun uploadImage(image: MultipartFile) = ApiResponse.ok(
        productImageService.uploadImage(image)
    )

    @PostMapping("/products")
    fun register(
        @RequestBody request: ProductRegistrationRequest
    ) = ApiResponse.ok(
        productRegistration.register(request)
    )

    @GetMapping("/products")
    fun search(
        @RequestParam productId: Long,
        @RequestParam(required = false) categoryId: Int?,
        @RequestParam direction: String,
        @RequestParam(required = false) limit: Int?
    ) = productService.search(categoryId, productId, direction, limit ?: 10)
        .mapNotNull(Product::toProductListItemResponse)
        .let { ApiResponse.ok(it) }
}