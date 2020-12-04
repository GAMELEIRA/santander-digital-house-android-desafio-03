package com.gameleira.projetomarvel.home.hq.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class ComicViewModel(
    private val repository: ComicRepository
) : ViewModel() {

    var comics: List<ComicModel> = listOf()

    fun getComics() = liveData(Dispatchers.IO) {
        val response = repository.getComics()
        comics = response.data.results
        emit(response.data.results)
    }

    @Suppress("UNCHECKED_CAST")
    class ComicViewModelFactory(
        private val repository: ComicRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }

    }
}