package com.parinya.nextzyt2.domain.use_case

import com.parinya.nextzyt2.domain.model.News
import com.parinya.nextzyt2.domain.repository.NewsRepository
import com.parinya.nextzyt2.util.Status
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetNewsUseCase(
    private val repository: NewsRepository
) {

    operator fun invoke(country: String, apiKey: String): Flow<Status<News>> = flow {
        try {
            emit(Status.Loading())
            val news = repository.getNews(country, apiKey)
            emit(Status.Success(news))
        } catch(e: HttpException) {
            emit(Status.Error(e.localizedMessage ?: "Unexpected error"))
        } catch(e: IOException) {
            emit(Status.Error(e.localizedMessage ?: "No internet connection"))
        }
    }

}