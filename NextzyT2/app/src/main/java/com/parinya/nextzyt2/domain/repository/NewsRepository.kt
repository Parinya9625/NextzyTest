package com.parinya.nextzyt2.domain.repository

import com.parinya.nextzyt2.domain.model.News

interface NewsRepository {

    suspend fun getNews(country: String, apiKey: String): News

}