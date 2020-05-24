package com.jjjoonngg.parayo.api

import com.jjjoonngg.parayo.common.Prefs
import okhttp3.Interceptor
import okhttp3.Response
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class ApiTokenInterceptor : Interceptor, AnkoLogger {
    override fun intercept(chain: Interceptor.Chain): Response {
        debug("API 요청")
        val original = chain.request()
        val request = original.newBuilder().apply {
            Prefs.token?.let { header("Autorization", it) }
            method(original.method(), original.body())
        }.build()
        return chain.proceed(request)
    }
}