package com.example.introkotlin.Tema4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import java.io.FileNotFoundException

class Ejemplo4Activity : AppCompatActivity() {
    private val fileName="datos.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo5)
        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)

        btnBorrar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Quieres borrar el texto?")
            builder.setPositiveButton("Si") { _, _ ->
                try{
                    openFileOutput("datos.txt", MODE_PRIVATE).use {
                        it.write("".toByteArray())
                    }
                    outputText.text = ""
                    Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show()

                }catch (e: Exception){
                    e.printStackTrace()
                    Toast.makeText(this,"Error al borrar los datos", Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        btnGuardar.setOnClickListener{
            val text = inputText.text.toString()+"\n"
            try {
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(text.toByteArray())
                }
                inputText.text.clear()
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput(fileName).bufferedReader().useLines { lines ->
                    lines.joinToString("\n")
                }
                outputText.text = contenido
            }catch (e: FileNotFoundException){
                outputText.text = "Archivo no encontrado"
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}