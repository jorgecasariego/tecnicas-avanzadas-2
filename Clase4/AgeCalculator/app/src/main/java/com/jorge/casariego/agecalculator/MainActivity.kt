package com.jorge.casariego.agecalculator

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    // La actividad esta siendo creada
    // Se utiliza para realizar todo tipo de inicializaciones, como la creación de la interfaz de
    //  usuario o la inicialización de estructuras de datos. Puede recibir información de estado
    //  dela actividad (en una instancia de la clase Bundle), por si se reanuda desde una actividad
    //  que ha sido destruida y vuelta a crear.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mostrarMensaje("onCreate")
        Log.d("TEST", "onCreate")

        calcular_button.setOnClickListener {
            val anho = anho_nacimiento_et.text.toString()

            if (anho.isEmpty()) {
                Toast.makeText(this, "No podemos calcular tu edad sin el año de nacimiento", Toast.LENGTH_LONG).show()

            } else {
                calcularEdad(anho.toInt())
            }


        }
    }

    private fun calcularEdad(anhoNacimiento: Int) {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val edad = currentYear - anhoNacimiento

        mi_edad_tv.text = "$edad años"

        // Escondemos el teclado
        val inputManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
    }

    // La actividad esta a punto de volverse visible
    override fun onStart() {
        super.onStart()
        mostrarMensaje("onStart")
        Log.d("TEST", "onStart")
    }

    // la actividad esta visible
    // Es un buen lugar para lanzar las animaciones y la música.
    override fun onResume() {
        super.onResume()
        mostrarMensaje("onResume")
        Log.d("TEST", "onResume")
    }

    // Otra actividad esta teniendo focus (esta actividad esta a punto de pausarse)
    // Es el lugar adecuado para detener animaciones, música o almacenar los datos que estaban en edición.
    override fun onPause() {
        super.onPause()
        mostrarMensaje("onPause")
        Log.d("TEST", "onPause")
    }

    // La actividad ya no va a ser visible para el usuario.
    // !Ojo si hay muy poca memoria! es posible que la actividad se destruya sin llamar a este método.
    override fun onStop() {
        super.onStop()
        mostrarMensaje("onStop")
        Log.d("TEST", "onStop")
    }

    // La actividad está a punto de ser destruida.
    override fun onDestroy() {
        super.onDestroy()
        mostrarMensaje("onDestroy")
        Log.d("TEST", "onDestroy")
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}
