package com.example.introkotlin.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class CapturarActivity : AppCompatActivity() {
    private val fileName="diccionario.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)

        val inputEspañol = findViewById<EditText>(R.id.editTextEspañol)
        val inputIngles = findViewById<EditText>(R.id.editTextInglés)
        val tvSuccess = findViewById<TextView>(R.id.tvSuccess)
        val btnCapturar = findViewById<Button>(R.id.btnCapturar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener { navigateToMenu() }

        btnCapturar.setOnClickListener {
            val textEspañol = inputEspañol.text.toString()
            val textIngles = inputIngles.text.toString()
            try {
                val entry = "$textEspañol:$textIngles\n"
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(entry.toByteArray())
                }
                inputEspañol.text.clear()
                inputIngles.text.clear()
                tvSuccess.visibility = TextView.VISIBLE
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navigateToMenu(){
        val intent = Intent(this, MenuDiccionarioActivity::class.java)
        startActivity(intent)
    }
}