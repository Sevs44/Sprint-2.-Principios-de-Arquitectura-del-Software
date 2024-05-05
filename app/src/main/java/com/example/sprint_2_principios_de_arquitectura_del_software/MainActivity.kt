package com.example.sprint_2_principios_de_arquitectura_del_software

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonCircle = findViewById<Button>(R.id.buttonCircle)
        val buttonDiamond = findViewById<Button>(R.id.buttonDiamond)
        val buttonPentagon = findViewById<Button>(R.id.buttonPentagon)

        buttonCircle.setOnClickListener(this)
        buttonDiamond.setOnClickListener(this)
        buttonPentagon.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonCircle -> {
                startActivity(Intent(this, MainActivityAreaCircle::class.java))
            }

            R.id.buttonDiamond -> {
                startActivity(Intent(this, MainActivityAreaDiamond::class.java))
            }

            R.id.buttonPentagon -> {
                startActivity(Intent(this, MainActivityAreaPentagon::class.java))
            }
        }
    }
}