package com.example.superheroes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.model.remote.SuperheroApi
import com.example.superheroes.model.remote.SuperheroApiService
import kotlinx.coroutines.launch

class SuperheroViewModel: ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getAll()
    }

    private fun getAll() {
        viewModelScope.launch {
            try {
                val listResult = SuperheroApi.retrofitService.getAll()
                _status.value = listResult
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

}