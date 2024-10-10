package com.example.practica03_loginenandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val email = intent.getStringExtra("USER_EMAIL")

        val welcomeMessage = findViewById<TextView>(R.id.secondScreen)
        welcomeMessage.text = "Bienvenido: $email"
    }
}