package com.example.superheroes.view.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperheroDetailBinding
import com.example.superheroes.viewmodel.SuperheroViewModel

class SuperheroDetailFragment : Fragment() {
    private val navigationArgs: SuperheroDetailFragmentArgs by navArgs()
    private val viewModel: SuperheroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuperheroDetailBinding.inflate(inflater)
        val id = navigationArgs.id
        viewModel.getHeroDetails(id)
        binding.lifecycleOwner = this

        binding.viewmodel = viewModel

        return binding.root
    }

}