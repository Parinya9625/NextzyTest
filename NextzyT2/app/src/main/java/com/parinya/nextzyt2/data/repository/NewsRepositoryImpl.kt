package com.parinya.nextzyt2.data.repository

import com.parinya.nextzyt2.data.remote.NewsApi
import com.parinya.nextzyt2.domain.model.News
import com.parinya.nextzyt2.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val api: NewsApi
): NewsRepository {

    override suspend fun getNews(country: String, apiKey: String): News {
        return api.getNews(country, apiKey)
    }

}