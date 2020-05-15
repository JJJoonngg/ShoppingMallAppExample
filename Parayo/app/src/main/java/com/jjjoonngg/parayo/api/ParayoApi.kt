package com.jjjoonngg.parayo.api

import com.jjjoonngg.parayo.api.request.SignUpRequest
import com.jjjoonngg.parayo.api.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

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
}