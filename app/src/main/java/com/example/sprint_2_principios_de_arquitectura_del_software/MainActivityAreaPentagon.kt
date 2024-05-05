package com.example.sprint_2_principios_de_arquitectura_del_software

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import objects.Pentagon

class MainActivityAreaPentagon : AppCompatActivity() {

    private lateinit var dataInput: EditText
    private lateinit var dataInput2: EditText
    private lateinit var textDescription: TextView
    private lateinit var textResult: TextView
    private lateinit var pentagon: Pentagon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_area_pentagon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstrainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincula las vistas XML con variables de la actividad
        dataInput = findViewById(R.id.dataInput)
        dataInput2 = findViewById(R.id.dataInput2)
        textDescription = findViewById(R.id.textDescription)
        textResult = findViewById(R.id.textResult)

        // Configura la descripción de la fórmula
        val pentagonDescription =
            "El área del pentágono se calcula utilizando la fórmula: (lado^2 × (5 + 2 × √5)) / 4"
        textDescription.text = pentagonDescription

        // Instancia el objeto Pentagon
        pentagon = Pentagon.Builder()
            .description(pentagonDescription)
            .build() as Pentagon

        // Configura el clic del botón
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            calculateArea()
        }
    }

    private fun calculateArea() {
        val sideInput = dataInput.text.toString().toDoubleOrNull()
        val heightInput = dataInput2.text.toString().toDoubleOrNull()
        if (sideInput != null && heightInput != null) {
            pentagon.setSide(sideInput)
            pentagon.setHeight(heightInput)
            val area = pentagon.calculateArea()
            textResult.text = "El área del pentágono es: $area"
        } else {
            textResult.text = ""
        }
    }
}
