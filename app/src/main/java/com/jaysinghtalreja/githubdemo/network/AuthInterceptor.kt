package com.jaysinghtalreja.githubdemo.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthInterceptor(private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val requestWithAuth: Request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $authToken")
            .build()
        return chain.proceed(requestWithAuth)
    }
}