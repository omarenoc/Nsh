package com.example.superheroes.view.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.superheroes.databinding.FragmentSuperheroDetailBinding
import com.example.superheroes.viewmodel.SuperheroViewModel

class SuperheroDetailFragment : Fragment() {
    private val navigationArgs: SuperheroDetailFragmentArgs by navArgs()
    private val viewModel: SuperheroViewModel by activityViewModels()
    lateinit var binding: FragmentSuperheroDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuperheroDetailBinding.inflate(inflater)
        val id = navigationArgs.id
        viewModel.getHeroDetails(id)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.psCard.setOnClickListener { viewModel.setContentVisibility(binding.powerstatsContents) }
        binding.bioCard.setOnClickListener { viewModel.setContentVisibility(binding.biographyContents) }
        binding.aprCard.setOnClickListener { viewModel.setContentVisibility(binding.appearanceContents) }
        binding.wkCard.setOnClickListener { viewModel.setContentVisibility(binding.workContents) }
        binding.cnnCard.setOnClickListener { viewModel.setContentVisibility(binding.connectionsContents) }
    }

}