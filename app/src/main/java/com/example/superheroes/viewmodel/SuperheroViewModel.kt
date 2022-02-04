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

    val lista: MutableList<Superhero> = mutableListOf()

    init {
        getAll()
    }

   /* private fun getAll() {
        viewModelScope.launch {
            try {
                _response.value = SuperheroApi.retrofitService.getAll().results
            } catch (e: Exception) {
                Log.e("RestService","Failure: ${e.message}")
            }
        }
    }
*/
    private fun getAll() {
        viewModelScope.launch {
            var respuesta: Superhero = Superhero()
            var init = 1
            val pass = 20
            val finalHero = 731
            val iterations: Int = finalHero/pass
            var end = pass


            for (flag in 1..iterations) {
                for (id in init..end) {
                    respuesta = SuperheroApi.retrofitService.getHero(id)
                    if (respuesta.response == "success") {
                        lista.add(respuesta)
                    }
                }
                init += pass
                end += pass
                updateData()
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
        _hero.value = Superhero()
        getSuperhero(id)
    }

    fun setContentVisibility(view: View) {
        if (view.visibility == View.GONE) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    fun updateData() {
        _response.value = lista
    }
}