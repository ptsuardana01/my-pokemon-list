package com.ps2001.mypokemonlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListPokemons : AppCompatActivity() {

    private lateinit var rvPokemons: RecyclerView
    private val list = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokemons)

        rvPokemons = findViewById(R.id.rv_pokemons)
        rvPokemons.setHasFixedSize(true)

        list.addAll(getListPokemon())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPokemons.layoutManager = LinearLayoutManager(this)
        val listPokemonAdapter = ListPokemonAdapter(list)
        rvPokemons.adapter = listPokemonAdapter

        listPokemonAdapter.setOnItemClickCallback(object : ListPokemonAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pokemon) {
                val detailIntent = Intent(this@ListPokemons, DetailPokemon::class.java)
                detailIntent.putExtra(DetailPokemon.EXTRA_DETAIL_POKEMON, data)
                startActivity(detailIntent)
            }
        })
    }

    private fun getListPokemon(): ArrayList<Pokemon> {
        val names = resources.getStringArray(R.array.poke_names)
        val types = resources.getStringArray(R.array.poke_type)
        val imgs = resources.getStringArray(R.array.poke_img)
        val desc = resources.getStringArray(R.array.poke_desc)
        val weakness = resources.getStringArray(R.array.poke_weakness)
        val ability = resources.getStringArray(R.array.poke_ability)
        val abilityDesc = resources.getStringArray(R.array.poke_desc_ability)
        val listPokemons = ArrayList<Pokemon>()

        for (i in names.indices) {
            val pokemon = Pokemon(names[i], types[i], imgs[i], desc[i], weakness[i], ability[i], abilityDesc[i])
            listPokemons.add(pokemon)
        }
        return listPokemons
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                val profileIntent = Intent(this@ListPokemons, MainActivity::class.java)
                startActivity(profileIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}