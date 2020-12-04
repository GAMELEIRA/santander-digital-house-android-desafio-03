package com.gameleira.projetomarvel.home.hq.viewModel

import androidx.lifecycle.liveData
import com.gameleira.projetomarvel.home.hq.model.HQ
import com.gameleira.projetomarvel.home.hq.repository.HQRepository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers

class HQViewModel(
    private val repository: HQRepository
) : ViewModel() {

    var hq: List<HQ> = listOf()

    fun getHQs() = liveData(Dispatchers.IO) {
        val response = repository.getHQs();
        hq = response.data.results;
        emit(response.data.results);
    }

    @Suppress("UNCHECKED_CAST")
    class HQViewModelFactory(
        private val repository: HQRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HQViewModel(repository) as T
        }

    }
}