package org.iesch.practica04_marcadordebaloncesto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.iesch.practica04_marcadordebaloncesto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var localPoints = 0
    private var visitantPoints = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPointsPlusOneLocale.setOnClickListener {
            localPoints += 1
            binding.tvLocalPoints.text = localPoints.toString()
        }

        binding.btnPointsPlusTwoLocale.setOnClickListener {
            localPoints += 2
            binding.tvLocalPoints.text = localPoints.toString()
        }

        binding.btnPointsMinousOneLocale.setOnClickListener {
            if (localPoints > 0) {
                localPoints -= 1
                binding.tvLocalPoints.text = localPoints.toString()
            }
        }

        binding.btnPointsPlusOneVisitant.setOnClickListener {
            visitantPoints += 1
            binding.tvVisitantPoints.text = visitantPoints.toString()
        }

        binding.btnPointsPlusTwoVisitant.setOnClickListener {
            visitantPoints += 2
            binding.tvVisitantPoints.text = visitantPoints.toString()
        }

        binding.btnPointsMinousOneVisitant.setOnClickListener {
            if (visitantPoints > 0) {
                visitantPoints -= 1
                binding.tvVisitantPoints.text = visitantPoints.toString()
            }
        }

        binding.btnReset.setOnClickListener {
            visitantPoints = 0
            localPoints = 0
            binding.tvLocalPoints.text = visitantPoints.toString()
            binding.tvVisitantPoints.text = visitantPoints.toString()
        }

        binding.btnNextWindow.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("localPoints", localPoints)
            intent.putExtra("visitantPoints", visitantPoints)
            startActivity(intent)
        }
    }
}
