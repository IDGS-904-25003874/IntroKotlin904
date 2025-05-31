package com.example.introkotlin.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class BuscarActivity : AppCompatActivity() {
    private val fileName = "diccionario.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        val radioIngles = findViewById<RadioButton>(R.id.rbIngles)
        val radioEspañol = findViewById<RadioButton>(R.id.rbEspañol)
        val inputBuscar = findViewById<EditText>(R.id.etBuscar)
        val tvResultadoBuscar = findViewById<TextView>(R.id.tvResultadoBuscar)
        val tvNoEncontrado = findViewById<TextView>(R.id.tvNoEncontrado)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnBuscar.setOnClickListener {
            val palabra = inputBuscar.text.toString().trim()
            if (palabra.isEmpty()) {
                tvNoEncontrado.visibility = TextView.VISIBLE
            }

            try {
                val contenido = openFileInput(fileName).bufferedReader().useLines { lines ->
                    lines.toList()
                }

                var encontrado = false
                for (linea in contenido) {
                    val (español, ingles) = linea.split(":")
                    if (radioEspañol.isChecked && español == palabra) {
                        tvResultadoBuscar.text = ingles
                        encontrado = true
                        break
                    } else if (radioIngles.isChecked && ingles == palabra) {
                        tvResultadoBuscar.text = español
                        encontrado = true
                        break
                    }
                }

                if (!encontrado) {
                    tvNoEncontrado.visibility = TextView.VISIBLE
                }
            } catch (e: Exception) {
                e.printStackTrace()
                tvNoEncontrado.visibility = TextView.VISIBLE
            }
        }

        btnVolver.setOnClickListener { navigateToMenu() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navigateToMenu() {
        val intent = Intent(this, MenuDiccionarioActivity::class.java)
        startActivity(intent)
    }
}