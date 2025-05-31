package com.example.introkotlin.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import com.example.introkotlin.tema1App.Ejemplo1Activity

class MenuDiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_diccionario)

        val btnCap = findViewById<Button>(R.id.btnCap)
        btnCap.setOnClickListener{navigateToCapturar()}

        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        btnBuscar.setOnClickListener{navigateToBuscar()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navigateToCapturar(){
        val intent = Intent(this, CapturarActivity::class.java)
        startActivity(intent)
    }

    fun navigateToBuscar(){
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }
}