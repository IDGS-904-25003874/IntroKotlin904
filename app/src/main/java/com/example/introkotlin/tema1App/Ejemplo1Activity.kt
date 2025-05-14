package com.example.introkotlin.tema1App

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var btn1: Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        btn1 = findViewById<Button>(R.id.btn1)
        radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        radioButton1 = findViewById<RadioButton>(R.id.radioButton)
        radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
        radioButton4 = findViewById<RadioButton>(R.id.radioButton4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun sumar(view: android.view.View) {
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() + valor2.toDouble()
        tv1.text = resultado.toString()

    }

    fun restar(view: android.view.View) {
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() - valor2.toDouble()
        tv1.text = resultado.toString()
    }

    fun multiplicar(view: android.view.View) {
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() * valor2.toDouble()
        tv1.text = resultado.toString()
    }

    fun dividir(view: android.view.View) {
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        if (valor2.toDouble() != 0.0) {
            val resultado = valor1.toDouble() / valor2.toDouble()
            tv1.text = resultado.toString()
        } else {
            tv1.text = "Error: División por cero"
        }
    }

    fun calcular(view: android.view.View){
        if (radioGroup.checkedRadioButtonId == -1) {
            tv1.text = "Error: Selecciona una operación"
            return
        }
        when(radioGroup.checkedRadioButtonId) {
            R.id.radioButton -> sumar(view)
            R.id.radioButton2 -> restar(view)
            R.id.radioButton3 -> multiplicar(view)
            R.id.radioButton4 -> dividir(view)
        }
    }

}