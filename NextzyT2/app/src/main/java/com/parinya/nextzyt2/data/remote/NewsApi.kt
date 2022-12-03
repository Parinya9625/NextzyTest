package com.parinya.nextzyt2.data.remote

import com.parinya.nextzyt2.domain.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getNews(@Query("country") country: String, @Query("apiKey") apiKey: String): News
}