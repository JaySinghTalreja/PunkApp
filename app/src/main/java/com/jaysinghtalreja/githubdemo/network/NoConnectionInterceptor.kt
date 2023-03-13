package com.jaysinghtalreja.githubdemo.network

import com.jaysinghtalreja.githubdemo.GithubDemo
import com.jaysinghtalreja.githubdemo.utils.extentions.isNetNotConnected
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NoConnectionInterceptor @Inject constructor(
    private val context: GithubDemo
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return if (context.isNetNotConnected()) {
            throw NoInternetException()
        }else {
            chain.proceed(chain.request())
        }
    }
}