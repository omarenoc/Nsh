package com.example.superheroes.view

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroes.R
import com.example.superheroes.model.data.Superhero
import com.example.superheroes.view.fragment.list.adapter.ItemAdapter

@BindingAdapter("imageUrl")
fun bindImage(
    imgView: ImageView,
    imgUrl: String?
) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading)
            error(R.drawable.error)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<Superhero>?
) {
    val adapter = recyclerView.adapter as ItemAdapter
    adapter.submitList(data)
}