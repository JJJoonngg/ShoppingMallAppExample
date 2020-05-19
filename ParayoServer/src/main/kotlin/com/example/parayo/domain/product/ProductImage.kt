package com.example.parayo.domain.product

import java.util.*
import javax.persistence.*

@Entity(name = "product_image")
class ProductImage(
    var path: String,
    var productId: Long? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var createdAt: Date? = null
    var updatedAt: Date? = null

    @PrePersist
    fun prePersist() {
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = Date()
    }
}