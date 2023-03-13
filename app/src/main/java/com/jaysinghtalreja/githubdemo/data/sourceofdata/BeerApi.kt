package com.jaysinghtalreja.githubdemo.data.sourceofdata

import com.jaysinghtalreja.githubdemo.data.sourceofdata.model.Beer
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface BeerApi {
    /**
     * Get Github Trending
     */
    @GET("v2/beers")
    @Throws(Exception::class)
    suspend fun getGithubTrending(): Response<List<Beer>>

    companion object {
        /**
         * Factory function for [GithubApi]
         */
        fun create(retroFit: Retrofit): BeerApi = retroFit.create(
            BeerApi::class.java
        )
    }
}