package com.example.sprint_2_principios_de_arquitectura_del_software

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import objects.Diamond

class MainActivityAreaDiamond : AppCompatActivity() {

    private lateinit var dataInput: EditText
    private lateinit var dataInput2: EditText
    private lateinit var textDescription: TextView
    private lateinit var textResult: TextView
    private lateinit var diamond: Diamond

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_area_diamond)
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
        val diamondDescription =
            "El área del rombo se calcula utilizando la fórmula: (diagonal1 * diagonal2) / 2"
        textDescription.text = diamondDescription

        // Instancia el objeto Diamond
        diamond = Diamond.Builder()
            .description(diamondDescription)
            .build() as Diamond

        // Configura el clic del botón
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            calculateArea()
        }
    }

    private fun calculateArea() {
        val diagonal1Input = dataInput.text.toString().toDoubleOrNull()
        val diagonal2Input = dataInput2.text.toString().toDoubleOrNull()
        if (diagonal1Input != null && diagonal2Input != null) {
            diamond.setDiagonal1(diagonal1Input)
            diamond.setDiagonal2(diagonal2Input)
            val area = diamond.calculateArea()
            textResult.text = "El área del rombo es: $area"
        } else {
            textResult.text = ""
        }
    }
}