package com.utng.tutorialKotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        btnRegresar.setOnClickListener {//Métoco del botón que te regresa al activity principal
            finish()//Finaliza la actividad
        }

        val temas = intent.getSerializableExtra("segunda") as Segunda //Manda el valor tomado de la lista a este activity

        titulo.text = temas.titulo//Se asigna el valor del arreglo a la etiqueta titulo
        descripcion.text = temas.descripcion//Se asigna el valor del arreglo a la etiqueta de descripcion
        imagen.setImageResource(temas.imaTema)//Se asigna el valor del arreglo a la imagen del tema
        imgCodigo.setImageResource(temas.imaDes)//Se asigna el valor del arreglo al códgo del ejemplo

        supportActionBar!!.title="El Tutorial de Kotlin"//Titulo del activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)//Habilita la flecha de regreso del activity
    }
}
