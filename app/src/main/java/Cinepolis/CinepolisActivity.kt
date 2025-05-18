package Cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R


class CinepolisActivity : AppCompatActivity() {

    //Constantes
    private val PRECIO_BOLETO  = 120
    private val MAX_BOLETOS = 7
    private val DESCUENTO_3_5 = 0.10
    private val DESCUENTO_MAS_5 = 0.15
    private val DESCUENTO_TARJETA = 0.10

    private lateinit var editTextNombre: EditText
    private lateinit var editTextCantidad: EditText
    private lateinit var editTextBoletos: EditText
    private lateinit var radioGroupTarjeta: RadioGroup
    private lateinit var radioSi: RadioButton
    private lateinit var radioNo: RadioButton
    private lateinit var textViewPrecio: TextView
    private lateinit var buttonCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        editTextNombre = findViewById(R.id.editText_nombre)
        editTextCantidad = findViewById(R.id.editText_cantidad)
        editTextBoletos = findViewById(R.id.editText_boletos)
        radioGroupTarjeta = findViewById(R.id.radioGroup_tarjeta)
        radioSi = findViewById(R.id.radio_si)
        radioNo = findViewById(R.id.radio_no)
        textViewPrecio = findViewById(R.id.textView_precio)
        buttonCalcular = findViewById(R.id.button_calcular)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun showToast(mensaje: String) {
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }

        fun validarCampos(): Boolean{
            if (editTextNombre.getText().toString().trim().isEmpty()) {
                showToast("Error: Por favor ingrese el nombre");
                editTextNombre.requestFocus();
                return false;
            }
            if (editTextCantidad.getText().toString().trim().isEmpty()) {
                showToast("Error: Por favor ingrese la cantidad de compradores");
                editTextCantidad.requestFocus();
                return false;
            }
            if (editTextBoletos.getText().toString().trim().isEmpty()) {
                showToast("Error: Por favor ingrese la cantidad de boletos");
                editTextBoletos.requestFocus();
                return false;
            }
            if (radioGroupTarjeta.checkedRadioButtonId == -1) {
                showToast("Error: Por favor seleccione si tiene tarjeta cineco");
                return false;
            }
            return true;
        }

        fun calcularPrecioConDescuentos(cantidadBoletos: Int, tieneTarjetaCineco: Boolean): Int {
            var precioTotal = cantidadBoletos * PRECIO_BOLETO
            val descuentoCantidad = when {
                cantidadBoletos in 3..5 -> DESCUENTO_3_5
                cantidadBoletos > 5 -> DESCUENTO_MAS_5
                else -> 0.0
            }
            precioTotal = (precioTotal *  (1 - descuentoCantidad)).toInt()
            if (tieneTarjetaCineco) {
                precioTotal = (precioTotal *  (1 - DESCUENTO_TARJETA)).toInt()
            }
            return precioTotal
        }

        fun calcularPrecio(){
            if (!validarCampos()) {
                return
            }
            val nombre = editTextNombre.text.toString().trim()
            val cantidadCompradores = editTextCantidad.text.toString().toInt()
            val cantidadBoletos = editTextBoletos.text.toString().toInt()
            val tieneTarjetaCineco = radioSi.isChecked
            if (cantidadBoletos > (cantidadCompradores * MAX_BOLETOS)) {
                showToast("Error: Cada persona puede comprar máximo $MAX_BOLETOS boletos")
                return
            }
            if (cantidadCompradores <= 0 || cantidadBoletos <= 0) {
                showToast("Error: Las cantidades deben ser mayores a 0")
                return
            }
            val precioTotal = calcularPrecioConDescuentos(cantidadBoletos, tieneTarjetaCineco)
            textViewPrecio.text = "$" + precioTotal.toString()
        }

        buttonCalcular.setOnClickListener {
            calcularPrecio()
        }
    }
}