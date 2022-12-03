package com.parinya.nextzyt2.domain.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)