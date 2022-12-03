package com.parinya.nextzyt2.presentation.news_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parinya.nextzyt2.domain.use_case.GetNewsUseCase
import com.parinya.nextzyt2.util.Constants
import com.parinya.nextzyt2.util.Status
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewsListViewModel(
    private val getNewsUseCase: GetNewsUseCase
): ViewModel() {

    private val _state = MutableLiveData<NewsListState>()
    val state = _state as LiveData<NewsListState>

    init {
        getNews()
    }

    private fun getNews() {
        getNewsUseCase("th", Constants.API_KEY).onEach { result ->
            when(result) {
                is Status.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
                is Status.Success -> {
                    _state.value = NewsListState(isLoading = false, news = result.data!!)
                }
                is Status.Error -> {
                    _state.value = NewsListState(isLoading = false, isError = true, errorMessage = result.message ?: "Unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

}