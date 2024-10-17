package org.iesch.practica04_marcadordebaloncesto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.iesch.practica04_marcadordebaloncesto.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val localPoints = intent.getIntExtra("localPoints", 0)
        val visitantPoints = intent.getIntExtra("visitantPoints", 0)

        binding.tvLocalPoints.text = localPoints.toString()
        binding.tvVisitantPoints.text = visitantPoints.toString()

        if (localPoints > visitantPoints) {
            binding.tvResult.text = "The local team won with $localPoints to $visitantPoints."
        } else if (visitantPoints > localPoints) {
            binding.tvResult.text = "The visiting team won with $visitantPoints to $localPoints."
        } else {
            binding.tvResult.text = "The match ended in a tie with $localPoints - $visitantPoints."
        }
    }
}
