package org.iesch.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.adapters.ActionMenuViewBindingAdapter
import org.iesch.calculadora.databinding.ActivityMainBinding

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

        binding.btnSumar.setOnClickListener {
            if (binding.etNum1.text.toString().isNotBlank() and binding.etNum2.text.toString().isNotBlank()) {
                val num1 = binding.etNum1.text.toString().toInt()
                val num2 = binding.etNum2.text.toString().toInt()
                val suma = num1 + num2
                binding.tvRespuesta.text = "El resultado es: $suma"
            } else {
                Toast.makeText(this, "debes introducir un valor numerico",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btnRestar.setOnClickListener {
            if (binding.etNum1.text.toString().isNotBlank() and binding.etNum2.text.toString().isNotBlank()) {
                val num1 = binding.etNum1.text.toString().toInt()
                val num2 = binding.etNum2.text.toString().toInt()
                val resta = num1 - num2
                binding.tvRespuesta.text = "El resultado es: $resta"
            } else {
                Toast.makeText(this, "debes introducir un valor numerico",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btnMultiplicar.setOnClickListener {
            if (binding.etNum1.text.toString().isNotBlank() and binding.etNum2.text.toString().isNotBlank()) {
                val num1 = binding.etNum1.text.toString().toInt()
                val num2 = binding.etNum2.text.toString().toInt()
                val multi = num1 + num2
                binding.tvRespuesta.text = "El resultado es: $multi"
            } else {
                Toast.makeText(this, "debes introducir un valor numerico",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.btnDividir.setOnClickListener {
            if (binding.etNum1.text.toString().isNotBlank() and binding.etNum2.text.toString().isNotBlank()) {
                val num1 = binding.etNum1.text.toString().toInt()
                val num2 = binding.etNum2.text.toString().toInt()
                val divi = num1 + num2
                binding.tvRespuesta.text = "El resultado es: $divi"
            } else {
                Toast.makeText(this, "debes introducir un valor numerico",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}