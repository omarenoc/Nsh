package com.example.superheroes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.model.data.Superhero
import com.example.superheroes.model.remote.SuperheroApi
import kotlinx.coroutines.launch

class SuperheroViewModel: ViewModel() {

    private val _response = MutableLiveData<List<Superhero>>()
    val response: LiveData<List<Superhero>> = _response

    private val _hero = MutableLiveData<Superhero>()
    val hero: LiveData<Superhero> = _hero

    init {
        getAll()
    }

    private fun getAll() {
        viewModelScope.launch {
            try {
                _response.value = SuperheroApi.retrofitService.getAll()
                //_items.value = getLightList(status.value)
            } catch (e: Exception) {
                Log.e("RestService","Failure: ${e.message}")
            }
        }
    }

    private fun getSuperhero(id: Int): Superhero {
        return response.value?.get(id)!!
    }

    fun getHeroDetails(id: Int) {
        _hero.value = getSuperhero(id)
    }

}