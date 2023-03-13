package com.jaysinghtalreja.githubdemo.network

import okio.IOException

class NoInternetException : IOException() {
    override val message: String
        get() =
            "No internet available, please check your are connected with WIFi or Data"
}