package com.parinya.nextzyt2.data.di

import com.parinya.nextzyt2.data.remote.NewsApi
import com.parinya.nextzyt2.data.repository.NewsRepositoryImpl
import com.parinya.nextzyt2.domain.repository.NewsRepository
import com.parinya.nextzyt2.domain.use_case.GetNewsUseCase
import com.parinya.nextzyt2.presentation.news_list.NewsListViewModel
import com.parinya.nextzyt2.util.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
    single<NewsRepository> {
        NewsRepositoryImpl(get())
    }
    single {
        GetNewsUseCase(get())
    }

    viewModel {
        NewsListViewModel(get())
    }
}