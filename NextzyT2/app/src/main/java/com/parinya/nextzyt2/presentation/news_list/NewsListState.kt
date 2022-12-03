package com.parinya.nextzyt2.presentation.news_list

import com.parinya.nextzyt2.domain.model.News

data class NewsListState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val news: News = News(emptyList(), "", 0),
    val errorMessage: String = ""
)