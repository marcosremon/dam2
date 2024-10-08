package com.example.practica02_cartelera

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practica02_cartelera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnJumanji.setOnClickListener {
            binding.imgCine.setImageResource(R.drawable.jumanji)
        }

        binding.btnGravedad.setOnClickListener {
            binding.imgCine.setImageResource(R.drawable.gravedad)
        }

        binding.btnElReyLeon.setOnClickListener {
            binding.imgCine.setImageResource(R.drawable.elreyleon)
        }

        binding.btnStarWar.setOnClickListener {
            binding.imgCine.setImageResource(R.drawable.starwars)
        }

        binding.btnElOrigen.setOnClickListener {
            binding.imgCine.setImageResource(R.drawable.elorigen)
        }

        binding.btnToyStory.setOnClickListener {
            binding.imgCine.setImageResource(R.drawable.toystory)
        }
    }
}