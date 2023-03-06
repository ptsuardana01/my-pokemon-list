package com.ps2001.mypokemonlist

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.ps2001.mypokemonlist.databinding.ActivityDetailPokemonBinding

class DetailPokemon : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailPokemonBinding

    companion object{
        const val EXTRA_DETAIL_POKEMON = "extra_detail_pokemon"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pokemon)
        binding = ActivityDetailPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.includeBtnBack.btnBackToList.setOnClickListener(this)

        val pokemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DETAIL_POKEMON, Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DETAIL_POKEMON)
        }

        if (pokemon != null){
            Glide.with(binding.detailPokeImg.context).load(pokemon.img).into(binding.detailPokeImg)
            binding.detailPokeName.text = pokemon.name
            binding.detailPokeType.text = pokemon.type
            binding.detailPokeWeakness.text = pokemon.weakness
            binding.detailPokeAbility.text = pokemon.ability
            binding.includeDetailPokemonDesc.detailPokeDesc.text = pokemon.desc
            binding.includeDetailPokemonDesc.detailPokeAbilityDesc.text = pokemon.ability_desc

            Log.d("Pokedata", "${pokemon.ability_desc} was clicked!")
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_to_list -> {
                val intentBackToList = Intent(this@DetailPokemon, ListPokemons::class.java)
                startActivity(intentBackToList)
            }
        }
    }
}