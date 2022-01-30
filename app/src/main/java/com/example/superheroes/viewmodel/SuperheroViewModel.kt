package com.example.superheroes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.model.LightSuperhero
import com.example.superheroes.model.Superhero
import com.example.superheroes.model.remote.SuperheroApi
import com.example.superheroes.model.remote.SuperheroApiService
import kotlinx.coroutines.launch

class SuperheroViewModel: ViewModel() {

    private val _status = MutableLiveData<List<Superhero>>()
    val status: LiveData<List<Superhero>> = _status

    //private val _items = MutableLiveData<List<LightSuperhero>>()
    //val items: LiveData<List<LightSuperhero>> = _items

    init {
        getAll()
    }

    private fun getAll() {
        viewModelScope.launch {
            try {
                _status.value = SuperheroApi.retrofitService.getAll()
                //_items.value = getLightList(status.value)
            } catch (e: Exception) {
                Log.e("RestService","Failure: ${e.message}")
            }
        }
    }

    /*private fun getLightList(heroesList: List<Superhero>?): List<LightSuperhero> {
        val mlist = mutableListOf<LightSuperhero>()
        if (heroesList != null) {
            for (hero in heroesList) {
                val lightSh = LightSuperhero(
                    hero.id.toInt(),
                    hero.name,
                    hero.images.sm
                )
                mlist.add(lightSh)
            }
        }
        val list: List<LightSuperhero> = mlist
        return list
    }*/

}