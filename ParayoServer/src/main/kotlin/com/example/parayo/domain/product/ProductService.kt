package com.example.parayo.domain.product

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class ProductService @Autowired constructor(
    private val productRepository: ProductRepository
) {
    fun search(
        categoryId: Int?, productId: Long, direction: String, limit: Int
    ): List<Product> {
        val pageable = PageRequest.of(0, limit)
        val condition = ProductSearchCondition(
            categoryId != null,
            direction
        )

        return when (condition) {
            NEXT_IN_CATEGORY -> productRepository.findByCategoryIdAndIdLessThanOrderByIdDesc(
                categoryId, productId, pageable
            )
            PREV_IN_CATEGORY -> productRepository.findByCategoryIdAndIdGreaterThanOrderByIdDesc(
                categoryId, productId, pageable
            )
            else -> throw  IllegalArgumentException("상품 검색 조건 오류")
        }
    }

    data class ProductSearchCondition(
        val categoryIdIsNotNll: Boolean,
        val direction: String
    )

    companion object {
        val NEXT_IN_CATEGORY = ProductSearchCondition(true, "next")
        val PREV_IN_CATEGORY = ProductSearchCondition(true, "next")
    }
}