package com.example.introkotlin.tema1App

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class Ejemplo2Activity : AppCompatActivity() {

    private lateinit var et1 : EditText
    private lateinit var et2 : EditText
    private lateinit var button : Button
    private lateinit var tv1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)

        et1 = findViewById<EditText>(R.id.editText1)
        et2 = findViewById<EditText>(R.id.editText2)
        button = findViewById<Button>(R.id.button)
        tv1 = findViewById<TextView>(R.id.textView1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun multiplicarConSuma(view: android.view.View){
        var resultado = 0
        for(i in 1..et2.text.toString().toInt()){
            resultado += et1.text.toString().toInt()
        }
        tv1.text = resultado.toString()

    }
}