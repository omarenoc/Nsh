package com.example.superheroes.view.fragment.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.databinding.ListItemBinding
import com.example.superheroes.model.data.Superhero

class ItemAdapter(private val onSuperheroClicked: (Superhero) -> Unit) :
    ListAdapter<Superhero, ItemAdapter.ItemViewHolder>(DiffCallback)
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val superheroItem = getItem(position)
        holder.bind(superheroItem)
        holder.itemView.setOnClickListener {
            onSuperheroClicked(superheroItem)
        }
    }

    class ItemViewHolder(private var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(superhero: Superhero) {
            binding.hero = superhero
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Superhero>() {
        override fun areItemsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
            return oldItem.name == newItem.name
        }
    }
}