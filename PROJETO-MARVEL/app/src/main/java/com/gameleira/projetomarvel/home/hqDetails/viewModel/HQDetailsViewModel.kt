package com.gameleira.projetomarvel.home.hqDetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gameleira.projetomarvel.home.hq.model.HQ
import com.gameleira.projetomarvel.home.hqDetails.repository.HQDetailsRepository
import kotlinx.coroutines.Dispatchers

class HQDetailsViewModel(
    private val repository: HQDetailsRepository
) : ViewModel() {
    var comicDetails: HQ? = null

    fun getComicDetails(id: Int) = liveData(Dispatchers.IO) {
        val response = repository.getHQDetails(id)
        comicDetails = response.data.res[0]
        emit(response.data.res[0])
    }

    @Suppress("UNCHECKED_CAST")
    class HQDetailsViewModelFactory(
        private val repository: HQDetailsRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HQDetailsViewModel(repository) as T
        }

    }
}