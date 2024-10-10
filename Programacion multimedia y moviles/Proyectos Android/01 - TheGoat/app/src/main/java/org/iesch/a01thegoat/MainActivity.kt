package org.iesch.a01thegoat

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1 - tomamos el control sobre las vistas que vamos a necesitar en la Activity
        val resultText = findViewById<TextView>(R.id.tvRespuesta)
        val calculateButton = findViewById<Button>(R.id.btnCalcular)
        val ageEdit = findViewById<EditText>(R.id.etEdad)

        //Logs en android
        //Log.i("DAM2", "esto es una log de tipo INFO");
        //Log.v("DAM2", "esto es una log de tipo VERBOSE");
        //Log.d("DAM2", "esto es una log de tipo DEBUG");
        //Log.w("DAM2", "esto es una log de tipo WARNING");
        //Log.e("DAM2", "esto es una log de tipo ERROR");

        //2 - Los botones tienen la propiedad onClickListener al pulsarlos
        calculateButton.setOnClickListener {
            //Log.i("EdadCaninia", "has pulsado click en el boton calcular😎");
            val ageString = ageEdit.text.toString();
            if (ageString.isNotBlank()) {
                val ageInt = ageString.toInt();
                val dogAge = ageInt * 7;
                resultText.text = "si fueras perro tu edad seria de $dogAge años."
            } else {
                Toast.makeText(this, "debes introducir un valor numerico", Toast.LENGTH_LONG).show()
            }
        }
    }
}