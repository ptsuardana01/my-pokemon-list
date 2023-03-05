package com.ps2001.mypokemonlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ps2001.mypokemonlist.databinding.ItemPokemonsBinding

class ListPokemonAdapter(private val listPokemons: ArrayList<Pokemon>) : RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemPokemonsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, type, img) = listPokemons[position]
        Glide.with(holder.binding.pokemonImg.context)
            .load(img)
            .into(holder.binding.pokemonImg)
        holder.binding.pokemonType.text = type
        holder.binding.pokemonName.text = name

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPokemons[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listPokemons.size

    class ListViewHolder(var binding: ItemPokemonsBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pokemon)
    }
}