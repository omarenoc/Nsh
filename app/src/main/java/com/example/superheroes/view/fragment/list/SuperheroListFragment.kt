package com.example.superheroes.view.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperheroListBinding
import com.example.superheroes.view.fragment.list.adapter.ItemAdapter
import com.example.superheroes.viewmodel.SuperheroViewModel

class SuperheroListFragment : Fragment() {
    private val viewModel: SuperheroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuperheroListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.itemsGrid.adapter = ItemAdapter()

        return binding.root
    }
}