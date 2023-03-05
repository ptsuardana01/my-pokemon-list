package com.ps2001.mypokemonlist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.ps2001.mypokemonlist.databinding.ActivityDetailPokemonBinding
import com.ps2001.mypokemonlist.databinding.ActivityMainBinding
import kotlin.reflect.typeOf

class DetailPokemon : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPokemonBinding

    companion object{
        const val EXTRA_DETAIL_POKEMON = "extra_detail_pokemon"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pokemon)
        binding = ActivityDetailPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DETAIL_POKEMON, Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DETAIL_POKEMON)
        }

        if (pokemon != null){
            val pokeName = "Nama Pokemon: ${pokemon.name}, " +
                    "\ntype: ${pokemon.type},"
            val pokeImg = pokemon.img
            binding.detailPokeName.text = pokeName
            Glide.with(binding.detailPokeImg.context).load(pokeImg).into(binding.detailPokeImg)
            Log.d("Pokedata", "${pokemon.name} was clicked!")
        }
    }
}