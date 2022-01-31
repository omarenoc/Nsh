package com.example.superheroes.viewmodel

import android.util.Log
import android.view.View
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

    private var _hero = MutableLiveData<Superhero>()
    var hero :LiveData<Superhero> = _hero

    init {
        getAll()
    }

    private fun getAll() {
        viewModelScope.launch {
            try {
                _response.value = SuperheroApi.retrofitService.getAll()
            } catch (e: Exception) {
                Log.e("RestService","Failure: ${e.message}")
            }
        }
    }

    private fun getSuperhero(id: Int) {
        viewModelScope.launch {
            try {
                _hero.value = SuperheroApi.retrofitService.getHero(id)
            } catch (e: Exception) {
                Log.e("RestService","Failure: ${e.message}")
            }
        }
    }

    fun getHeroDetails(id: Int) {
        getSuperhero(id)
    }

    fun setContentVisibility(view: View) {
        if (view.visibility == View.GONE) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}