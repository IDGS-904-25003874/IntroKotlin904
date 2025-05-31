package com.example.introkotlin

import Cinepolis.CinepolisActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.Tem2App.Ejemplo2Activity
import com.example.introkotlin.Tema3.Ejemplo3Activity
import com.example.introkotlin.Tema4.Ejemplo4Activity
import com.example.introkotlin.tema1App.Ejemplo1Activity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnEjemplo1 = findViewById<Button>(R.id.button1)
        btnEjemplo1.setOnClickListener{navigateToEjemplo1()}

        val btnCinepolis = findViewById<Button>(R.id.button2)
        btnCinepolis.setOnClickListener{navigateToCinepolis()}

        val btnEjemplo2 = findViewById<Button>(R.id.button3)
        btnEjemplo2.setOnClickListener{navigateToEjemplo2()}

        val btnNumero = findViewById<Button>(R.id.button4)
        btnNumero.setOnClickListener{navigateToEjemplo3()}

        val btnArchivo = findViewById<Button>(R.id.button5)
        btnArchivo.setOnClickListener{navigateToEjemplo4()}



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToEjemplo1() {
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToEjemplo2() {
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToEjemplo3() {
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }

    private fun navigateToEjemplo4() {
        val intent = Intent(this, Ejemplo4Activity::class.java)
        startActivity(intent)
    }

}