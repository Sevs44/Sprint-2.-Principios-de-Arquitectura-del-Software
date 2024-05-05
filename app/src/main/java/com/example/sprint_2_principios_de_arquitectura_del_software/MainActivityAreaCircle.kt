package com.example.sprint_2_principios_de_arquitectura_del_software

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import objects.Circle

class MainActivityAreaCircle : AppCompatActivity() {

    private lateinit var dataInput: EditText
    private lateinit var textDescription: TextView
    private lateinit var textResult: TextView
    private lateinit var circle: Circle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_area_circle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstrainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincula las vistas XML con variables de la actividad
        dataInput = findViewById(R.id.dataInput)
        textDescription = findViewById(R.id.textDescription)
        textResult = findViewById(R.id.textResult)

        // Configura la descripción de la fórmula
        val circleDescription = "El área del círculo se calcula utilizando la fórmula: π × radio^2"
        textDescription.text = circleDescription

        // Instancia el objeto Circle
        circle = Circle.Builder()
            .description(circleDescription)
            .build() as Circle

        // Configura el clic del botón
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            calculateArea()
        }
    }

    private fun calculateArea() {
        val radiusInput = dataInput.text.toString().toDoubleOrNull()
        if (radiusInput != null) {
            circle.setRadius(radiusInput)
            val area = circle.calculateArea()
            textResult.text = "El área del círculo es: $area"
        } else {
            textResult.text = ""
        }
    }
}