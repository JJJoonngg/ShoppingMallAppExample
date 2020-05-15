package com.jjjoonngg.parayo.api

import com.jjjoonngg.parayo.api.request.SignInRequest
import com.jjjoonngg.parayo.api.request.SignUpRequest
import com.jjjoonngg.parayo.api.response.ApiResponse
import com.jjjoonngg.parayo.api.response.SignInResponse
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

    @POST("/api/v1/signin")
    suspend fun signIn(@Body signInRequest: SignInRequest)
            : ApiResponse<SignInResponse>
}