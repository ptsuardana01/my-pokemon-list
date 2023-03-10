package com.ps2001.mypokemonlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ps2001.mypokemonlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //mengaktifkan view binding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Welcome to PsPokédex!", Toast.LENGTH_SHORT).show()

        binding.btnMove.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move -> {
                val moveIntent = Intent(this@MainActivity, ListPokemons::class.java)
                startActivity(moveIntent)
            }
        }
    }
}


