package com.jjjoonngg.parayo.api

import com.jjjoonngg.parayo.api.request.ProductRegistrationRequest
import com.jjjoonngg.parayo.api.request.SignInRequest
import com.jjjoonngg.parayo.api.request.SignUpRequest
import com.jjjoonngg.parayo.api.response.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ParayoApi {

    @GET("/api/v1/hello")
    suspend fun hello(): ApiResponse<String>

    companion object {
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)
    }

    @POST("/api/v1/users")
    suspend fun signUp(@Body signUpRequest: SignUpRequest)
            : ApiResponse<Void>

    @POST("/api/v1/signin")
    suspend fun signIn(@Body signInRequest: SignInRequest)
            : ApiResponse<SignInResponse>

    @Multipart
    @POST("api/v1/product_images")
    suspend fun uploadProductImages(
        @Part images: MultipartBody.Part
    ): ApiResponse<ProductImageUploadResponse>

    @POST("/api/v1/products")
    suspend fun registerProduct(
        @Body request: ProductRegistrationRequest
    ): ApiResponse<Response<Void>>

    @GET("/api/v1/products")
    suspend fun getProducts(
        @Query("productId") productId: Long,
        @Query("categoryId") categoryId: Int?,
        @Query("direction") direction: String //prev, next
    ): ApiResponse<List<ProductListItemResponse>>

    @GET("/api/v1/products/{id}")
    suspend fun getProduct(@Path("id") id: Long)
            : ApiResponse<ProductResponse>
}